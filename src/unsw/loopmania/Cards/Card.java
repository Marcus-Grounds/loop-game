package unsw.loopmania.Cards;

import java.lang.reflect.Constructor;
import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

import unsw.loopmania.Buildings.*;
import unsw.loopmania.Buildings.BattleBuildings.*;
import unsw.loopmania.Buildings.PathBuildings.*;
import unsw.loopmania.Buildings.SpawnBuildings.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    // TODO = implement other varieties of card than VampireCastleCard

    private PlacementStrategy placementStrategy;
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y, ImageView image) {
        super(x, y, image);
        this.placementStrategy = null;
    }

    public void setPlacementStrategy (PlacementStrategy placementStrategy) {
        this.placementStrategy = placementStrategy;
    }

    public boolean isPlaceable (int buildingNodeX, int buildingNodeY, List<Pair<Integer, Integer>> Path) {
        return this.placementStrategy.isPlaceable(buildingNodeX, buildingNodeY, Path);
    }

    public Building generateEntity (SimpleIntegerProperty x, SimpleIntegerProperty y) {
        String classname = this.getClass().getName();
        Building generatedEntity = null;
        if (classname.equals("VampireCastleBuilding")) {
            generatedEntity = new VampireCastleBuilding(x, y);
        } else if (classname.equals("ZombiePitBuilding")) {
            generatedEntity = new ZombiePitBuilding(x, y);
        } else if (classname.equals("TowerBuilding")) {
            generatedEntity = new TowerBuilding(x, y);
        } else if (classname.equals("VillageBuilding")) {
            generatedEntity = new VillageBuilding(x, y);
        } else if (classname.equals("BarracksBuilding")) {
            generatedEntity = new BarracksBuilding(x, y);
        } else if (classname.equals("TrapBuilding")) {
            generatedEntity = new TrapBuilding(x, y);
        } else if (classname.equals("CampfireBuilding")) {
            generatedEntity = new CampfireBuilding(x, y);
        }
        return generatedEntity;
    }
}
