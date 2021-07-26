package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.BasicItems.BasicItem;

import java.io.File;
import java.util.Random;

public class DoggieCoin extends BasicItem {

    int doggieCointCount;
    
    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y, 100, new ImageView(new Image((new File("src/images/doggiecoin.png")).toURI().toString())) );
        this.doggieCointCount = 0;
    }

    @Override
    public int getValue() {
        //value of doggie coin will vary by 5 orders of magnitude
        Random random = new Random();
        int power = random.nextInt(5);
        double base =random.nextDouble();
        int value = (int) (base*Math.pow(10, power));

        System.out.println(value);

        return value;
    }

    
}
