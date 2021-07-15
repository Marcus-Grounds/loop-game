package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.javatuples.Pair;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class BattleTest {
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
        JFXPanel jfxPanel = new JFXPanel();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        assertEquals(d.getWidth(), 50);
        assertEquals(d.getHeight(), 30);
    }
    /*
    @Test
    public void TestWeaponSpawningAfterBattle(){
        JFXPanel jfxPanel = new JFXPanel();
        

        //test battle
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld d = new LoopManiaWorld(50, 30, orderedPath);
        
        Pair<Integer, Integer> path1 = new Pair<Integer,Integer>(1, 1);
        Pair<Integer, Integer> path2 = new Pair<Integer,Integer>(1, 0);
        
        orderedPath.add(path1);
        orderedPath.add(path2);

        PathPosition p1 = new PathPosition(0, orderedPath);
        PathPosition p2 = new PathPosition(1, orderedPath);

        Character c = new Character(p2);
        d.setCharacter(c);

        //test that at the beginning the character has no items in the inventory
        List<Entity> unequippedInventoryItems = c.getAllInventoryItems();
        assertTrue(unequippedInventoryItems.size() == 0);

        //spawn slug and character next to eachother
        LoopManiaWorldController controller = new LoopManiaWorldController(d, new ArrayList<>(), null, null, null);
        
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopManiaView.fxml"));
        gameLoader.setController(controller);

        //Now the character will repeatedly attack slugs (until character dies, which should be 25 slugs attacked)
        int i = 0;
        while (i <= 1000) {
            //makes sure character doesnt die
            c.increaseHealth(100);
            Slug s1 = new Slug(p1);
            d.addBasicEnemy(s1);
            enemies.add(s1);
            //BattleEnemyController battleEnemyController = new BattleEnemyController();
            Battle battle = new Battle(c, null, enemies, s1, new ArrayList<BattleBuilding>());
            battle.dealDamageOnce();
            List<BasicEnemy> defeatedEnemies = battle.getDefeatedEnemies();
            
            for (BasicEnemy enemy : defeatedEnemies) {
                controller.reactToEnemyDefeat(enemy);
            }  
            i ++;
        }

        //after attacking 1000 enemies, the character should have at least gained one weapon, however, we also want to 
        //make sure that the character does not gain a weapon each time an enemy is fought (only gains weapon sometimes)
        assertTrue(c.getAllInventoryItems().size() > 0);
        assertTrue(c.getAllInventoryItems().size( )<= 1000);

        //checks that the number of stakes gained is lower than the number of swords, because stakes are rearer than swords
        int swordCount = 0;
        int stakeCount = 0;
        for (Entity thing: unequippedInventoryItems) {
            if (thing instanceof Sword) {
                swordCount ++;
            }
            else if (thing instanceof Stake) {
                stakeCount ++;
            }
        }

        //assertTrue(stakeCount == swordCount);
    }
    */
    @Test
    public void TestBattleSlug(){
        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
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
        enemies.add(s1);
        Character c = new Character(p2);

        //spawn another slug far away from character
        Slug s2 = new Slug(p3);
        enemies.add(s2);

        BattleEnemyController battleEnemyController = new BattleEnemyController();
        Battle battle = new Battle(c, battleEnemyController, enemies, s1, new ArrayList<BattleBuilding>());
        battle.dealDamageOnce();
        

       
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
        //LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
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
        enemies.add(v1);
        Character c = new Character(p2);

        //d.runBattles(null);
        Battle battle = new Battle(c, null, enemies, v1, new ArrayList<BattleBuilding>());
        battle.dealDamageOnce();
        assertTrue(v1.getCurrentHealth() == HIGH_HEALTH);
        assertTrue(c.getCurrentHealth() == START_HEALTH);

        
        //spawn slug and character next to eachother, should trigger zombie to join
        Slug s1 = new Slug(p1);
        enemies.add(s1);
        Battle battle1 = new Battle(c, null, enemies, s1,  new ArrayList<BattleBuilding>());
        battle1.dealDamageOnce();

        //d.runBattles(new LoopManiaWorldController(world, initialEntities);

        //test that after battle, health of both character and slug is decreased
        assertTrue(v1.getCurrentHealth() < HIGH_HEALTH);
        assertTrue(c.getCurrentHealth() < START_HEALTH);
        assertTrue(s1.getCurrentHealth() < LOW_HEALTH);
        
    }

    @Test
    public void TestBattleWithWeapons(){

        JFXPanel jfxPanel = new JFXPanel();
        //test battle
        //LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
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
        enemies.add(v1);
        Character c = new Character(p2);
        c.changeEquippedWeapon(new Sword(null, null));

        //d.runBattles(null);
        Battle battle = new Battle(c, null, enemies, v1, new ArrayList<BattleBuilding>());
        battle.dealDamageOnce();
        assertTrue(v1.getCurrentHealth() == HIGH_HEALTH);
        assertTrue(c.getCurrentHealth() == START_HEALTH);

        
        //spawn slug and character next to eachother, should trigger zombie to join
        Slug s1 = new Slug(p1);
        enemies.add(s1);
        Battle battle1 = new Battle(c, null, enemies, s1,  new ArrayList<BattleBuilding>());
        battle1.dealDamageOnce();

        //d.runBattles(new LoopManiaWorldController(world, initialEntities);

        //test that after battle, health of both character and slug is decreased
        assertTrue(v1.getCurrentHealth() < HIGH_HEALTH - c.getBaseDamage());
        assertTrue(c.getCurrentHealth() < START_HEALTH);
        assertTrue(s1.getCurrentHealth() < LOW_HEALTH - c.getBaseDamage());
    }
}
