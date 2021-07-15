package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

/**
 * The moving entity
 */
public abstract class MovingEntity extends Entity {

    //private Health health;
    /**
     * object holding position in the path
     */
    private PathPosition position;
    private Health health;
    private ImageView image;

    /**
     * Create a moving entity which moves up and down the path in position
     * @param position represents the current position in the path
     */
    public MovingEntity(PathPosition position, Health health, ImageView image) {
    //public MovingEntity(PathPosition position, Health health) {
        super();
        this.position = position;
        this.health = health;
        this.image = image;
    }

    /**
     * move clockwise through the path
     */
    public void moveDownPath() {
        position.moveDownPath();
    }

    /**
     * move anticlockwise through the path
     */
    public void moveUpPath() {
        position.moveUpPath();
    }

    public SimpleIntegerProperty x() {
        return position.getX();
    }

    public SimpleIntegerProperty y() {
        return position.getY();
    }

    public int getX() {
        return x().get();
    }

    public int getY() {
        return y().get();
    }

    public int getCurrentHealth() {
        return health.getCurrHealth();
    }

    public void decreaseHealth(int healthToDecrease) {
        health.decreaseHealth(healthToDecrease);
    }

    public void increaseHealth(int healthToIncrease){
        health.increaseHealth(healthToIncrease);
    }
    
    public ImageView getImageView(){
        return image;
    }

    public void setHealth(Health health) {
        this.health = health;
    }
}
