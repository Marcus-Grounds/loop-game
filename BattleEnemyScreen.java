package unsw.loopmania;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleEnemyScreen {

    private Stage stage;
    private String title;
    private BattleEnemyController controller;
    private Scene scene;

    public BattleEnemyScreen(Stage stage) throws IOException {
        this.stage = stage;
        title = "Battle Screen";

        //controller = new BattleEnemyController();
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("battle.fxml"));
        //loader.setController(controller);

        // load into a Parent node called root
        //Parent root = loader.load();
        //scene = new Scene(root, 500, 300);
    }

    public void start() {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public BattleEnemyController getController() {
        return controller;
    }
}
