import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid grid = getGrid();
        Location loc = getLocation();

        Location neighborLoc = loc.getAdjacentLocation(getDirection());
        if (grid.isValid(neighborLoc)) locs.add(neighborLoc);
        neighborLoc = loc.getAdjacentLocation(getDirection() + 180);
        if (grid.isValid(neighborLoc)) locs.add(neighborLoc);

        for (Location l : locs) {
            Actor a = getGrid().get(l);
            if (a != null) actors.add(a);
        }
        return actors;
    }
}
