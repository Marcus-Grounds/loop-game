package unsw.loopmania.BasicItems;

import java.util.Random;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class DoggieCoin extends BasicItem {
    
    public static int COST;

    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, COST, new ImageView(new Image((new File("src/images/doggiecoin.png")).toURI().toString())));
    }    

    /** 
     * Price of DoggieCoin randomly fluctuates between 0 to 100
     * If Elan Muske has been defeated, Price of DoggieCoin plummets
     * and set to 200
     */ 

    public int setCoinPrice(boolean defeatedElanMuske) {

        if (defeatedElanMuske == true) {
            COST = 200;
        }
        else {
            Random price = new Random(5);
            COST = price.nextInt(100);
        }
        setCost(COST);
        return COST;
    }
    
}
