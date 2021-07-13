package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.LoopManiaWorld;


/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends BasicItem implements AttackingStrategy {

    public static final int COST = 5;
    int damage;

    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    

    public Sword getSword() {
        return this;
    }

    public int getCost() {
        return COST;
    }

    // Damage done by sword is dependent on the number of loops
    // and randomised

    public void reduceSlugHealth(Slug slug, LoopManiaWorld d) {

        if (d.getLoopCount() >= 0 && d.getLoopCount() <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        slug.decreaseHealth(damage);
    }

    public void reduceZombieHealth(Zombie zombie, LoopManiaWorld d) {
        
        if (d.getLoopCount() >= 0 && d.getLoopCount() <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        zombie.decreaseHealth(damage);
    }
    
    public void reduceVampireHealth(Vampire vampire, LoopManiaWorld d) {

        if (d.getLoopCount() >= 0 && d.getLoopCount() <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (d.getLoopCount() >= 31 && d.getLoopCount() <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        vampire.decreaseHealth(damage);
    }
  
}
