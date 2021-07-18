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
import unsw.loopmania.BasicItems.Staff;
import unsw.loopmania.BasicItems.Stake;
import unsw.loopmania.BasicItems.Sword;
import unsw.loopmania.Cards.BarracksCard;
import unsw.loopmania.Cards.Card;

public class Zombie extends BasicEnemy{

    public static final int MED_HEALTH = 30;
    public static final int MED_RADIUS = 3;
    public static final int MED_DAMAGE = 5;
    public static Random random;
    
    public Zombie(PathPosition position) {
        super(position, new Health(MED_HEALTH), MED_RADIUS, MED_RADIUS, MED_DAMAGE, new ImageView(new Image((new File("src/images/zombie.png")).toURI().toString())));
        //super(position, new Health(MED_HEALTH), MED_RADIUS, MED_RADIUS, MED_DAMAGE);
        //TODO Auto-generated constructor stub
        random = new Random();
    }
    

    @Override
    public BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        //System.out.print("generating random");
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.3){
            return new Stake(x, y);
        }
        else if (r < 0.4) {
            return new Staff(x, y);
        }

        return null;
    }
    
    @Override
    public Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y){
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.3){
            return new BarracksCard(x, y);
        }
        
        return null;
    }

    @Override
    public void move(){
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveDownPath();
        }
    }
}
