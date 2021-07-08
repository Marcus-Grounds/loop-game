package unsw.loopmania.Enemies;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unsw.loopmania.Health;
import unsw.loopmania.PathPosition;

public class Zombie extends BasicEnemy implements SpawnStrategy {

    public static final int MED_HEALTH = 30;
    public static final int MED_RADIUS = 3;
    public static final int MED_DAMAGE = 5;
    
    public Zombie(PathPosition position) {
        super(position, new Health(MED_HEALTH), MED_RADIUS, MED_RADIUS, MED_DAMAGE, new ImageView(new Image((new File("src/images/zombie.png")).toURI().toString())));
        //super(position, new Health(MED_HEALTH), MED_RADIUS, MED_RADIUS, MED_DAMAGE);
        //TODO Auto-generated constructor stub
    }
    
<<<<<<< HEAD
}
=======
    @Override
    public void spawn() {
        // TODO Auto-generated method stub
        
    }
}
>>>>>>> master
