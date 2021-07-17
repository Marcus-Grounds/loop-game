package unsw.loopmania.Cards;

import java.util.List;

import org.javatuples.Pair;

public class OnlyOnPathStrategy implements PlacementStrategy{
    @Override
    public boolean isPlaceable(int x, int y, List<Pair<Integer, Integer>> Path) {
        for (Pair<Integer, Integer> adj : Path) {
            if (adj.getValue0() == x && adj.getValue1() == y) return true;
        }
        return false;
    }

    public boolean isAdjacent (int x, int y) {
        if (x == y + 1 || x == y - 1) return true;
        return false;
    }
}
