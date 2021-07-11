package unsw.loopmania;


import java.io.IOException;
import javafx.fxml.FXML;

public class BattleEnemyController {
    private MenuSwitcher gameSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    private void switchToGame() throws IOException {
        gameSwitcher.switchMenu();
    }
   
    
}