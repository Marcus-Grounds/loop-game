package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import jdk.dynalink.beans.StaticClass;
import unsw.loopmania.DoggieCoin;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.Cards.Card;


public class Doggie extends BasicEnemy{
    
    public Doggie (PathPosition position) {
        super(position, new Health(10), 1, 1, 2, new ImageView(new Image((new File("src/images/doggie.png")).toURI().toString())) );
    }

    /**
     * Give randomly generated weapon
     * @param x, y, the location of the weapon if one is generated
     * @return BasicItem
     */
    @Override
    public StaticEntity onDeath(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new DoggieCoin(x, y);
    }

  

    /**
     * slugs move forwards 25% of the time, backwards 25% of the time, and stay still otherwises
     */
    @Override
    public void move(){
        int directionChoice = (new Random()).nextInt(4);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    @Override
    public int getGold () {
        return 150;
    }

    @Override
    public int getExperience () {
        return 300;
    }
}
