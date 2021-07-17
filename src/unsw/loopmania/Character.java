package unsw.loopmania;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.BasicItem;
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
    private List<BasicItem> unequippedInventoryItems;
    
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

    public int getGoldCount() {
        return this.gold.getGoldCount();
    }

    public int increaseGold (Gold goldOnGorund) {
        return this.gold.increaseGold(goldOnGorund.getGoldCount());
    }

    public int increaseGold (int goldOnGorund) {
        return this.gold.increaseGold(goldOnGorund);
    }

    public int decreaseGold (int goldToSpend) {
        return this.gold.decreaseGold(goldToSpend);
    }

    public Gold getCharacterGold () {
        return this.gold;
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

    public Card getCardByIndex (int index) {
        return this.cardEntities.get(index);
    }

    public List<Card> getAllCards () {
        return this.cardEntities;
    }

    public void addInventoryItem (BasicItem item) {
        this.unequippedInventoryItems.add(item);
    }

    public List<BasicItem> getAllInventoryItems () {
        return this.unequippedInventoryItems;
    }

    public BasicItem sellItemByIndex(int index) {
        BasicItem item = this.unequippedInventoryItems.get(index);
        this.unequippedInventoryItems.remove(index);
        this.gold.increaseGold(item.getCost());
        return item;
    }
}
