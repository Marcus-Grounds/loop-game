package unsw.loopmania.BasicItems;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;


public interface AttackingStrategy {

    public void reduceSlugHealth(Slug slug, int loopCount);
    public void reduceZombieHealth(Zombie zombie, int loopCount);
    public void reduceVampireHealth(Vampire vampire, int loopCount);
    
}
