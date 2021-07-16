package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class TrapCard extends Card {
    // TODO = add more types of card
    public TrapCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.setPlacementStrategy(new OnlyOnPathStrategy());
    }    
}
