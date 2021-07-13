package unsw.loopmania.BasicItems;

import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;


public interface AttackingStrategy {

    public void reduceSlugHealth(Slug slug);
    public void reduceZombieHealth(Zombie zombie);
    public void reduceVampireHealth(Vampire vampire);
    
}
