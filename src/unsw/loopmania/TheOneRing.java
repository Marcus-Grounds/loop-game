package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Basic Items
 */
public class TheOneRing extends StaticEntity  {
    
    public TheOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y);
    }

    public void setCharacterHealthToMAX(Character c) {
        c.increaseHealth(100);
    }
   
}