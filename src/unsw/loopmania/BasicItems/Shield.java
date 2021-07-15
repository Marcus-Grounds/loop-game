package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;


/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends BasicItem implements DefendingStrategy {

    public static final int COST = 20;
    
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST, new ImageView(new Image((new File("src/images/shield.png")).toURI().toString())));
    }    

    public Shield getShield() {
        return this;
    }

    public void reduceSlugDamage(Slug slug, Character c) {
        c.decreaseHealth(1);
    }

    public void reduceZombieDamage(Zombie zombie, Character c) {
        c.decreaseHealth(3);
    }

    public void reduceVampireDamage(Vampire vampire, Character c) {
        Random random = new Random();
        double r = random.nextDouble();

        // reduces chance of critical bite by 60%
        if (r <= 0.4) {
            c.decreaseHealth(30);
        }
        else {
            c.decreaseHealth(5);
        }
    }
    
}