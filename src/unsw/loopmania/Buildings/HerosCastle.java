package unsw.loopmania.Buildings;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Entity;
import unsw.loopmania.MovingEntity;
import unsw.loopmania.BasicItems.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HerosCastle extends Building {
    private List<BasicItem> items;

    public HerosCastle(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, new ImageView(new Image((new File("src/images/tower.png")).toURI().toString())));
        //TODO Auto-generated constructor stub
        this.items = new ArrayList<>();
        this.fillShop();
    }

    public List<BasicItem> getAllItems() {
        this.fillShop();
        return this.items;
    }

    public BasicItem getItemByIndex(int index) {
        return this.items.get(index);
    }

    public BasicItem buyItemByIndex(int index) {
        BasicItem item = this.items.get(index);
        this.items.remove(item);
        this.fillShop();
        return item;
    }

    public void fillShop() {
        while (this.items.size() < 3) {
            this.items.add(generateRandomItem());
        }
    }

    public BasicItem generateRandomItem () {
        SimpleIntegerProperty x = (SimpleIntegerProperty) this.x();
        SimpleIntegerProperty y = (SimpleIntegerProperty) this.y();
        Random random = new Random();
        double r = random.nextDouble();
        if (r < 0.2){
            return new Sword(x, y);
        } else if (r < 0.4) {
            return new Stake(x, y);
        } else if (r < 0.6){
            return new Staff(x, y);
        } else if (r < 0.8){
            return new Armour(x, y);
        } else {
            return new Shield(x, y);
        }
    }
}