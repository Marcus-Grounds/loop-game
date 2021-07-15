package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * represents a vampire castle card in the backend game world
 */
public class CampfireCard extends Card {
    // TODO = add more types of card
    public CampfireCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/campfire_card.png")).toURI().toString())));
    }    
}
