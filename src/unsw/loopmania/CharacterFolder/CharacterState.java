package unsw.loopmania.CharacterFolder;

import unsw.loopmania.Enemies.BasicEnemy;

public abstract class CharacterState {
    Character character;
    
    public CharacterState (Character character){
        this.character = character;
    }

    abstract public void dealDamage(BasicEnemy enemy, int loopCount);
    abstract public void move();
}
