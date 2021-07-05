package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

import unsw.loopmania.*;

import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class EnemyTest {
    
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
}
