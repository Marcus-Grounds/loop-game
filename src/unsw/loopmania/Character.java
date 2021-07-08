package unsw.loopmania;
import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    public static final int START_HEALTH = 100;
    
    public Character(PathPosition position) {
        super(position, new Health(START_HEALTH), new ImageView(new Image((new File("src/images/human_new.png")).toURI().toString())));
        //super(position, new Health(START_HEALTH));
    }
    
}
