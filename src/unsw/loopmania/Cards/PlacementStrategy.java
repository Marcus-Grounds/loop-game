package unsw.loopmania.Cards;

import java.util.List;

import  org.javatuples.Pair;

public interface PlacementStrategy {
    public boolean isPlaceable(int buildingNodeX, int buildingNodeY, List<Pair<Integer, Integer>> Path);
}
