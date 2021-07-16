package unsw.loopmania.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class HerosCastle extends Building {

    public HerosCastle(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/tower.png")).toURI().toString())));
        //TODO Auto-generated constructor stub
    }
}
