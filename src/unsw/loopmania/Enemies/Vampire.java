package unsw.loopmania.Enemies;

import java.io.File;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.BasicItems.Helmet;
import unsw.loopmania.BasicItems.Shield;
import unsw.loopmania.Cards.CampfireCard;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.TrapCard;

public class Vampire extends BasicEnemy{

    public static final int HIGH_HEALTH = 100;
    public static final int MED_RADIUS = 3;
    public static final int HIGH_RADIUS = 5;
    public static final int HIGH_DAMAGE = 10;
    
    public Vampire(PathPosition position) {
        super(position, new Health(HIGH_HEALTH), MED_RADIUS, HIGH_RADIUS, HIGH_DAMAGE, new ImageView(new Image((new File("src/images/vampire.png")).toURI().toString())));
        //super(position, new Health(HIGH_HEALTH), MED_RADIUS, HIGH_RADIUS, HIGH_DAMAGE);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getDamage() {
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.3) {
            return 30;
        }

        return 10;
    }

    @Override
    public BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        Random random = new Random();
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.2){
            return new Shield(x, y);
        }
        else if (r < 0.4) {
            return new Helmet(x, y);
        }

        return null;
    }
    @Override
    public Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y){
        Random random = new Random();
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.3){
            return new TrapCard(x, y);
        }
        else if (r < 0.4) {
            return new CampfireCard(x, y);
        }
        return null;
    }

    @Override
    public void move(){
        double directionChoice = (new Random()).nextDouble();
        if (directionChoice < 0.9){
            moveDownPath();
        }
        
    }
}
