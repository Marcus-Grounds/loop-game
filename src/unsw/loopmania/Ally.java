package unsw.loopmania;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ally{
    Health health;
    private ImageView image;

    

    public Ally(int health) {
        this.health = new Health(health);
        this.image = new ImageView(new Image((new File("src/images/deep_elf_master_archer.png")).toURI().toString()));
    }
    
    
}
