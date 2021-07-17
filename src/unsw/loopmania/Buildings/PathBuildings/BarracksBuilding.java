package unsw.loopmania.Buildings.PathBuildings;

import java.util.List;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Ally;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.SpawnBuildings.SpawnBuilding;
import unsw.loopmania.Enemies.BasicEnemy;

public class BarracksBuilding extends PathBuilding {

    public BarracksBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/barracks.png")).toURI().toString())));
    }

    @Override
    public Ally pathAction(Character character, List<BasicEnemy> enemies) {
        if (checkOnPath(character)) {

            Ally ally = new Ally(character.getPathPosition().getPreviousPathPosition(), character.getCurrentHealth());
            //ally is one behind the character
            //ally.moveDownPath();
            
            character.addAlly(ally);
            System.out.println("ALLY COUNT");
            System.out.println(character.getAllies().size());

            return ally;
        }

        return null;
    }
}
