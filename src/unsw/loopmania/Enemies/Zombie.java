package unsw.loopmania.Enemies;

import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;

public class Zombie extends BasicEnemy {

    public static final int MED_HEALTH = 30;
    
    public Zombie(PathPosition position) {
<<<<<<< HEAD
        super(position);
        
=======
        super(position, new Health(MED_HEALTH));
>>>>>>> master
        //TODO Auto-generated constructor stub
    }
    
}