package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Gold extends StaticEntity {

    int goldCount;
    
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x,y);
    }

    public int getGoldCount() {
        return goldCount;
    }

    public void increaseGold(int amountToIncrease) {
        goldCount = goldCount + amountToIncrease;
    }

    public void deccreaseGold(int amountToDecrease) {
        goldCount = goldCount - amountToDecrease;
    }

}
