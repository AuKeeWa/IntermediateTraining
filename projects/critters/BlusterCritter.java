import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter {
    private int c;

    public BlusterCritter() {
        c = 2;
    }

    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for (int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++) {
            for (int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++) {
                Location tmp = new Location(r, c);
                if (getGrid().isValid(tmp)) {
                    Actor a = getGrid().get(tmp);
                    if (a != null && a != this) {
                        actors.add(a);
                    }
                }
            }
        }
        return actors;
    }

    public void processActors(ArrayList<Actor> actors) {
        int count = 0;
        for (Actor a : actors) {
            if (a instanceof Critter) count++;
        }
        if (count < c) lighten();
        else darken();
    }

    private void darken() {
        Color c = getColor();
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        if (red > 10) {
            red -= 10;
        }
        if (green > 10) {
            green -= 10;
        }
        if (blue > 10) {
            blue -= 10;
        }
        setColor(new Color(red, green, blue));
    }

    private void lighten() {
        Color c = getColor();
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        if (red < 245) {
            red += 10;
        }
        if (green < 245) {
            green += 10;
        }

        if (blue < 245) {
            blue += 10;
        }
        setColor(new Color(red, green, blue));
    }

}
