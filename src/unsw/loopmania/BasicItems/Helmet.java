package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;


/**
 * represents an equipped or unequipped helmet in the backend world
 */
public class Helmet extends BasicItem implements DefendingStrategy {

    public static final int COST = 10;
    
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST);
    }    

    public Helmet getHelmet() {
        return this;
    }

    public void reduceSlugDamage(Slug slug, Character c) {
        c.decreaseHealth(1);
    }

    public void reduceZombieDamage(Zombie zombie, Character c) {
        c.decreaseHealth(3);
    }

    public void reduceVampireDamage(Vampire vampire, Character c) {
        c.decreaseHealth(5);
    }
    
}
