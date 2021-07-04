package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped staff in the backend world
 */
public class Staff extends StaticEntity implements AttackingStrategy {
    
    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    
}