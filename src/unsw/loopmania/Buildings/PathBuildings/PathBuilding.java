package unsw.loopmania.Buildings.PathBuildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Enemies.BasicEnemy;

public abstract class PathBuilding extends Building{

    public PathBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
    
    public abstract void pathAction (MovingEntity character, List<BasicEnemy> enemies);
    public boolean checkOnPath (MovingEntity entity) {
        
        if ((entity.getX() == this.getX()) && (entity.getY() == this.getY())) {
            return true;
        } else {
            return false;
        }
    }
}
