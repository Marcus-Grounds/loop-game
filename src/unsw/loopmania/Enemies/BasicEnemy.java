package unsw.loopmania.Enemies;

import java.util.Random;

import javafx.scene.image.ImageView;
import unsw.loopmania.*;


/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    // TODO = modify this, and add additional forms of enemy
    private int attackRadius;
    private int supportRadius;
    private int damage;
    //public ImageView image;

    public BasicEnemy(PathPosition position, Health health, int attackRadius, int supportRadius, int damage, ImageView image) {
    //public BasicEnemy(PathPosition position, Health health, int attackRadius, int supportRadius, int damage) {
        super(position, health, image);
        this.attackRadius = attackRadius;
        this.supportRadius = supportRadius;
        this.damage = damage;
        //this.image = image;
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public int getSupportRadius() {
        return supportRadius;
    }

    public int getDamage() {
        return damage;
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }
    /*
    public ImageView getImageView(){
        return image;
    }
    */

}
