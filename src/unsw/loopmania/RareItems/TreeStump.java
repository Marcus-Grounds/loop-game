package unsw.loopmania.RareItems;

import unsw.loopmania.*;
import unsw.loopmania.Character;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * Represents an Anduril, Flame of the West in the backend world
 * An Anduril triples damage done to bosses
 */
public class TreeStump extends StaticEntity{
    
    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/tree_stump.png")).toURI().toString())));
    } 

    public TreeStump getTreeStump() {
        return this;
    }
    
    /**
     * Reduces doggie damage by 5 times
     */
    public void reduceDoggieDamage(Character character, Doggie doggie) {
        character.decreaseHealth(doggie.getBaseDamage / 5);
    }

    /**
     * Reduces Elan Muske damage by 5 times
     */
    public void reduceElanMuskeDamage(Character character, ElanMuske elanMuske) {
        character.decreaseHealth(elanMuske.getBasedamage / 5);
    }
}
