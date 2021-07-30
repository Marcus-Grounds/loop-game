package unsw.loopmania.Buildings.PathBuildings;

import java.io.File;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Ally;
import unsw.loopmania.Character.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class JailBuilding extends PathBuilding {

    public JailBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/jail.png")).toURI().toString())));
    }

    @Override
    public Ally pathAction(Character character, List<BasicEnemy> enemies) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
