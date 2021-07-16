package unsw.loopmania.Enemies;

import java.util.Random;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;
import unsw.loopmania.*;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.Cards.Card;


/**
 * a basic form of enemy in the world
 */
public abstract class BasicEnemy extends MovingEntity {
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
    
    
    
    public abstract BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y);
    public abstract Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y);
    public abstract void move();
}
