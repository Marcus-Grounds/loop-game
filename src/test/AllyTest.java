package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Buildings.PathBuildings.BarracksBuilding;
import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class AllyTest {

    @Test
    public void spawnAllyWhenCharacterPassBarrack(){
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(0, 2);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);


        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        Character c = new Character(p1);
        d.setCharacter(c);
        d.addPathBuilding(new BarracksBuilding(p2.getX(), p2.getY()));

        //test fight withough allies
        List<BasicEnemy> enemyList = new ArrayList();
        Slug slug1 = new Slug(p1);
        enemyList.add(slug1);
        d.addBasicEnemy(slug1);
        Battle battle = new Battle(c, null, enemyList, slug1, new ArrayList<BattleBuilding>(), 0);
        battle.dealDamageOnce();
        battle.dealDamageOnce();
        int healthOfCharacterWithoutAlly = c.getCurrentHealth();


        //test that ally will not spaw if character not on barrack
        Ally ally1 = d.pathBuildingAction();
        assertTrue(ally1 == null);

        assertTrue(c.getX() == p1.getX().getValue() || c.getX() == p1.getY().getValue());
        d.runTickMoves();

        //after runTickMove character should have mooved
        assertTrue(c.getX() != p1.getX().getValue() || c.getX() != p1.getY().getValue());
        
        //once character is on barrack, ally should spawn
        Ally ally2 = d.pathBuildingAction();
        assertTrue(ally2 != null);
        
        assertTrue(c.getAllies().size() != 0);


        //now test allie in fight
        
    }


}