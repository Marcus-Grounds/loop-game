package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;


public class Slug extends BasicEnemy implements SpawnStrategy{

    public static final int LOW_HEALTH = 10;
    public static final int SHORT_RADIUS = 1;
    public static final int LOW_DAMAGE = 2;
    //public ImageView image;

    
    public Slug (PathPosition position) {
        //Image image = new Image((new File("src/images/slug.png")).toURI().toString());
        //super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, LOW_DAMAGE, new ImageView(new Image((new File("src/images/slug.png")).toURI().toString())) );
        
        super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, LOW_DAMAGE, new ImageView(new Image((new File("src/images/slug.png")).toURI().toString())) );
        //JFXPanel jfxPanel = new JFXPanel();
        //this.image = new ImageView(new Image((new File("src/images/slug.png")).toURI().toString()));

        //TODO Auto-generated constructor stub
    }

    @Override
    public void spawn() {
        // TODO Auto-generated method stub
        
    }
    
}
