package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.BasicItems.BasicItem;

import java.io.File;
import java.util.Random;

public class DoggieCoin extends BasicItem {
    
    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y, 100, new ImageView(new Image((new File("src/images/doggiecoin.png")).toURI().toString())) );;
    }

    
}
