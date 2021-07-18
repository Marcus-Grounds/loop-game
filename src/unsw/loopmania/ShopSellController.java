package unsw.loopmania;

import java.io.File;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    @FXML // fx:id="continueGame"
    private Button continueGame; // Value injected by FXMLLoader

    private MenuSwitcher gameSwitcher;

    private LoopManiaWorld loopManiaWorld;

    private Timeline timeline;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                ImageView inventorySlotImage = new ImageView((new File("src/images/empty_slot.png")).toURI().toString());
                inventory.add(inventorySlotImage, x, y);
            }
        }
        assert inventory != null : "fx:id=\"inventory\" was not injected: check your FXML file 'ShopSellView.fxml'.";
        assert buyItem != null : "fx:id=\"buyItem\" was not injected: check your FXML file 'ShopSellView.fxml'.";

    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    public void setLoopManiaWorld(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    public void startTimer(LoopManiaWorldController loopManiaWorldController){
        // TODO = handle more aspects of the behaviour required by the specification
        System.out.println("starting timer for shop");
        GridPane worldInventory = loopManiaWorldController.getUnequippedInventory();
        this.inventory.getChildren().addAll(worldInventory.getChildren());
        //ObservableList<Node> worldList = loopManiaWorldController.getUnequippedInventory().getChildren();
        //ObservableList<Node> childList = this.inventory.getChildren();
        EventHandler<ActionEvent> switchToGame = new EventHandler<ActionEvent>(){
            public void handle (ActionEvent t) {
                GridPane worldInventory = loopManiaWorldController.getUnequippedInventory();
                worldInventory.getChildren().addAll(inventory.getChildren());
                timeline.stop();
                gameSwitcher.switchMenu();
            }
        };
        
        //trigger adding code to process main game logic to queue. JavaFX will target framerate of 0.3 seconds
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(8000), switchToGame));
        this.timeline.play();
    }

    @FXML
    void ContinueGame (ActionEvent event) {
        this.timeline.stop();
        gameSwitcher.switchMenu();
    }

    @FXML
    private void switchToGame() throws IOException {
        gameSwitcher.switchMenu();
    }
}
