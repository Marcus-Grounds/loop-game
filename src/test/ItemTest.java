package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.*;

import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;


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


    public void TestAttackOnSlugBySword1() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        d.setNumberOfLoops(15);
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        sword.reduceSlugHealth(enemy);

        assertTrue(0 <= enemy.getCurrentHealth().getCurrHealth() && enemy.getCurrentHealth().getCurrHealth() <= 10);

    }

    public void TestAttackOnSlugBySword2() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        d.setNumberOfLoops(50);
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth().getCurrHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth().getCurrHealth());

    }

    public void TestAttackOnSlugBySword3() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        d.setNumberOfLoops(80);
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth().getCurrHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth().getCurrHealth());

    }

    public void TestIncreaseSlugHealthBeyondMaximum() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        d.setNumberOfLoops(80);
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth().getCurrHealth());
        sword.reduceSlugHealth(enemy);

        assertEquals(0, enemy.getCurrentHealth().getCurrHealth());

        enemy.getCurrentHealth().increaseHealth(30);
        
        assertEquals(10, enemy.getCurrentHealth().getCurrHealth());
    }

    public void TestAttackOnSlugByStake() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Stake stake = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        stake.reduceSlugHealth(enemy);

        assertTrue(5 <= enemy.getCurrentHealth().getCurrHealth() && enemy.getCurrentHealth().getCurrHealth() <= 8);

    }

    public void TestAttackOnSlugByStaff() {
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Pair<Integer, Integer> firstAvailableSlot = d.getFirstAvailableSlotForItem();
        Stake staff = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        Slug enemy = new Slug(new PathPosition(2, d.orderedPath));

        assertEquals(10, enemy.getCurrentHealth());
        staff.reduceSlugHealth(enemy);
        assertEquals(8, enemy.getCurrentHealth());

    }


}
