package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import unsw.loopmania.DoggieCoin;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.Doggie;

public class DoggieTests {
    //test that value of a dogecoin varies
    @Test
    public void TestDoggieCoinValue(){
        JFXPanel jfxPanel = new JFXPanel();
        DoggieCoin doggieCoin = new DoggieCoin(null, null);
        int value1 = doggieCoin.getValue();
        int value2 = doggieCoin.getValue();
        
        assertTrue(value1 != value2);
    }

    @Test
    public void TestDoggieSpawn() {
        JFXPanel jfxPanel = new JFXPanel();

        Doggie doggie = new Doggie(null);
        assertTrue(doggie.giveBasicItemWhenLooted(null, null) instanceof DoggieCoin);
        
    }
}
