package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

/**
 * represents an equipped or unequipped staff in the backend world
 */
public class Staff extends StaticEntity implements AttackingStrategy {
    
    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }   
    
    public Staff getSword(Staff s) {
        return s;
    }

    public void reduceSlugHealth(Slug slug) {}
    public void reduceZombieHealth(Zombie zombie) {}
    public void reduceVampireHealth(Vampire vampire) {}
}