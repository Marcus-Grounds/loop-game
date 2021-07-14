package unsw.loopmania.Buildings.SpawnBuildings;

import java.io.File;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Buildings.Building;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends SpawnBuilding {
    // TODO = add more types of building, and make sure buildings have effects on entities as required by the spec
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setImageView(new ImageView(new Image((new File("src/images/vampire_castle_building_purple_background.png")).toURI().toString())));
    }
}
