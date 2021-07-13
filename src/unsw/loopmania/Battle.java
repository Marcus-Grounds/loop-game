package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import unsw.loopmania.Enemies.BasicEnemy;

public class Battle {
    private List<BasicEnemy> enemiesToFight;
    private Character c;
    private BattleEnemyController controller;
    private List<BasicEnemy> defeatedEnemies;
    private List<BasicEnemy> enemies;

    public Battle(List<BasicEnemy> enemiesToFight, Character c, BattleEnemyController controller, List<BasicEnemy> enemies, List<BasicEnemy> defeatedEnemies) {
        this.enemiesToFight = enemiesToFight;
        this.c = c;
        this.controller = controller;
       this.defeatedEnemies = defeatedEnemies;
        this.enemies = enemies;
    }

    public void dealDamageOnce(){
        System.out.println("enemies to fight in battle.java");
        System.out.println(enemiesToFight.size());

        //public void dealDamageOnce(List<BasicEnemy> defeatedEnemies){
        boolean allEnemiesDead = true;
        for (BasicEnemy e: enemiesToFight) {

            e.decreaseHealth(5);
            if (e.getCurrentHealth() > 0) {
                allEnemiesDead = false;
            }
            else if (e.getCurrentHealth() <= 0 && !defeatedEnemies.contains(e)){
                System.out.println("Enemy DEAD");
                defeatedEnemies.add(e);
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
        if (allEnemiesDead){
            System.out.println("enemy dead count in battle.java");
            System.out.println(defeatedEnemies.size());
            
            for (BasicEnemy enemy: defeatedEnemies){
                System.out.println("killenemy");
                
                enemy.destroy();
                enemies.remove(enemy);
            }
            controller.pauseBattle();
        }
    }
    /*
    public BasicEnemy getGetEnemy(){
        return e;
    }
    */

    public Character getCharacter(){
        return c;
    }

    public List<BasicEnemy> getDefeatedEnemies() {
        return defeatedEnemies;
    }


}
