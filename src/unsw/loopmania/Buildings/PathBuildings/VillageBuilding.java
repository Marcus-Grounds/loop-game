package unsw.loopmania.Buildings.PathBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Enemies.BasicEnemy;

public class VillageBuilding extends PathBuilding {

    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void pathAction(MovingEntity character, List<BasicEnemy> enemies) {
        
        if (checkOnPath(character)) {
            character.increaseHealth(20);
        }
        
    }
}
