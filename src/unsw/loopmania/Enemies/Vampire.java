package unsw.loopmania.Enemies;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;

public class Vampire extends BasicEnemy {

    public static final int HIGH_HEALTH = 100;
    public static final int MED_RADIUS = 3;
    public static final int HIGH_RADIUS = 5;
    public static final int HIGH_DAMAGE = 10;
    
    public Vampire(PathPosition position) {
        //super(position, new Health(HIGH_HEALTH), MED_RADIUS, HIGH_RADIUS, HIGH_DAMAGE, new ImageView(new Image((new File("src/images/vampire.png")).toURI().toString())));
        super(position, new Health(HIGH_HEALTH), MED_RADIUS, HIGH_RADIUS, HIGH_DAMAGE);
        //TODO Auto-generated constructor stub
    }
}
