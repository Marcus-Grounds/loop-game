package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.javatuples.Pair;

import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;
import unsw.loopmania.Enemies.*;
import unsw.loopmania.GameMode.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;

public class ItemTest {
    @Test
    public void Test1(){
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Sword sword = new Sword(null, null);
        d.addInventoryItem(sword);
        List<Sword> dummyList = new ArrayList<Sword>();
        dummyList.add(sword);
        assertEquals(d.getAllInventoryItems(), dummyList);
    }


                 /////////////////***** Tests for Attacking weapons ****///////////////////

    // Test weapons attacks on slug

    @Test
    public void TestAttackOnSlugBySword1() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));
        assertEquals(10, enemy.getCurrentHealth());

        if (d.getLoopCount() <= 30) {
            sword.reduceSlugHealth(enemy, d);
            assertTrue(0 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 10);
        }
    }

    @Test
    public void TestAttackOnSlugBySword2() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));
        assertEquals(10, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            sword.reduceSlugHealth(enemy, d);
            assertEquals(0, enemy.getCurrentHealth());
        }
        

    }

    @Test
    public void TestAttackOnSlugBySword3() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));
        assertEquals(10, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 61 && d.getLoopCount() <= 100) {
            sword.reduceSlugHealth(enemy, d);
            assertEquals(0, enemy.getCurrentHealth());
        }

    }

    @Test
    public void TestAttackOnSlugByStake() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        stake.reduceSlugHealth(enemy, d);

        assertTrue(5 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 8);

    }

    @Test
    public void TestAttackOnSlugByStaff() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
 
        Staff staff = new Staff(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        staff.reduceSlugHealth(enemy, d);
        assertEquals(8, enemy.getCurrentHealth());

    }

    @Test
    public void TestIncreaseSlugHealthBeyondMaximum() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        enemy.increaseHealth(30);
        
        assertEquals(10, enemy.getCurrentHealth());
    }


    // Test weapons attacks on vampire

    @Test
    public void TestAttackOnVampireBySword1() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));
        assertEquals(100, enemy.getCurrentHealth());

        if (d.getLoopCount() <= 30) {
            sword.reduceVampireHealth(enemy, d);
            assertTrue(90 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 95);
        }
    }

    @Test
    public void TestAttackOnVampireBySword2() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));
        assertEquals(100, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            sword.reduceVampireHealth(enemy, d);
            assertTrue(85 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 90);
        }
    }

    @Test
    public void TestAttackOnVampireBySword3() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));
        assertEquals(100, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 61 && d.getLoopCount() <= 100) {
            sword.reduceVampireHealth(enemy, d);
            assertTrue(80 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 85);
        }
    }

    @Test
    public void TestAttackOnVampireByStake() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        stake.reduceVampireHealth(enemy, d);

        assertEquals(70, enemy.getCurrentHealth());

    }

    @Test
    public void TestAttackOnVampireByStaff() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();

        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Staff staff= new Staff(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        staff.reduceVampireHealth(enemy, d);

        assertEquals(98, enemy.getCurrentHealth());

    }

    @Test
    public void TestIncreaseVampireHealthBeyondMaximum() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());

        enemy.increaseHealth(30);
        
        assertEquals(100, enemy.getCurrentHealth());
    }

    // Test weapons attacks on zombie 

    @Test
    public void TestAttackOnZombieBySword1() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));
        assertEquals(30, enemy.getCurrentHealth());

        if (d.getLoopCount() <= 30) {
            sword.reduceZombieHealth(enemy, d);
            assertTrue(20 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 25);
        }
    }

    @Test
    public void TestAttackOnZombieBySword2() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));
        assertEquals(30, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            sword.reduceZombieHealth(enemy, d);
            assertTrue(15 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 20);
        }
    }

    @Test
    public void TestAttackOnZombieBySword3() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));
        assertEquals(30, enemy.getCurrentHealth());

        if (d.getLoopCount() >= 61 && d.getLoopCount() <= 100) {
            sword.reduceZombieHealth(enemy, d);
            assertTrue(10 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 15);
        }
    }

    @Test
    public void TestAttackOnZombieByStake() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        stake.reduceZombieHealth(enemy, d);

        assertTrue(25 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 28);

    }

    @Test
    public void TestAttackOnZombieByStaff() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);

        Staff staff= new Staff(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        staff.reduceZombieHealth(enemy, d);

        assertEquals(28, enemy.getCurrentHealth());

    }

    @Test
    public void TestIncreaseZombieHealthBeyondMaximum() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());

        enemy.increaseHealth(20);
        
        assertEquals(30, enemy.getCurrentHealth());
    }


                ///////////////////// Tests for Defending weapons ///////////////////////

                
    // Tests for Helmet

    @Test
    public void TestHelmetDefencetoSlug() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceSlugDamage(enemy, c);

        assertEquals(99, c.getCurrentHealth());

    }

    @Test
    public void TestHelmetDefencetoZombie() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceZombieDamage(enemy, c);

        assertEquals(97, c.getCurrentHealth());
    }

    @Test
    public void TestHelmetDefencetoVampire() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceVampireDamage(enemy, c);

        assertEquals(95, c.getCurrentHealth());
    }

    // Tests for Armour

    @Test
    public void TestArmourDefencetoSlug() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Armour armour = new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceSlugDamage(enemy, c);

        assertEquals(99, c.getCurrentHealth());

    }

    @Test
    public void TestArmourDefencetoZombie() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Armour armour = new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceZombieDamage(enemy, c);

        assertEquals(97, c.getCurrentHealth());
    }

    @Test
    public void TestArmourDefencetoVampire() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Armour armour= new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceVampireDamage(enemy, c);

        assertEquals(95, c.getCurrentHealth());
    }



    // Tests for Shield

    @Test
    public void TestShieldDefencetoSlug() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceSlugDamage(enemy, c);

        assertEquals(99, c.getCurrentHealth());

    }

    @Test
    public void TestShieldDefencetoZombie() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceZombieDamage(enemy, c);

        assertEquals(97, c.getCurrentHealth());
    }

    @Test
    public void TestShieldDefencetoVampire() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(0, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(1, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceVampireDamage(enemy, c);

        assertTrue(c.getCurrentHealth() == 95 || c.getCurrentHealth() == 70);
    }

    // Tests for gold
    @Test
    public void TestDecreaseGold() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Gold gold = new Gold(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));

        int currGold = gold.getGoldCount();
        gold.decreaseGold(shield.getCost());
        assertEquals(gold.getGoldCount(), currGold-20);

    }
    
    @Test
    public void TestIncreaseGold() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Gold gold = new Gold(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));

        int currGold = gold.getGoldCount();
        gold.increaseGold(sword.getCost());
        assertEquals(gold.getGoldCount(), currGold+5);
    }


    // Test for HealthPotion refilling Character health
    @Test
    public void TestHealthPotion() {
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(2, 0);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(2, 1);
        orderedPath.add(path1);
        orderedPath.add(path2);
        Character c = new Character(new PathPosition(1, orderedPath));
        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));

        assertTrue(c.getCurrentHealth() == 100);
        c.decreaseHealth(40);
        healthPotion.refillHealth(c);
        assertEquals(100, c.getCurrentHealth());

    }

}
