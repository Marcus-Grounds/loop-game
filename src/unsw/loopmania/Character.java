package unsw.loopmania;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.DefendingStrategy;
import unsw.loopmania.Cards.Card;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    public static final int START_HEALTH = 100;
    private int baseDamage = 5;
    private Gold gold;
    private Experience experience;
    private AttackingStrategy equippedWeapon;
    private DefendingStrategy equippedDefence;
    private List<Card> cardEntities;
    private List<Entity> unequippedInventoryItems;
    
    public Character(PathPosition position) {
        super(position, new Health(START_HEALTH), new ImageView(new Image((new File("src/images/human_new.png")).toURI().toString())));
        this.gold = new Gold(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        this.experience = new Experience();
        this.equippedWeapon = null;
        this.equippedDefence = null;        
        this.cardEntities = new ArrayList<>();
        this.unequippedInventoryItems = new ArrayList<>();
    }

    public int getBaseDamage () {
        return this.baseDamage;
    }

    public void setBaseDamage (int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int increaseGold (Gold goldOnGorund) {
        this.gold.increaseGold(goldOnGorund.getGoldCount());
        return this.gold.getGoldCount();
    }

    public int decreaseGold (int goldToSpend) {
        this.gold.decreaseGold(goldToSpend);
        return this.gold.getGoldCount();
    }

    public int decreaseGold (Gold goldToSpend) {
        this.gold.decreaseGold(goldToSpend.getGoldCount());
        return this.gold.getGoldCount();
    }

    public void addExperience (int experience) {
        this.experience.addExperience(experience);
    }

    public int getExperience () {
        return this.experience.getExperience();
    }

    public void changeEquippedWeapon (AttackingStrategy equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public AttackingStrategy getEquippedWeapon () {
        return this.equippedWeapon;
    }

    public void changeEquippedDefence (DefendingStrategy equippedDefence) {
        this.equippedDefence = equippedDefence;
    }

    public DefendingStrategy getEquippedDefence () {
        return this.equippedDefence;
    }

    public void addCard (Card card) {
        this.cardEntities.add(card);
    }

    public List<Card> getAllCards () {
        return this.cardEntities;
    }

    public void addInventoryItem (Entity entity) {
        this.unequippedInventoryItems.add(entity);
    }

    public List<Entity> getAllInventoryItems () {
        return this.unequippedInventoryItems;
    }

}
