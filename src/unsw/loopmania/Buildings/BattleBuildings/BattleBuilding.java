package unsw.loopmania.Buildings.BattleBuildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Buildings.Building;

public abstract class BattleBuilding extends Building {
    
    private int radius;

    public BattleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public abstract boolean checkRadius(MovingEntity entity);
    public abstract void buildingAction(MovingEntity character, MovingEntity enemy);

    public void setRadius (int radius) {
        this.radius = radius;
    }

    public int getRadius () {
        return this.radius;
    }
    
}
