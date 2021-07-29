package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import unsw.loopmania.*;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Cards.*;
import unsw.loopmania.Character.Character;
import unsw.loopmania.Character.RegularState;
import unsw.loopmania.Character.StunnedState;
import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class DoggieTests {
    //test that value of a dogecoin varies
    /*
    @Test
    public void TestDoggieCoinValue(){
        JFXPanel jfxPanel = new JFXPanel();
        DoggieCoin doggieCoin = new DoggieCoin(null, null);
        int value1 = doggieCoin.getValue();
        int value2 = doggieCoin.getValue();
        
        assertTrue(value1 != value2);
    }
    */

    @Test
    public void TestDoggieSpawn() {
        JFXPanel jfxPanel = new JFXPanel();

        Doggie doggie = new Doggie(null);
        assertTrue(doggie.onDeath(null, null) instanceof DoggieCoin);
        
    }

    /**
     * test that when a doggie and other enemies are in a battle with character, character is sometimes stunned
     */
    @Test
    public void TestDoggieStun() {
        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(1, 2);
        
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        PathPosition p3 = new PathPosition(2, orderedPath);


        Vampire v1 = new Vampire(p3);
        enemies.add(v1);
        Slug s1 = new Slug(p1);
        enemies.add(s1);
        Zombie z1 = new Zombie(p1);
        enemies.add(z1);
        Doggie d1 = new Doggie(p2);
        enemies.add(d1);

        Character c = new Character(p2);

        Battle battle = new Battle(c, null, enemies, d1, new ArrayList<BattleBuilding>(), 0);
        assertTrue(c.getState() instanceof RegularState);
        battle.dealDamageOnce();
        assertTrue(c.getState() instanceof StunnedState);
        battle.dealDamageOnce();
     
    }
}
