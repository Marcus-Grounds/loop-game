package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner7;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import jdk.dynalink.beans.StaticClass;
import test.EnemyTest;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.BasicItems.BasicItem;
import unsw.loopmania.BasicItems.DefendingStrategy;
import unsw.loopmania.BasicItems.DoggieCoin;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.CharacterFolder.Character;


public class ElanMuske extends BasicEnemy{
    
    public ElanMuske (PathPosition position) {
        super(position, new Health(200), 1, 1, 2, new ImageView(new Image((new File("src/images/ElanMuske.png")).toURI().toString())) );
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
        return 800;
    }

    @Override
    public int getExperience () {
        return 1000;
    }
    @Override
    public void dealDamage(DefendingStrategy defence, Character c, List<BasicEnemy> enemies) {
        decreaseHealth(this.getDamage());

        //bosts health of all enemies that arnt already dead
        for (BasicEnemy enemy: enemies) {
            if (enemy.getCurrentHealth() > 0) {
                enemy.increaseHealth(2);
            }
        }
    }
}

