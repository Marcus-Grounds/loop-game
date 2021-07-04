package unsw.loopmania.Enemies;

import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;

public class Zombie extends BasicEnemy {

    public static final int MED_HEALTH = 30;
    
    public Zombie(PathPosition position) {
        super(position, new Health(MED_HEALTH));
        //TODO Auto-generated constructor stub
    }
    
}
