package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.discovery.predicates.IsTestMethod;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class BuildingTest {
    
    public static final int START_HEALTH = 100;
    public static final int START_EXP = 0;
    public static final int START_GOLD = 0;
    public static final int  BASE_DAMEGE = 5;
    
    public static final int LOW_HEALTH = 10;
    public static final int MED_HEALTH = 30;
    public static final int HIGH_HEALTH = 100;

    public static final int LOW_DAMAGE = 2;
    public static final int MED_DAMAGE = 5;
    public static final int HIGH_DAMAGE = 10;

    public static final int LOW_EXP = 1;
    public static final int MED_EXP = 2;
    public static final int HIGH_EXP = 5;

    public static final int LOW_GOLD = 1;
    public static final int MED_GOLD = 2;
    public static final int HIGH_GOLD = 3;

    public static final int SHORT_RADIUS = 1;
    public static final int MED_RADIUS = 3;
    public static final int LONG_RADIUS = 5;
    
    
    @Test
    public void addBuildingTest(){
        
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Building vampireCastleBuilding = new VampireCastleBuilding(null, null);
        Building towerBuilding = new TowerBuilding(null, null);

        d.addBuilding(vampireCastleBuilding);
        d.addBuilding(towerBuilding);

        List<Building> dummyList = new ArrayList<Building>();
        dummyList.add(vampireCastleBuilding);
        dummyList.add(towerBuilding);
        assertEquals(d.getAllBuildings(), dummyList);
    }

    @Test
    public void towerAttackTest() {

        //Create a battle between the character and enemy where enemy is in range of tower, not in range of tower
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create tower
        TowerBuilding towerBuilding1 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        TowerBuilding towerBuilding2 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(6));
        TowerBuilding towerBuilding3 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(7));
        
        d.addBuilding(towerBuilding1);
        d.addBuilding(towerBuilding2);
        d.addBuilding(towerBuilding3);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        
        Character c = new Character(p1);
        d.setCharacter(c);
        
        Vampire v1 = new Vampire(p2);
        d.addBasicEnemy(v1);
        
        d.runBattle(v1);
        
        //SHOULD ONLY REGISTER DAMAGE FROM 2 TOWERS AS ONE IS OUT OF RANGE
        assertEquals(v1.getCurrentHealth(), HIGH_HEALTH - BASE_DAMEGE - 2*towerBuilding1.getDamage());
        assertEquals(c.getCurrentHealth(), START_HEALTH - HIGH_DAMAGE);
    }

    @Test
    public void villageTest() {
        
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Demonstrates player gaining health when passing through village
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();

        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(2, 0);

        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);
        
        PathPosition p1 = new PathPosition(0, orderedPath);

        //Create village
        VillageBuilding villageBuilding = new VillageBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(0));
        d.addBuilding(villageBuilding);

        Character c = new Character(p1);
        d.setCharacter(c);
        c.decreaseHealth(50);

        assertEquals(c.getCurrentHealth(), 50);

        d.runTickMoves();
        d.runTickMoves();

        assertEquals(c.getCurrentHealth(), 70);

        d.runTickMoves();
        assertEquals(c.getCurrentHealth(), 70);
    }

    @Test
    public void trapTest() {
        
        // trap should decrease the characters health by 20 percent
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Demonstrates player gaining health when passing through village
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();

        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);

        orderedPath.add(path1);
        orderedPath.add(path2);
        
        PathPosition p1 = new PathPosition(0, orderedPath);

        //Create village
        TrapBuilding trapBuilding = new TrapBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(0));
        d.addBuilding(trapBuilding);

        Vampire v = new Vampire(p1);
        d.addBasicEnemy(v);

        assertEquals(v.getCurrentHealth(), HIGH_HEALTH);

        v.move(); // just in case the enemy stays in the same position 
        v.move(); // accounts for the random factor for now
        v.move();
        v.move();
        v.move();

        assertTrue(v.getCurrentHealth() < HIGH_HEALTH);
    }

    @Test
    public void campfireTest() {
        
        //Create a battle between the character and enemy where character is in range of campfire
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create tower
        CampfireBuilding campfireBuilding = new CampfireBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        
        d.addBuilding(campfireBuilding);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        
        Character c = new Character(p1);
        d.setCharacter(c);
        
        Slug s1 = new Slug(p2);
        d.addBasicEnemy(s1);
        
        d.runBattle(s1);
        
        //SHOULD ONLY REGISTER DAMAGE FROM 2 TOWERS AS ONE IS OUT OF RANGE
        assertEquals(s1.getCurrentHealth(), HIGH_HEALTH - 2*BASE_DAMEGE);
        assertEquals(c.getCurrentHealth(), START_HEALTH - HIGH_DAMAGE);
    }

    @Test
    public void barracksTest() {
        
        //Create a battle between the character and enemy where character is in range of campfire
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create tower
        BarracksBuilding barracksBuilding = new BarracksBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(0));
        
        d.addBuilding(barracksBuilding);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(2, 0);

        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);


        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        PathPosition p3 = new PathPosition(2, orderedPath);

        
        Character c = new Character(p1);
        d.setCharacter(c);
        
        assertEquals(d.getAllAllies().isEmpty(), true);
        
        d.runTickMoves();
        assertEquals(d.getAllAllies().isEmpty(), false);

        d.runTickMoves();
        assertEquals(d.getAllAllies().isEmpty(), false);
    }
}
