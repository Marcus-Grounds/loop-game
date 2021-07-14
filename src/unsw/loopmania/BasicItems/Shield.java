package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends StaticEntity implements DefendingStrategy {
    
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    
}