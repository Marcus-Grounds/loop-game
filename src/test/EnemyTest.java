package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.ImageView;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
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
    public void testLoot() {
        JFXPanel jfxPanel = new JFXPanel();
        List<BasicItem> lootedItems = new ArrayList<BasicItem>();
        List<Card> cards = new ArrayList<Card>();
        
        for (int i = 0; i < 1000; i++) {
            Slug slug = new Slug(null);
            BasicItem item = slug.giveWeaponWhenLooted(null, null);
            Card card = slug.giveCardWhenLooted(null, null);
            if (item != null){
                lootedItems.add(item);
            }
            if (card != null){
                cards.add(card);
            }
        }

        assertTrue(lootedItems.size() > 0);
        assertTrue(lootedItems.size( ) < 1000);
        assertTrue(cards.size() > 0);
        assertTrue(cards.size() < 1000);

        int swordCount = 0;
        int stakeCount = 0;
        for (BasicItem item: lootedItems) {
            if (item instanceof Sword) {
                swordCount ++;
            }
            else if (item instanceof Stake) {
                stakeCount ++;
            }
        }

        assertTrue(stakeCount < swordCount);
    }
}
