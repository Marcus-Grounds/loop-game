package unsw.loopmania.Character;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.Enemies.*;

public class RegularState extends CharacterState {

    public RegularState(Character character) {
        super(character);
    }

    public void dealDamage(BasicEnemy enemy, int loopCount){
        AttackingStrategy weapon = character.getEquippedWeapon ();

        //a doggie can only stun if its health is greater than 30
        if (enemy instanceof Doggie && enemy.getCurrentHealth() >= 30) {
            character.changeState(new StunnedState(character));
            
        }

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
    public void move() {
        character.moveDownPath();
    }
    
}
