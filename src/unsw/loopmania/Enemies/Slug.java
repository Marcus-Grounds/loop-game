package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;


public class Slug extends BasicEnemy {

    public static final int LOW_HEALTH = 10;
    public static final int SHORT_RADIUS = 1;
    public static final int LOW_DAMAGE = 2;
    
    public Slug(PathPosition position) {
        //Health healthSlug = new Health(10);
        //Image image = new Image((new File("src/images/slug.png")).toURI().toString());
        super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, LOW_DAMAGE, new ImageView(new Image((new File("src/images/slug.png")).toURI().toString())) );
        //TODO Auto-generated constructor stub
    }
    
}
