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
import unsw.loopmania.BasicItems.*;
import unsw.loopmania.Cards.BarracksCard;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.*;

public class Ghost extends BasicEnemy{
    public static int level = 1;
    public Ghost(PathPosition position) {
        super(position, new Health(level), 1, 1, 5, new ImageView(new Image((new File("src/images/Ghost.png")).toURI().toString())));
    }
    
    /**
     * Give randomly generated weapon
     * @param x, y, the location of the weapon if one is generated
     * @return BasicItem
     */
    @Override
    public StaticEntity onDeath(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return null;
    }

    /**
     * moves slowly, only moves forward 50% of the time
     */
    @Override
    public void move(){
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveDownPath();
        }
    }

    @Override
    public int getGold () {
        return level++;
    }

    @Override
    public int getExperience () {
        return level;
    }
}
