package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import unsw.loopmania.BasicItems.AttackingStrategy;
import unsw.loopmania.Buildings.BattleBuildings.BattleBuilding;
import unsw.loopmania.Enemies.BasicEnemy;

public class Battle {
    private List<BasicEnemy> enemiesToFight;
    private Character c;
    private BattleEnemyController controller;
    //private List<BasicEnemy> defeatedEnemies;
    private List<BasicEnemy> enemies;
    private BasicEnemy mainEnemy;
    private List<BattleBuilding> battleBuildings;

    public Battle(Character c, BattleEnemyController controller, List<BasicEnemy> enemies, BasicEnemy mainEnemy,  List<BattleBuilding> battleBuildings) {
        this.c = c;
        this.controller = controller;
        this.enemies = enemies;
        enemiesToFight = new ArrayList<BasicEnemy>();;
        this.mainEnemy = mainEnemy;
        this.battleBuildings = battleBuildings;

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
        
        for (BasicEnemy e: enemiesToFight) {
            
            for (BattleBuilding b : battleBuildings) {
                b.buildingAction(c, e);
            }
            
            e.decreaseHealth(5);
            if (e.getCurrentHealth() > 0) {
                allEnemiesDead = false;
            }
            else if (e.getCurrentHealth() <= 0){
                System.out.println("Enemy DEAD");
            }

            c.decreaseHealth(e.getDamage());
            

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
