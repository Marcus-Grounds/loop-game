package unsw.loopmania;

import java.io.File;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ShopBuyController {

    //@FXML // ResourceBundle that was given to the FXMLLoader
    //private ResourceBundle resources;

    //@FXML // URL location of the FXML file that was given to the FXMLLoader
    //private URL location;

    @FXML // fx:id="item1"
    private ImageView item1; // Value injected by FXMLLoader

    @FXML // fx:id="item2"
    private ImageView item2; // Value injected by FXMLLoader

    @FXML // fx:id="item3"
    private ImageView item3; // Value injected by FXMLLoader

    @FXML // fx:id="sellItem"
    private Button sellItem; // Value injected by FXMLLoader

    private MenuSwitcher gameSwitcher;

    private LoopManiaWorld loopManiaWorld;

    private LoopManiaWorldController loopManiaWorldController;

    private Timeline timeline;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        item1 = new ImageView((new File("src/images/empty_slot.png")).toURI().toString());
        item2 = new ImageView((new File("src/images/empty_slot.png")).toURI().toString());
        item3 = new ImageView((new File("src/images/empty_slot.png")).toURI().toString());
        assert item1 != null : "fx:id=\"item1\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
        assert item2 != null : "fx:id=\"item2\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
        assert item3 != null : "fx:id=\"item3\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
        assert sellItem != null : "fx:id=\"sellItem\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
    }
}
