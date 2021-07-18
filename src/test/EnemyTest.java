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
import unsw.loopmania.Buildings.PathBuildings.TrapBuilding;
import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;
import unsw.loopmania.Enemies.Zombie;
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

    /**
     * test that check enemy classes are created correctly
     */
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

        List<BasicEnemy> dummyList = new ArrayList<BasicEnemy>();
        dummyList.add(slug);
        dummyList.add(z);
        dummyList.add(v);
        assertEquals(d.getAllBasicEnemies(), dummyList);
    }

    
    /**
     * test that items are given when we loot enemies
     */
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

        //since looting from enemies is not gaurenteed for each attack, the looted items should be greater than 0, but less than
        //the number of enemies defeated
        assertTrue(lootedItems.size() > 0);
        assertTrue(lootedItems.size( ) < 1000);
        assertTrue(cards.size() > 0);
        assertTrue(cards.size() < 1000);



        List<BasicItem> lootedItems2 = new ArrayList<BasicItem>();
        List<Card> cards2 = new ArrayList<Card>();
        
        for (int i = 0; i < 1000; i++) {
            Zombie zombie= new Zombie(null);
            BasicItem item = zombie.giveWeaponWhenLooted(null, null);
            Card card = zombie.giveCardWhenLooted(null, null);
            if (item != null){
                lootedItems2.add(item);
            }
            if (card != null){
                cards2.add(card);
            }
        }

        assertTrue(lootedItems2.size() > 0);
        assertTrue(lootedItems2.size( ) < 1000);
        assertTrue(cards2.size() > 0);
        assertTrue(cards2.size() < 1000);


        List<BasicItem> lootedItems3 = new ArrayList<BasicItem>();
        List<Card> cards3 = new ArrayList<Card>();
        
        for (int i = 0; i < 1000; i++) {
            Vampire vampire= new Vampire(null);
            BasicItem item = vampire.giveWeaponWhenLooted(null, null);
            Card card = vampire.giveCardWhenLooted(null, null);
            if (item != null){
                lootedItems3.add(item);
            }
            if (card != null){
                cards3.add(card);
            }
        }

        assertTrue(lootedItems3.size() > 0);
        assertTrue(lootedItems3.size() < 1000);
        assertTrue(cards3.size() > 0);

        int trapCount = 0;
        int campFireCount = 0;
        
        for (Card card: cards3) {
            if (card instanceof TrapCard) {
                trapCount ++;
            }
            else if (card instanceof CampfireCard){
                campFireCount ++;
            }
        }
    }

    /**
     * test tha movement of enemies
     */
    @Test
    public void testEnemyMove() {

        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        //List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            orderedPath.add(new Pair<Integer,Integer>(0, i));
        }


        Slug slug = new Slug (new PathPosition(100, orderedPath) );
        for (int i = 0; i < 500; i++){
            slug.move();
            slug.getPathPosition().resetCoordinatesBasedOnPositionInPath();
        }

        Zombie zombie= new Zombie( new PathPosition(100, orderedPath) );
        for (int i = 0; i < 500; i++){
            zombie.move();
            zombie.getPathPosition().resetCoordinatesBasedOnPositionInPath();
        }

        Vampire vampire = new Vampire( new PathPosition(100, orderedPath) );
        for (int i = 0; i < 500; i++){
            vampire.move();
            vampire.getPathPosition().resetCoordinatesBasedOnPositionInPath();
        }
        
        //slug should have remained at the same spot approximately, zombie whould have moved forwrds slowly, vampire 
        System.out.println("\n");
        System.out.println(slug.getY());
        System.out.println(zombie.getY());
        System.out.println(vampire.getY());
        //slug should stay at approx the same spot, zombie moves 250 steps, vampire 450
        assertEquals(100, slug.getY(), 50);
        assertEquals(350, zombie.getY(), 50);
        assertEquals(550, vampire.getY(), 50);

        assertTrue(slug.getY() < zombie.getY());
        assertTrue(zombie.getY() < vampire.getY());
    }
}
