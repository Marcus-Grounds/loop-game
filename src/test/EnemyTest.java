package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class EnemyTest {
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
    public void Test1(){
        //not 100 percent sure why this line is here, but without it gets error about graphics : )
        JFXPanel jfxPanel = new JFXPanel();

        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Slug slug = new Slug(null);
        d.addBasicEnemy(slug);
        Zombie z = new Zombie(null);
        d.addBasicEnemy(z);
        Vampire v = new Vampire(null);
        d.addBasicEnemy(v);

        assertEquals(slug.getCurrentHealth(), LOW_HEALTH);
        assertEquals(slug.getAttackRadius(), SHORT_RADIUS);
        assertEquals(slug.getSupportRadius(), SHORT_RADIUS);
        assertEquals(slug.getDamage(), LOW_DAMAGE);

        assertEquals(z.getCurrentHealth(), MED_HEALTH);
        assertEquals(z.getAttackRadius(), MED_RADIUS);
        assertEquals(z.getSupportRadius(), MED_RADIUS);
        assertEquals(z.getDamage(), MED_DAMAGE);

        assertEquals(v.getCurrentHealth(), HIGH_HEALTH);
        assertEquals(v.getAttackRadius(), MED_RADIUS);
        assertEquals(v.getSupportRadius(), LONG_RADIUS);
        assertEquals(v.getDamage(), HIGH_DAMAGE);

        List<BasicEnemy> dummyList = new ArrayList<BasicEnemy>();
        dummyList.add(slug);
        dummyList.add(z);
        dummyList.add(v);
        assertEquals(d.getAllBasicEnemies(), dummyList);
    }

    @Test
    public void TestBattleSlug(){
        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(5, 0);
        
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        PathPosition p3 = new PathPosition(2, orderedPath);

        //spawn slug and character next to eachother
        Slug s1 = new Slug(p1);
        d.addBasicEnemy(s1);
        Character c = new Character(p2);
        d.setCharacter(c);

        //spawn another slug far away from character
        Slug s2 = new Slug(p3);
        d.addBasicEnemy(s2);

        //d.runBattles(new LoopManiaWorldController(world, initialEntities);
        d.runBattles();
        //test that after battle, health of both character and slug is decreased
        assertTrue(s1.getCurrentHealth() < LOW_HEALTH);
        assertTrue(c.getCurrentHealth() < START_HEALTH);

        //slug2 uneffected because it's far away from battle
        assertEquals(s2.getCurrentHealth(), LOW_HEALTH);

    }

    @Test
    public void TestBattleSupportRadius(){

        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        Pair<Integer, Integer> path3 = new Pair<Integer,Integer>(5, 0);
        
        orderedPath.add(path1);
        orderedPath.add(path2);
        orderedPath.add(path3);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);
        PathPosition p3 = new PathPosition(2, orderedPath);

        //spawn a vampire that is 4 units away from character. Within support radius, but not battle radius.
        Vampire v1 = new Vampire(p3);
        d.addBasicEnemy(v1);
        Character c = new Character(p2);
        d.setCharacter(c);

        d.runBattles();
        assertTrue(v1.getCurrentHealth() == HIGH_HEALTH);
        assertTrue(c.getCurrentHealth() == START_HEALTH);

    
        //spawn slug and character next to eachother, should trigger vampire to join
        Slug s1 = new Slug(p2);
        d.addBasicEnemy(s1);
        d.runBattles();

        //d.runBattles(new LoopManiaWorldController(world, initialEntities);

        //test that after battle, health of both character and slug is decreased
        assertTrue(v1.getCurrentHealth() < HIGH_HEALTH);
        assertTrue(c.getCurrentHealth() < START_HEALTH);
        assertTrue(s1.getCurrentHealth() < LOW_HEALTH);
        
    }
}
