package unsw.loopmania.Character;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.Enemies.*;

public class RegularState extends CharacterState {

    public RegularState(Character character) {
        super(character);
    }

    public void dealDamage(BasicEnemy enemy, int loopCount){
        AttackingStrategy weapon = character.getEquippedWeapon ();

        if (enemy instanceof Doggie) {
            System.out.println("Swiatch to stnned");
            character.changeState(new StunnedState(character));
            
        }

        enemy.decreaseHealth(character.getBaseDamage());
        if (weapon != null){
            if (enemy instanceof Slug){
                System.out.println("Slug");
                Slug slug = (Slug) enemy;
                weapon.reduceSlugHealth(slug, loopCount);
            }
            else if (enemy instanceof Zombie){
                Zombie zombie = (Zombie) enemy;
                weapon.reduceZombieHealth(zombie, loopCount);
            }
            else if (enemy instanceof Vampire){
                System.out.println("Vamp");
                Vampire vampire = (Vampire) enemy;
                weapon.reduceVampireHealth(vampire, loopCount);
            }
        }
    }

    public void move() {
        character.moveDownPath();
    }
    
}
