package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.core.IsInstanceOf;
import org.javatuples.Pair;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Buildings.PathBuildings.BarracksBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.SpawnBuildings.ZombiePitBuilding;
import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class LoopManiaWorldTest {
    @Test
    public void pathTests() {
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(2, 2);
        
        orderedPath.add(path1);


        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);

        assertTrue(d.isOnPath(new Pair(2,2)));
        assertFalse(d.isOnPath(new Pair(2,0)));
        assertFalse(d.isOnPath(new Pair(0,2)));
        assertFalse(d.isOnPath(new Pair(1,1)));

        assertTrue(d.isAdjacentToPath(new Pair(1,1)));
        //not adjecent to pathtile itself
        assertFalse(d.isAdjacentToPath(new Pair(2,2)));
        
        assertFalse(d.isAdjacentToPath(new Pair(0,0)));
        assertTrue(d.isAdjacentToPath(new Pair(1,2)));
        assertTrue(d.isAdjacentToPath(new Pair(2,1)));
    }
    
    @Test
    public void goldTest() {
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        orderedPath.add( new Pair<Integer,Integer>(0, 0));
        orderedPath.add( new Pair<Integer,Integer>(0, 1));
        orderedPath.add( new Pair<Integer,Integer>(0, 2));
        orderedPath.add( new Pair<Integer,Integer>(0, 3));
        orderedPath.add( new Pair<Integer,Integer>(0, 4));
        orderedPath.add( new Pair<Integer,Integer>(0, 5));

        PathPosition p1 = new PathPosition(0, orderedPath);

        
        Character c = new Character(p1);
        c.addAlly(new Ally(p1, 100));

        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        d.setCharacter(c);
        
        assertTrue(d.getGoldCount() == 0);

        for (int i = 0; i < 1000; i ++){
            d.possiblySpawnGold();
            d.runTickMoves();
        }
        assertTrue(d.getGoldCount() > 0);
        //expect 50 gold, but since random, accept margin of error
        assertEquals(d.getGoldCount(), 50, 30);
        
    }

    @Test
    public void potionTest() {
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        orderedPath.add( new Pair<Integer,Integer>(0, 0));
        orderedPath.add( new Pair<Integer,Integer>(0, 1));
        orderedPath.add( new Pair<Integer,Integer>(0, 2));
        orderedPath.add( new Pair<Integer,Integer>(0, 3));
        orderedPath.add( new Pair<Integer,Integer>(0, 4));
        orderedPath.add( new Pair<Integer,Integer>(0, 5));

        PathPosition p1 = new PathPosition(0, orderedPath);

        
        Character c = new Character(p1);

        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        d.setCharacter(c);
        c.decreaseHealth(80);

        
        assertTrue(c.getCurrentHealth() == 20);

        for (int i = 0; i < 1000; i ++){
            d.possiblySpawnHealthPotion();
            d.runTickMoves();
        }
        assertTrue(c.getCurrentHealth() == 100);
    }

    @Test
    public void slugSpawnTest() {
        //test that without zombie pits or vampire castles, only slugs spawn
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        orderedPath.add( new Pair<Integer,Integer>(0, 0));
        orderedPath.add( new Pair<Integer,Integer>(0, 1));
        orderedPath.add( new Pair<Integer,Integer>(0, 2));
        orderedPath.add( new Pair<Integer,Integer>(0, 3));
        orderedPath.add( new Pair<Integer,Integer>(0, 4));
        orderedPath.add( new Pair<Integer,Integer>(0, 5));

        PathPosition p1 = new PathPosition(0, orderedPath);

        Character c = new Character(p1);

        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        d.setCharacter(c);
        for (int i = 0; i < 1000; i ++){
            d.possiblySpawnEnemies();
        }
        assertTrue(d.getAllBasicEnemies().size() == 5);
    }

    @Test
    public void testSpawnWithBuildings() {
        JFXPanel jfxPanel = new JFXPanel();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
            
        orderedPath.add( new Pair<Integer,Integer>(0, 0));
        orderedPath.add( new Pair<Integer,Integer>(0, 1));
        orderedPath.add( new Pair<Integer,Integer>(0, 2));
        orderedPath.add( new Pair<Integer,Integer>(0, 3));
        orderedPath.add( new Pair<Integer,Integer>(0, 4));
        orderedPath.add( new Pair<Integer,Integer>(0, 5));

        PathPosition p1 = new PathPosition(0, orderedPath);

        Character c = new Character(p1);

        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        d.setCharacter(c);
        d.addSpawnBuilding(new ZombiePitBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1)));
        d.addSpawnBuilding(new VampireCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(2)));

        for (int i = 0; i < 100; i ++){
            d.possiblySpawnEnemies();
            d.runTickMoves();
        }

        int vampireCount = 0;
        int zombieCount = 0;
        //should compelte loop 16 times, expect 16 zombies and 3 ish vampires
        for (BasicEnemy e: d.getAllBasicEnemies()) {
            if (e instanceof Vampire){
                vampireCount ++;
            }
            else if (e instanceof Zombie) {
                zombieCount ++;
            }
        }

        assertEquals(16, zombieCount, 3);
        assertEquals(3, vampireCount, 1);
    }

    @Test
    public void unequippedInventoryTest() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, null);
        Character c = new Character(null);
        d.setCharacter(c);
        assertTrue(c.getAllInventoryItems().size() == 0);
        assertTrue(c.getGoldCount() == 0);
        for (int i = 0; i < 200; i++){
            d.addUnequippedItem(new Slug(null));
        }
        assertTrue(c.getAllInventoryItems().size() != 0);
        assertTrue(c.getGoldCount() > 0);
    }

    /**
     * test the adding and removing of cards
     */
    @Test
    public void testLoadandRemveCard() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, null);
        Character c = new Character(null);
        d.setCharacter(c);

        int cardCount = 0;
        for (int i = 0; i < 200; i++){
            Card card = d.loadCard(new Slug(null));
            if (card != null){
                cardCount++;
            }
        }
        assertTrue(cardCount > 0);
        int sizeBeforeRemoval = d.getAllCards().size();
        d.removeCard(0);
        int sizeAfterRemoval = d.getAllCards().size();
        assertTrue(sizeAfterRemoval == sizeBeforeRemoval - 1);
    }
}
