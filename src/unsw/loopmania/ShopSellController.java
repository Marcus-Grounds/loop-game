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
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ShopSellController {

    //@FXML // ResourceBundle that was given to the FXMLLoader
    //private ResourceBundle resources;

    //@FXML // URL location of the FXML file that was given to the FXMLLoader
    //private URL location;

    @FXML // fx:id="inventory"
    private GridPane inventory; // Value injected by FXMLLoader

    @FXML // fx:id="buyItem"
    private Button buyItem; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        this.inventory = new GridPane();
        assert inventory != null : "fx:id=\"inventory\" was not injected: check your FXML file 'ShopSellView.fxml'.";
        assert buyItem != null : "fx:id=\"buyItem\" was not injected: check your FXML file 'ShopSellView.fxml'.";

    }
}
