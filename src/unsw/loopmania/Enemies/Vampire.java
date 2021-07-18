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
import unsw.loopmania.BasicItems.*;
import unsw.loopmania.Cards.CampfireCard;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.TrapCard;
import unsw.loopmania.Cards.*;

public class Vampire extends BasicEnemy{

    
    public Vampire(PathPosition position) {
        super(position, new Health(100), 3, 5, 10, new ImageView(new Image((new File("src/images/vampire.png")).toURI().toString())));
    }

    /**
     * a 30% chance of inflicting extra damage (30), otherwise damage is 10
     */
    @Override
    public int getDamage() {
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.3) {
            return 30;
        }

        return 10;
    }

    /**
     * Give randomly generated weapon
     * @param x, y, the location of the weapon if one is generated
     * @return BasicItem
     */
    @Override
    public BasicItem giveWeaponWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        Random random = new Random();
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.5){
            return new Sword(x, y);
        } else if (r < 0.3) {
            return new Stake(x, y);
        } else if (r < 0.45){
            return new Staff(x, y);
        } else if (r < 0.6){
            return new Armour(x, y);
        } else if (r < 0.75) {
            return new Shield(x, y);
        } else if (r < 0.9) {
            return new Helmet(x, y);
        }

        return null;
    }

     /**
     * Give randomly generated card
     * @param x, y, the location of the card if one is generated
     * @return Card
     */
    @Override
    public Card giveCardWhenLooted(SimpleIntegerProperty x, SimpleIntegerProperty y){
        Random random = new Random();
        double r = random.nextDouble();
        //System.out.print(r);
        if (r < 0.1){
            return new VampireCastleCard(x, y);
        } else if (r < 0.25) {
            return new ZombiePitCard(x, y);
        } else if (r < 0.4) {
            return new TowerCard(x, y);
        } else if (r < 0.55) {
            return new VillageCard(x, y);
        } else if (r < 0.7) {
            return new BarracksCard(x, y);
        } else if (r < 0.85) {
            return new TrapCard(x, y);
        } else if (r < 1) {
            return new CampfireCard(x, y);
        }
        return null;
    }

    /**
     * move forwards 90% of the time, otherwise stays still
     */
    @Override
    public void move(){
        double directionChoice = (new Random()).nextDouble();
        if (directionChoice < 0.9){
            moveDownPath();
        }
        
    }
}
