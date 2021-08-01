package unsw.loopmania.CharacterFolder;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Enemies.Doggie;

public abstract class CharacterState {
    Character character;
    
    public CharacterState (Character character){
        this.character = character;
    }

    public void dealDamage(BasicEnemy enemy, int loopCount) {
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
    abstract public void move();
}
