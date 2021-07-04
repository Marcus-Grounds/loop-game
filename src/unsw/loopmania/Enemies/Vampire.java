package unsw.loopmania.Enemies;

import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;

public class Vampire extends BasicEnemy {

    public static final int HIGH_HEALTH = 100;
    
    public Vampire(PathPosition position) {
        super(position, new Health(HIGH_HEALTH));
        //TODO Auto-generated constructor stub
    }
}
