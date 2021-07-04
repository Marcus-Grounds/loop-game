package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends StaticEntity implements AttackingStrategy {
    
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    } 

    public Stake getSword(Stake s) {
        return s;
    }
    
    public void reduceSlugHealth(Slug slug) {}
    public void reduceZombieHealth(Zombie zombie) {}
    public void reduceVampireHealth(Vampire vampire) {}
}