package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;


import org.javatuples.Pair;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;

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

    public void TestAttackOnSlugBySword1() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(15);
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        sword.reduceSlugHealth(enemy);

        assertTrue(0 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 10);

    }

    public void TestAttackOnSlugBySword2() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(50);
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth());

    }

    public void TestAttackOnSlugBySword3() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(80);
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth());

    }

    public void TestAttackOnSlugByStake() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        stake.reduceSlugHealth(enemy);

        assertTrue(5 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 8);

    }

    public void TestAttackOnSlugByStaff() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
 
        Stake staff = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        staff.reduceSlugHealth(enemy);
        assertEquals(8, enemy.getCurrentHealth());

    }

    public void TestIncreaseSlugHealthBeyondMaximum() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);

        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(80);
        Slug enemy = new Slug(new PathPosition(2, orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth());

        enemy.increaseHealth(30);
        
        assertEquals(10, enemy.getCurrentHealth());
    }

    // Test weapons attacks on vampire

    public void TestAttackOnVampireBySword1() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(15);
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        sword.reduceVampireHealth(enemy);

        assertTrue(90 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 95);

    }

    public void TestAttackOnVampireBySword2() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(50);
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        sword.reduceVampireHealth(enemy);

        assertTrue(85 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 90);

    }

    
    public void TestAttackOnVampireBySword3() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(80);
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        sword.reduceVampireHealth(enemy);

        assertTrue(80 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 85);

    }

    public void TestAttackOnVampireByStake() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        stake.reduceVampireHealth(enemy);

        assertEquals(70, enemy.getCurrentHealth());

    }

    public void TestAttackOnVampireByStaff() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();    
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);

        Staff staff= new Staff(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());
        staff.reduceVampireHealth(enemy);

        assertEquals(98, enemy.getCurrentHealth());

    }

    public void TestIncreaseVampireHealthBeyondMaximum() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(100, enemy.getCurrentHealth());

        enemy.increaseHealth(30);
        
        assertEquals(100, enemy.getCurrentHealth());
    }

    // Test weapons attacks on zombie 

    public void TestAttackOnZombieBySword1() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(15);
        Zombie enemy = new Zombie(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        sword.reduceZombieHealth(enemy);

        assertTrue(20 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 25);

    }

    public void TestAttackOnZombieBySword2() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(50);
        Zombie enemy = new Zombie(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        sword.reduceZombieHealth(enemy);

        assertTrue(15 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 20);

    }

    
    public void TestAttackOnZombieBySword3() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Sword sword = new Sword(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        d.setNumberOfLoops(80);
        Zombie enemy = new Zombie(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        sword.reduceZombieHealth(enemy);

        assertTrue(10 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 15);

    }

    public void TestAttackOnZombieByStake() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Stake stake = new Stake(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        stake.reduceVampireHealth(enemy);

        assertTrue(25 <= enemy.getCurrentHealth() && enemy.getCurrentHealth() <= 28);

    }

    public void TestAttackOnZombieByStaff() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Staff staff= new Staff(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());
        staff.reduceVampireHealth(enemy);

        assertEquals(28, enemy.getCurrentHealth());

    }

    public void TestIncreaseZombieHealthBeyondMaximum() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Vampire enemy = new Vampire(new PathPosition(2, orderedPath));

        assertEquals(30, enemy.getCurrentHealth());

        enemy.increaseHealth(20);
        
        assertEquals(30, enemy.getCurrentHealth());
    }


                /////////////////***** Tests for Defending weapons ****///////////////////

                
    // Tests for Helmet

    public void TestHelmetDefencetoSlug() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceSlugDamage(enemy, c);

        assertEquals(99, c.getCurrentHealth());

    }

    public void TestHelmetDefencetoZombie() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceZombieDamage(enemy, c);

        assertEquals(97, c.getCurrentHealth());
    }

    public void TestHelmetDefencetoVampire() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        helmet.reduceVampireDamage(enemy, c);

        assertEquals(95, c.getCurrentHealth());
    }

    public void TestHelmetReduceEnemyAttackBy5() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Helmet helmet= new Helmet(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        c.getNumberOfAttacks;

        if (c.getNumberOfAttacks <= 5 ) {
            assertEquals(100, c.getCurrentHealth()); 
        }
        else {
            helmet.reduceVampireDamage(enemy, c);
            assertEquals(97, c.getCurrentHealth());
        }  
    }



    // Tests for Armour

    public void TestArmourDefencetoSlug() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Armour armour = new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceSlugDamage(enemy, c);

        assertEquals(99, c.getCurrentHealth());

    }

    public void TestArmourDefencetoZombie() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Armour armour = new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceZombieDamage(enemy, c);

        assertEquals(97.5, c.getCurrentHealth());
    }

    public void TestArmourDefencetoVampire() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Armour armour= new Armour(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        armour.reduceVampireDamage(enemy, c);

        assertEquals(95, c.getCurrentHealth());
    }



    // Tests for Shield

    public void TestShieldDefencetoSlug() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Slug enemy = new Slug(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceSlugDamage(enemy, c);

        assertEquals(100, c.getCurrentHealth());

    }

    public void TestShieldDefencetoZombie() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Zombie enemy = new Zombie(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceZombieDamage(enemy, c);

        assertEquals(98, c.getCurrentHealth());
    }

    public void TestShieldDefencetoVampire() {

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        orderedPath.add(path1);
        Character c = new Character(new PathPosition(4, orderedPath));
        Shield shield = new Shield(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Vampire enemy = new Vampire(new PathPosition(5, orderedPath));

        assertEquals(100, c.getCurrentHealth());
        shield.reduceVampireDamage(enemy, c);

        assertEquals(98, c.getCurrentHealth());
    }

}
