package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import jdk.dynalink.beans.StaticClass;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.BasicItems.Stake;
import unsw.loopmania.BasicItems.Sword;
import unsw.loopmania.Cards.Card;


public class Slug extends BasicEnemy implements SpawnStrategy{

    public static final int LOW_HEALTH = 10;
    public static final int SHORT_RADIUS = 1;
    public static final int LOW_DAMAGE = 2;
    //public ImageView image;
    public static Random random;

    
    public Slug (PathPosition position) {
        //Image image = new Image((new File("src/images/slug.png")).toURI().toString());
        //super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, LOW_DAMAGE, new ImageView(new Image((new File("src/images/slug.png")).toURI().toString())) );
        
        super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, LOW_DAMAGE, new ImageView(new Image((new File("src/images/slug.png")).toURI().toString())) );
        //JFXPanel jfxPanel = new JFXPanel();
        //this.image = new ImageView(new Image((new File("src/images/slug.png")).toURI().toString()));

        //TODO Auto-generated constructor stub
        random = new Random();
    }

    @Override
    public void spawn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        
        //Random random = new Random();
        System.out.print("generating random");
        double r = random.nextDouble();
        System.out.print(r);
        if (r < 0.3){
            return new Sword(x, y);
        }
        else if (r < 0.4) {
            return new Stake(x, y);
        }

        return null;
    }

    @Override
    public Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y){
        return null;
    }
}
