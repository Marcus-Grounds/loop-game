package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Character;

/**
 * represents an equipped or unequipped armour in the backend world
 */
public class Armour extends BasicItem implements DefendingStrategy {

    public static final int COST = 5;

    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST);
    }    

    public Armour getArmour() {
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