package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.embed.swing.JFXPanel;
import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.BasicItems.*;

import unsw.loopmania.Buildings.*;

import unsw.loopmania.Cards.*;

import unsw.loopmania.Enemies.*;

import unsw.loopmania.GameMode.*;

public class CardTest {
    @Test
    public void Test1(){
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Character c = new Character(null);
        d.setCharacter(c);

        Card vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(vampireCastleCard);

        assertEquals(vampireCastleCard, d.getCardByIndex(0));
    }

    public void Test2(){
        JFXPanel jfxPanel = new JFXPanel(); 
        LoopManiaWorld d = new LoopManiaWorld(50, 30, new ArrayList<>());
        Character c = new Character(null);
        d.setCharacter(c);

        Card zombiiePitCard = new ZombiePitCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(zombiiePitCard);

        Card campfireCard = new CampfireCard(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        d.addCard(campfireCard);

        assertEquals(zombiiePitCard, d.getCardByIndex(0));
        assertEquals(campfireCard, d.getCardByIndex(1));
    }
}
