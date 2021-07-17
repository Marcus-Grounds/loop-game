package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.LoopManiaWorld;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;



/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends BasicItem implements AttackingStrategy {

    public static final int COST = 5;
    int damage;

    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST, new ImageView(new Image((new File("src/images/basic_sword.png")).toURI().toString())) );
    }    

    public Sword getSword() {
        return this;
    }

    /**
     * Sword damage is dependent on the number of loops completed
     * by the character
     * Reduces slug health by a random value between 5 and 20
     * depending on @param loopCount
     */
    public void reduceSlugHealth(Slug slug, int loopCount) {

        if (loopCount >= 0 && loopCount <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (loopCount >= 31 && loopCount <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        slug.decreaseHealth(damage);
    }

    /**
     * Reduces zombie health by a random value between 5 and 20
     * depending on @param loopCount
     */
    public void reduceZombieHealth(Zombie zombie, int loopCount) {
        
        if (loopCount >= 0 && loopCount <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (loopCount >= 31 && loopCount <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        zombie.decreaseHealth(damage);
    }
    
    /**
     * Reduces vampire health by a random value between 5 and 20
     * depending on @param loopCount
     */
    public void reduceVampireHealth(Vampire vampire, int loopCount) {

        if (loopCount >= 0 && loopCount <= 30) {
            damage = (int)Math.floor(Math.random()*(10-5+1)+5);
        }
        else if (loopCount >= 31 && loopCount <= 60) {
            damage = (int)Math.floor(Math.random()*(15-10+1)+10);
        }
        else {
            damage = (int)Math.floor(Math.random()*(20-15+1)+15);
        }
        
        vampire.decreaseHealth(damage);
    }
  
}
