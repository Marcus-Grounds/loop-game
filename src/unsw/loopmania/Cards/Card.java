package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    // TODO = implement other varieties of card than VampireCastleCard
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y, ImageView image) {
        super(x, y, image);
    }
}
