package unsw.loopmania.BasicItems;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;


public interface AttackingStrategy {

    public void reduceSlugHealth(Slug slug, LoopManiaWorld d);
    public void reduceZombieHealth(Zombie zombie, LoopManiaWorld d);
    public void reduceVampireHealth(Vampire vampire, LoopManiaWorld d);
    
}
