package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.BasicItems.BasicItem;

import java.io.File;

public class DoggieCoin extends BasicItem {

    int doggieCointCount;
    
    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y, 100, new ImageView(new Image((new File("src/images/doggiecoin.png")).toURI().toString())) );
        this.doggieCointCount = 0;
    }

    public int getDoggieCoinCount() {
        return this.doggieCointCount;
    }

    /**
     * increase the amount of doggie coins
     * @param amountToIncrease
     * @return
     */
    public int increaseDoggieCoin(int amountToIncrease) {
        this.doggieCointCount = this.doggieCointCount + amountToIncrease;
        return this.doggieCointCount;
    }

    
}
