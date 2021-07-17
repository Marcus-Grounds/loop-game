package unsw.loopmania.Cards;

import java.util.List;

import  org.javatuples.Pair;

import unsw.loopmania.LoopManiaWorld;

public class AdjacentToPathStrategy implements PlacementStrategy {
    @Override
    public boolean isPlaceable(int x, int y, List<Pair<Integer, Integer>> Path) {
        boolean result = false;
        for (Pair<Integer, Integer> adj : Path) {
            if (adj.getValue0() == x && adj.getValue1() == y) return false;
            if (isAdjacent(adj.getValue0(), y) || isAdjacent(adj.getValue1(), y)) result = true;
        }
        return result;
    }

    public boolean isAdjacent (int x, int y) {
        if (x == y + 1 || x == y - 1) return true;
        return false;
    }
}
