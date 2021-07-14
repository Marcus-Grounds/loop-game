package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * Basic Items
 */
public class BasicItem extends StaticEntity  {

    private int costOfItem;
    
    public BasicItem(SimpleIntegerProperty x, SimpleIntegerProperty y, int costOfItem) {
        super(x, y);
        this.costOfItem = costOfItem;
    } 

    public int getCost() {
        return costOfItem;
    }
}