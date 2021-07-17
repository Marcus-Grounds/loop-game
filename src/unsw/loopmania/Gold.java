package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class Gold extends StaticEntity {

    int goldCount;
    
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y,new ImageView(new Image((new File("src/images/gold_pile.png")).toURI().toString())) );
        this.goldCount = 0;
    }

    public int getGoldCount() {
        return this.goldCount;
    }

    public int increaseGold(int amountToIncrease) {
        this.goldCount = this.goldCount + amountToIncrease;
        return this.goldCount;
    }

    public int decreaseGold(int amountToDecrease) {
        this.goldCount -= amountToDecrease;
        if (this.goldCount < 0) this.goldCount = 0;
        return this.goldCount;
    }
}
