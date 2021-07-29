package unsw.loopmania;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class ShopBuyController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="listItems"
    private GridPane listItems; // Value injected by FXMLLoader

    @FXML // fx:id="sellItem"
    private Button sellItem; // Value injected by FXMLLoader

    private MenuSwitcher gameSwitcher;

    private MenuSwitcher shopSellSwitcher;

    private LoopManiaWorld loopManiaWorld;

    private LoopManiaWorldController loopManiaWorldController;

    private Timeline timeline;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert listItems != null : "fx:id=\"listItems\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
        assert sellItem != null : "fx:id=\"sellItem\" was not injected: check your FXML file 'ShopBuyView.fxml'.";
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    public void setShopSellSwitcher (MenuSwitcher shopSellSwitcher) {
        this.shopSellSwitcher = shopSellSwitcher;
    }

    public void setLoopManiaWorld(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    public void startTimer(LoopManiaWorldController loopManiaWorldController){
        EventHandler<ActionEvent> switchToGame = new EventHandler<ActionEvent>(){
            public void handle (ActionEvent t) {
                timeline.stop();
                gameSwitcher.switchMenu();
            }
        };
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(8000), switchToGame));
        this.timeline.play();
    }

    @FXML
    private void switchToGame() throws IOException {
        timeline.stop();
        gameSwitcher.switchMenu();
    }

    @FXML
    private void switchToShopSell() throws IOException {
        timeline.stop();
        shopSellSwitcher.switchMenu();
    }
}
