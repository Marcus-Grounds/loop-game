package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;


/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends BasicItem implements DefendingStrategy {

    public static final int COST = 20;
    
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST);
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
        java.util.Random random = new java.util.Random();
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