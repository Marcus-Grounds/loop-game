package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.javatuples.Pair;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class CardTest {

    @Test
    public void Test1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(2, 0);
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        Character c = new Character(null);
        d.setCharacter(c);

        Card vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(vampireCastleCard);

        assertEquals(vampireCastleCard, d.getCardByIndex(0));
    }

    public void Test2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(2, 0);
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);
        
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        Character c = new Character(null);
        d.setCharacter(c);

        Card zombiiePitCard = new ZombiePitCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(zombiiePitCard);

        Card campfireCard = new CampfireCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(campfireCard);

        assertEquals(zombiiePitCard, d.getCardByIndex(0));
        assertEquals(campfireCard, d.getCardByIndex(1));
    }

    @Test
    public void Test3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 2);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(1, 3);
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);

        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(10, 10, orderedPath);
        Character c = new Character(null);
        d.setCharacter(c);

        Card towerCard = new TowerCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(towerCard);
        d.convertCardToBuildingByCoordinates(5, 5, 1, 4);
        assertEquals(0, d.getAllCards().size());
        assertEquals(1, d.getAllBattleBuildings().size());
        assertEquals(1, d.getAllBuildings().size());
    }

    @Test
    public void Test4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 2);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(1, 3);
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);

        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(10, 10, orderedPath);
        Character c = new Character(null);
        d.setCharacter(c);

        Card towerCard = new TowerCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(towerCard);
        d.convertCardToBuildingByCoordinates(5, 5, 1, 3);
        assertEquals(1, d.getAllCards().size());
        assertEquals(0, d.getAllBattleBuildings().size());
        assertEquals(0, d.getAllBuildings().size());
    }
}
