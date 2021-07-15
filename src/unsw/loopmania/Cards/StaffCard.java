package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class StaffCard extends Card {
    public StaffCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/staff.png")).toURI().toString())));
    }    
}
