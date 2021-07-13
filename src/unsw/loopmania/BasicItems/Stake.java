package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends StaticEntity implements AttackingStrategy {

    public static final int COST = 10;
    int damage;
    
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    } 

    public Stake getStake() {
        return this;
    }

    public int getCost() {
        return COST;
    }
    
    public void reduceSlugHealth(Slug slug, LoopManiaWorld d) {

        damage = (int)Math.floor(Math.random()*(5-2+1)+2);     
        slug.decreaseHealth(damage);
    }

    public void reduceZombieHealth(Zombie zombie, LoopManiaWorld d) {
        damage = (int)Math.floor(Math.random()*(5-2+1)+2);     
        zombie.decreaseHealth(damage);
    }
    
    public void reduceVampireHealth(Vampire vampire, LoopManiaWorld d) {
        vampire.decreaseHealth(10);
    }
}