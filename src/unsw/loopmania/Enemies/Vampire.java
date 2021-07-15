package unsw.loopmania.Enemies;

import java.io.File;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.Cards.Card;

public class Vampire extends BasicEnemy implements SpawnStrategy{

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
    public void spawn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y) {

        return null;
    }
    @Override
    public Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y){
        return null;
    }
}
