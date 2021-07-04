package unsw.loopmania;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    public static final int START_HEALTH = 100;
    
    public Character(PathPosition position) {
        super(position, new Health(START_HEALTH));
        
    }
    
}
