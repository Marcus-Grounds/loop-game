package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

/**
 * represents an equipped or unequipped staff in the backend world
 */
public class Staff extends BasicItem implements AttackingStrategy {
    
    public static final int COST = 5;
    int damage = 2;

    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST);
    }   
    
    public Staff getStaff() {
        return this;
    }

    public void reduceSlugHealth(Slug slug, LoopManiaWorld d) {
        slug.decreaseHealth(damage);
    }

    public void reduceZombieHealth(Zombie zombie, LoopManiaWorld d) {
        zombie.decreaseHealth(damage);
    }
    
    public void reduceVampireHealth(Vampire vampire, LoopManiaWorld d) {
        vampire.decreaseHealth(damage);
    }
}