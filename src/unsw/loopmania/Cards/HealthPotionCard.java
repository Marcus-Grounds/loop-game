package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class HealthPotionCard extends Card {
    public HealthPotionCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/brillian_blue_new.png")).toURI().toString())));
    }    
}
