package unsw.loopmania;

public class Health {
    private int currHealth;
    private int maxHealth;
    
    public Health (int health) {
        this.currHealth = health;
        this.maxHealth = health;
    }

    public int getCurrHealth () {
        return this.currHealth;
    }

    public int getMaxHealth () {
        return this.maxHealth;
    }
    
    public void increaseHealth (int health) {
        if (this.currHealth + health < this.maxHealth) {
            this.currHealth += health;
        } else {
            this.currHealth = this.maxHealth;
        }
    }

    public void decreaseHealth (int health) {
        if (this.currHealth - health < 0) {
            this.currHealth = 0;
        } else {
            this.currHealth -= health;
        }
    }
}
