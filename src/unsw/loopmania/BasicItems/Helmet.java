package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;



/**
 * represents an equipped or unequipped helmet in the backend world
 */
public class Helmet extends BasicItem implements DefendingStrategy {

    public static final int COST = 10;
    
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST, new ImageView(new Image((new File("src/images/helmet.png")).toURI().toString())));
    }    

    public Helmet getHelmet() {
        return this;
    }

    /**
     * Reduces the damage done by the slug by 1/2
     * Slug deals damage of 1
     */
    public void reduceSlugDamage(Slug slug, Character c) {
        c.decreaseHealth(1);
    }

    /**
     * Reduces the damage done by the zombie by 1/2
     * Zombie deals damage of 3
     */
    public void reduceZombieDamage(Zombie zombie, Character c) {
        c.decreaseHealth(3);
    }

    /**
     * Reduces the damage done by the vampire by 1/2
     * Vampire deals damage of 5
     */
    public void reduceVampireDamage(Vampire vampire, Character c) {
        c.decreaseHealth(5);
    }
    
}
