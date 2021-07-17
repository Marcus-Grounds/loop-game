package unsw.loopmania.Buildings;

import unsw.loopmania.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

public class Building extends StaticEntity {
    
    private ImageView image;
    
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y, ImageView image) {
        super(x,y, image);
    }
}
