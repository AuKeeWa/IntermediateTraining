/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>DancingBug</code> traces out a square "Dancing" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug {
    private int currentTurn;
    private int[] turnArray;

    /**
     * Constructs a Dancing bug that traces a square of a given side length
     *
     * @param turns the side length
     */
    public DancingBug(int[] turns) {
        turnArray = new int[turns.length];
        System.arraycopy(turns, 0, turnArray, 0, turns.length);
        currentTurn = 0;
    }

    public void turn(int times) {
        for (int i = 0; i < times; i++) {
            turn();
        }
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if (currentTurn == turnArray.length) {
            currentTurn = 0;
        }
        turn(turnArray[currentTurn]);
        currentTurn++;
        if (canMove()) {
            move();
        }

    }
}
