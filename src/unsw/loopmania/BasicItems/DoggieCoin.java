package unsw.loopmania.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class DoggieCoin extends BasicItem {
    
    public static int COST;

    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y, 100, new ImageView(new Image((new File("src/images/doggiecoin.png")).toURI().toString())) );;
    }

    public int setCoinPrice(boolean defeatedElanMuske) {

        if (defeatedElanMuske) {
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
