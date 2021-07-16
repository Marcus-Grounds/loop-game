package unsw.loopmania.Buildings.PathBuildings;

import java.util.List;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Ally;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.SpawnBuildings.SpawnBuilding;
import unsw.loopmania.Enemies.BasicEnemy;

public class BarracksBuilding extends PathBuilding {

    public BarracksBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/barracks.png")).toURI().toString())));
        //TODO Auto-generated constructor stub
    }

    @Override
    public void pathAction(MovingEntity character, List<BasicEnemy> enemies) {
        if (checkOnPath(character)) {
            Ally ally = new Ally(character.getCurrentHealth());
            // addAlly(ally);

        }
        
    }
}
