package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle (Fall
 * 2024)
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 2;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 15;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) {
        this.game = g;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        window.setSize(700, 700);
      //The height and Y location of each pole are the same
        int poleHeight = 200;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        center = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        
        
        
        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
                width > WIDTH_FACTOR;
                width -= WIDTH_FACTOR) {
                Disk disk = new Disk(width * 10);
                window.addShape(disk);
                game.getTower(Position.LEFT).push(disk);
                moveDisk(Position.LEFT);
                

        }
        window.addShape(left);
        window.addShape(center);
        window.addShape(right);
        Button solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");
    }
    /**
     * Moves the top disk to new position 
     * @param position
     */
    private void moveDisk(Position position) {
        Disk currentDisk = (Disk) game.getTower(position).peek();
        Shape currentPole = null;
        switch (position) {
        case LEFT:
            currentPole = left;
            break;
        case CENTER:
            currentPole = center;
            break;
        case RIGHT:
            currentPole = right;
            break;
        }
        int towerSize = game.getTower(position).size();

        int newY = currentPole.getY() + (towerSize * DISK_GAP);

        int newX = currentPole.getX() + (currentPole.getWidth() - currentDisk.getWidth()) / 2;

        currentDisk.moveTo(newX, newY);
    }

    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o   The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position position = (Position) arg;
            moveDisk(position);
            sleep();
        }
    }

    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
}
