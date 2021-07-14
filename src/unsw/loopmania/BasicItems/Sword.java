package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;


/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends BasicItem implements AttackingStrategy {

    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    

    public Sword getSword(Sword s) {
        return s;
    }

    public void reduceSlugHealth(Slug slug) {
    }

    public void reduceZombieHealth(Zombie zombie) {

    }
    public void reduceVampireHealth(Vampire vampire) {
        
    }
  
}
