package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;


public class Slug extends BasicEnemy {

    public static final int LOW_HEALTH = 10;
    
    public Slug(PathPosition position) {
        //Health healthSlug = new Health(10);
        super(position, new Health(LOW_HEALTH));
        //TODO Auto-generated constructor stub
    }
    
}
