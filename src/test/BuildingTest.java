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
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Buildings.BattleBuildings.CampfireBuilding;
import unsw.loopmania.Buildings.BattleBuildings.TowerBuilding;
import unsw.loopmania.Buildings.PathBuildings.BarracksBuilding;
import unsw.loopmania.Buildings.PathBuildings.PathBuilding;
import unsw.loopmania.Buildings.PathBuildings.TrapBuilding;
import unsw.loopmania.Buildings.PathBuildings.VillageBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.SpawnBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.ZombiePitBuilding;
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
        
        VampireCastleBuilding vampireCastleBuilding = new VampireCastleBuilding(null, null);
        TowerBuilding towerBuilding = new TowerBuilding(null, null);
        TrapBuilding trapBuilding = new TrapBuilding(null, null);

        d.addSpawnBuilding(vampireCastleBuilding);
        d.addBattleBuilding(towerBuilding);
        d.addPathBuilding(trapBuilding);

        List<BattleBuilding> dummyList = new ArrayList<BattleBuilding>();
        List<SpawnBuilding> dummyList2 = new ArrayList<SpawnBuilding>();
        List<PathBuilding> dummyList3 = new ArrayList<PathBuilding>();

        dummyList.add(towerBuilding);
        dummyList2.add(vampireCastleBuilding);
        dummyList3.add(trapBuilding);
        
        assertEquals(d.getAllBattleBuildings(), dummyList);
        assertEquals(d.getAllSpawnBuildings(), dummyList2);
        assertEquals(d.getAllPathBuildings(), dummyList3);

    }

    @Test
    public void spawnVampireFromBuilding(){
        
        //Create a battle between the character and enemy where enemy is in range of tower, not in range of tower
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create Vampire Castle
        
        VampireCastleBuilding vampireCastle = new VampireCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(5));
        HerosCastle herosCastle = new HerosCastle(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));

        d.addSpawnBuilding(vampireCastle);
        d.setCastle(herosCastle);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(0,5);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        
        Character c = new Character(p1);
        d.setCharacter(c);

        // search through the list of enemies and determine if it is spawned on the path
        assertEquals(vampireCastle.findPathToSpawn(orderedPath), path2);
        assertEquals(d.checkCharacterOnCastle(c), true);

        BasicEnemy vampire = vampireCastle.spawnAction(5,d.checkCharacterOnCastle(c), vampireCastle.findPathToSpawn(orderedPath), orderedPath); 
        //Check if vampires spawn in correct position
        
        assertEquals(vampire.getX(), 0);
        assertEquals(vampire.getY(), 5);
    }

    @Test
    public void spawnZombieFromBuilding(){
        
        //Create a battle between the character and enemy where enemy is in range of tower, not in range of tower
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create Vampire Castle
        
        HerosCastle herosCastle = new HerosCastle(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        ZombiePitBuilding zombiePit = new ZombiePitBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(5));

        d.addSpawnBuilding(zombiePit);
        d.setCastle(herosCastle);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(0,4);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        
        Character c = new Character(p1);
        d.setCharacter(c);

        // search through the list of enemies and determine if it is spawned on the path
        assertEquals(zombiePit.findPathToSpawn(orderedPath), path2);
        assertEquals(d.checkCharacterOnCastle(c), true);

        BasicEnemy zombie = zombiePit.spawnAction(5,d.checkCharacterOnCastle(c), zombiePit.findPathToSpawn(orderedPath), orderedPath); 
        //Check if vampires spawn in correct position
        
        assertEquals(zombie.getX(), 0);
        assertEquals(zombie.getY(), 4);
    }

    @Test
    public void towerAttackTest() {

        //Create a battle between the character and enemy where enemy is in range of tower, not in range of tower
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create tower
        TowerBuilding towerBuilding1 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        TowerBuilding towerBuilding2 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(4));
        TowerBuilding towerBuilding3 = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(7));
        
        d.addBattleBuilding(towerBuilding1);
        d.addBattleBuilding(towerBuilding2);
        d.addBattleBuilding(towerBuilding3);

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
        d.addPathBuilding(villageBuilding);

        Character c = new Character(p1);
        d.setCharacter(c);
        c.decreaseHealth(50);

        assertEquals(c.getCurrentHealth(), 50);

        d.runTickMovesCharacter();

        assertEquals(c.getCurrentHealth(), 70);

        d.runTickMoves();
        assertEquals(c.getCurrentHealth(), 70);
    }

    @Test
    public void trapTest() {
        
        // trap should decrease the characters health by 20 percent
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Demonstrates enemy losing health when passing through trap
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();

        //Path for enemy
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);

        orderedPath.add(path1);
        orderedPath.add(path2);
        
        //Path for character so it does not interact with enemy
        PathPosition p1 = new PathPosition(0, orderedPath);

        //Create village
        TrapBuilding trapBuilding = new TrapBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(0));
        d.addPathBuilding(trapBuilding);

        // Should do nothing even if there are no enemies
        d.runTickMovesEnemies();
        
        Vampire v = new Vampire(p1);
        d.addBasicEnemy(v);

        assertEquals(v.getCurrentHealth(), HIGH_HEALTH);

        d.runTickMovesEnemies(); // just in case the enemy stays in the same position 
        d.runTickMovesEnemies(); // accounts for the random factor for now
        d.runTickMovesEnemies();
        d.runTickMovesEnemies();
        d.runTickMovesEnemies();

        assertTrue(v.getCurrentHealth() < HIGH_HEALTH);
    }

    @Test
    public void campfireTest() {
        
        //Create a battle between the character and enemy where character is in range of campfire
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        //Create tower
        CampfireBuilding campfireBuilding = new CampfireBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        
        d.addBattleBuilding(campfireBuilding);

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
        
        //Should double the health of base damge of the player
        assertEquals(s1.getCurrentHealth(), LOW_HEALTH - 2*BASE_DAMEGE);
        assertEquals(c.getCurrentHealth(), START_HEALTH - LOW_DAMAGE);
    }

    @Test
    public void barracksTest() {
        
        // Test whether or not an ally is gained after the character passes through it
        
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        
        BarracksBuilding barracksBuilding = new BarracksBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(0));
        
        d.addPathBuilding(barracksBuilding);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(0, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(2, 0);

        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);
 
        PathPosition p1 = new PathPosition(0, orderedPath);
        
        Character c = new Character(p1);
        d.setCharacter(c);
        
        assertEquals(d.getAllAllies().isEmpty(), true);
        
        d.runTickMovesCharacter();
        assertEquals(d.getAllAllies().isEmpty(), false);

        d.runTickMovesCharacter();
        assertEquals(d.getAllAllies().isEmpty(), false);
    }
}
