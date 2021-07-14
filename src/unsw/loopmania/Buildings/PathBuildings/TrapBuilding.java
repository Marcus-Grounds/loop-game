package unsw.loopmania.Buildings.PathBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Enemies.BasicEnemy;

public class TrapBuilding extends PathBuilding {

    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void pathAction(MovingEntity character, List<BasicEnemy> enemies) {
        
        for (BasicEnemy b : enemies) {
            if (checkOnPath(b)) {
                b.decreaseHealth(b.getCurrentHealth()/5);
            }
        }
    }
}
