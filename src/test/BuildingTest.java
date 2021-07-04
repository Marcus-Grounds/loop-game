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

public class BuildingTest {
    @Test
    public void Test1(){
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        VampireCastleBuilding vampireCastleBuilding = new VampireCastleBuilding(null, null);
        d.addBuilding(vampireCastleBuilding);
        List<Building> dummyList = new ArrayList<Building>();
        dummyList.add(vampireCastleBuilding);
        assertEquals(d.getAllBuildings(), dummyList);
    }
}
