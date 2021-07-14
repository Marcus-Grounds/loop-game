package unsw.loopmania;

import unsw.loopmania.Character;
import javafx.beans.property.SimpleIntegerProperty;

public class HealthPotion extends StaticEntity {

    public static final int COST = 40;
    
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y);
    }

    public int getCost() {
        return COST;
    }

    public void refillHealth(Character c) {
        c.increaseHealth(100);
    }
   
}
