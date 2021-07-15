package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Gold extends StaticEntity {

    int goldCount;
    
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y);
        this.goldCount = 0;
    }

    public int getGoldCount() {
        return this.goldCount;
    }

    public void increaseGold(int amountToIncrease) {
        this.goldCount = this.goldCount + amountToIncrease;
    }

    public void decreaseGold(int amountToDecrease) {
        this.goldCount -= amountToDecrease;
        if (this.goldCount < 0) this.goldCount = 0;
    }
}
