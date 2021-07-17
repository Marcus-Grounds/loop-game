package unsw.loopmania.Buildings.SpawnBuildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Zombie;

public class ZombiePitBuilding extends SpawnBuilding {

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }


    @Override
    public BasicEnemy spawnAction(int loopCount, boolean isCharcaterOnCastle, Pair<Integer, Integer> spawnTile, List<Pair<Integer, Integer>> orderedPath) {
                
       if (isCharcaterOnCastle) {
    
            int indexInPath = orderedPath.indexOf(spawnTile);
            return new Zombie (new PathPosition(indexInPath, orderedPath));

        }
        
        return null;
    }    
}
