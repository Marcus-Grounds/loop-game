package unsw.loopmania.CharacterFolder;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.Enemies.*;

public class JailState extends CharacterState {
    private int ticks;

    public JailState(Character character) {
        super(character);
        ticks = 0;
    }

    public void dealDamage(BasicEnemy enemy, int loopCount){
        AttackingStrategy weapon = character.getEquippedWeapon ();


        enemy.decreaseHealth(character.getBaseDamage());
        if (weapon != null){
            if (enemy instanceof Slug){
                Slug slug = (Slug) enemy;
                weapon.reduceSlugHealth(slug, loopCount);
            }
            else if (enemy instanceof Zombie){
                Zombie zombie = (Zombie) enemy;
                weapon.reduceZombieHealth(zombie, loopCount);
            }
            else if (enemy instanceof Vampire){
                Vampire vampire = (Vampire) enemy;
                weapon.reduceVampireHealth(vampire, loopCount);
            }
            // NEED TO CHANGE THISSSSSS
            else if (enemy instanceof Doggie){
                enemy.decreaseHealth(10);
            }
        }
    }
    /**
     * in the jailed state, the character will not move for 10 ticks, after this, will switch back to RegularState
     */
    public void move() {
       if (ticks < 10){
           ticks ++;
       }
       else {
            character.changeState(new RegularState(character));
            character.moveDownPath();
       }
    }
    
}
