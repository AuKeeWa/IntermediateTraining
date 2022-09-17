import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;


public class Jumper extends Actor
{
    public Jumper()
    {
        setColor(Color.RED);
    }

    public Jumper(Color jumperColor) {
        setColor(jumperColor);
    }

    public void act() {
        if (canJump()) {
            jump();
        }
        else {
            turn();
        }
    }

    public void turn() {
        setDirection(getDirection() + Location.RIGHT);//which is 90 degrees.
    }

    public boolean canJump() {
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location twocell = next.getAdjacentLocation(getDirection());
        if ((!grid.isValid(twocell)) || (!grid.isValid(next))) {
            return false;
        }
        Actor neighbor = grid.get(next);
        neighbor = grid.get(twocell);
        return (neighbor == null) || (neighbor instanceof Flower);
    }

    /*
     *define the action jump
     *one jump for two cells
     */
    public void jump() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location twoCell = next.getAdjacentLocation(getDirection());
        if (gr.isValid(twoCell)) {
            moveTo(twoCell);
        }
    }



}