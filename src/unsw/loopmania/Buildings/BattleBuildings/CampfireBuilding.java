package unsw.loopmania.Buildings.BattleBuildings;

import java.io.File;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.MovingEntity;

public class CampfireBuilding extends BattleBuilding {

    public static final int MED_RADIUS = 3;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(MED_RADIUS);
        setImageView(new ImageView(new Image((new File("src/images/tower.png")).toURI().toString())));
    }

    @Override
    public boolean checkRadius(MovingEntity entity) {
        
        if (Math.pow((entity.getX()-this.getX()), 2) +  Math.pow((entity.getY()-this.getY()), 2) <= Math.pow(getRadius(),2)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void buildingAction(MovingEntity character, MovingEntity enemy) {
        if (checkRadius(character)) {
            enemy.decreaseHealth(5); //needs to be changed to suit actual characters // might need to be changed for multiple camp fires
        
        } else { 
            
        }
        
        // decrease enemies health by characters damage
        // this gives the effect of "double damage" as enemy also loses health in runbattle
    } 
}
