package unsw.loopmania.Enemies;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;


public class Slug extends BasicEnemy {

    public static final int LOW_HEALTH = 10;
    public static final int SHORT_RADIUS = 1;
    public static final int LOW_DAMAGE = 2;
    
    public Slug(PathPosition position) {
        //Health healthSlug = new Health(10);
        super(position, new Health(LOW_HEALTH), SHORT_RADIUS, SHORT_RADIUS, 10);
        //TODO Auto-generated constructor stub
    }
    
}
