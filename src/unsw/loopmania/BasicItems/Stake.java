package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;


/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends BasicItem implements AttackingStrategy {

    public static final int COST = 10;
    int damage;
    
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST, new ImageView(new Image((new File("src/images/stake.png")).toURI().toString())));
    } 

    public Stake getStake() {
        return this;
    }
    
    public void reduceSlugHealth(Slug slug, int loopCount) {

        damage = (int)Math.floor(Math.random()*(5-2+1)+2);     
        slug.decreaseHealth(damage);
    }

    public void reduceZombieHealth(Zombie zombie, int loopCount) {
        damage = (int)Math.floor(Math.random()*(5-2+1)+2);     
        zombie.decreaseHealth(damage);
    }
    
    public void reduceVampireHealth(Vampire vampire, int loopCount) {
        vampire.decreaseHealth(30);
    }
}