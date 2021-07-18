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

public class BattleEnemyController {
    private MenuSwitcher gameSwitcher;
    private Battle battle;
    private Timeline timeline;

    @FXML
    private Label healthEnemy;

    @FXML
    private Label healthCharacter;
    
    @FXML
    private ImageView enemyImage;

    @FXML
    private ImageView characterImage;
    /*
    //@FXML
    public BattleEnemyController() {
        //characterImage = new ImageView(new Image((new File("src/images/slug.png")).toURI().toString()));
        
        //healthCharacter.textProperty().bind(battle.getCharacter().getCurrentHealth());
    */
    public BattleEnemyController() {
        /*
        this.timeline = new Timeline();
        final KeyFrame kf = new KeyFrame(Duration.millis(500), event->battle.dealDamageOnce());
        timeline.getKeyFrames().add(kf);
        
        timeline.setCycleCount(3);
        */
    }
        
    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private void switchToGame() throws IOException {
        
        gameSwitcher.switchMenu();
    }
    

    public void setBattle(Battle battle){
        this.battle = battle;
        
    }

    public void startTimer(){
        // TODO = handle more aspects of the behaviour required by the specification
        System.out.println("starting timer enemy fight");
        
        // trigger adding code to process main game logic to queue. JavaFX will target framerate of 0.3 seconds
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), event -> {
            battle.dealDamageOnce();
        }));
    
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public void pauseBattle() {
        try {
            System.out.println("hi2");
            timeline.stop();

            switchToGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}