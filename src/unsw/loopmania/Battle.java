package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.BasicItems.DefendingStrategy;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.Enemies.Vampire;

public class Battle {
    private List<BasicEnemy> enemiesToFight;
    private Character c;
    private BattleEnemyController controller;
    //private List<BasicEnemy> defeatedEnemies;
    private List<BasicEnemy> enemies;
    private BasicEnemy mainEnemy;
    private List<BattleBuilding> battleBuildings;
    private int loopCount;

    public Battle(Character c, BattleEnemyController controller, List<BasicEnemy> enemies, BasicEnemy mainEnemy,  List<BattleBuilding> battleBuildings, int loopCount) {
        this.c = c;
        this.controller = controller;
        this.enemies = enemies;
        enemiesToFight = new ArrayList<BasicEnemy>();;
        this.mainEnemy = mainEnemy;
        this.battleBuildings = battleBuildings;
        this.loopCount = loopCount;

        if (Math.pow((c.getX()-mainEnemy.getX()), 2) +  Math.pow((c.getY()-mainEnemy.getY()), 2) <= Math.pow(mainEnemy.getAttackRadius(),2)) {
            enemiesToFight.add(mainEnemy);

            //when a battle starts, get all enemies that needs to be fought
            for(BasicEnemy e1: enemies){
                if (Math.pow((c.getX()-e1.getX()), 2) +  Math.pow((c.getY()-e1.getY()), 2) <= Math.pow(e1.getSupportRadius(),2)
                && !enemiesToFight.contains(e1)) {
                    enemiesToFight.add(e1);
                }
            }
        }
        
    }

    public void dealDamageOnce(){
        //public void dealDamageOnce(List<BasicEnemy> defeatedEnemies){
        boolean allEnemiesDead = true;
        AttackingStrategy weapon = c.getEquippedWeapon ();
        DefendingStrategy defence = c.getEquippedDefence();
        
        
        for (BasicEnemy e: enemiesToFight) {
            
            for (BattleBuilding b : battleBuildings) {
                b.buildingAction(c, e);
            }
            
            e.decreaseHealth(c.getBaseDamage());
            if (weapon != null){
                if (e instanceof Slug){
                    Slug slug = (Slug) e;
                    weapon.reduceSlugHealth(slug, loopCount);
                }
                else if (e instanceof Zombie){
                    Zombie zombie = (Zombie) e;
                    weapon.reduceZombieHealth(zombie, loopCount);
                }
                else if (e instanceof Vampire){
                    Vampire vampire = (Vampire) e;
                    weapon.reduceVampireHealth(vampire, loopCount);
                }
            }

            if (e.getCurrentHealth() > 0) {
                allEnemiesDead = false;
            }
            else if (e.getCurrentHealth() <= 0){
                System.out.println("Enemy DEAD");
            }

            if (defence == null){
                c.decreaseHealth(e.getDamage());
            }
            else {
                if (e instanceof Slug){
                    Slug slug = (Slug) e;
                    defence.reduceSlugDamage(slug, c);
                }
                else if (e instanceof Zombie){
                    Zombie zombie = (Zombie) e;
                    defence.reduceZombieDamage(zombie, c);
                }
                else if (e instanceof Vampire){
                    Vampire vampire = (Vampire) e;
                    defence.reduceVampireDamage(vampire, c);
                }
            }
           
            

            if (c.getCurrentHealth() <= 0) {
                System.out.println("Character DEAD");
                c.destroy();
                return;
            }

            System.out.println(c.getCurrentHealth());
            System.out.println(e.getCurrentHealth());
            
        }
        //once all enemies are dead, we can return to main screen
        if (allEnemiesDead){
            
            for (BasicEnemy enemy: enemiesToFight){
                System.out.println("killenemy");
                killEnemy(enemy);
            }
            if (controller != null) {
                System.out.println("allEnemiesDead");
                controller.pauseBattle();
            }
            return;
           
        }
    }

    public Character getCharacter(){
        return c;
    }

    public List<BasicEnemy> getDefeatedEnemies() {
        //System.out.println(defeatedEnemies.size());
        return enemiesToFight;
    }

     /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }


}
