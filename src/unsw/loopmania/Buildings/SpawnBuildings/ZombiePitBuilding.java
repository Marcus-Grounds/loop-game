package unsw.loopmania.Buildings.SpawnBuildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Buildings.Building;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class ZombiePitBuilding extends SpawnBuilding {

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/zombie_pit.png")).toURI().toString())));
        //TODO Auto-generated constructor stub
    }    
}
