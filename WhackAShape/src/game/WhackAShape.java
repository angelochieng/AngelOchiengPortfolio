// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.

package game;
/**
* @author Angel Ochieng
* @version 2023.09.18
*/
import cs2.*;
import bag.SimpleBagInterface;
import student.TestableRandom;
import java.awt.Color;

public class WhackAShape {
	/**
     * tests initializing fields
     */

	private SimpleBagInterface<Shape> bag;
	private Window window;
	private Button quitButton;
	

	private static final String[] STRINGS = { "red circle", "blue circle", "red square", "blue square" };
	/**
     * defining methods necessary for whack a shape class
     */
	public WhackAShape() {
		window = new Window(); 
		bag = new SimpleArrayBag<>();
		quitButton = new Button("Quit");
		window.addButton(quitButton, WindowSide.SOUTH);
		TestableRandom generator = new TestableRandom();
		int min = 6;
		int max = 15;
		int range = max - min;
		int bagSize = generator.nextInt(range) + min;
		for (int i = 0; i < bagSize; i++) {
			String randomString = STRINGS[generator.nextInt(STRINGS.length)];
			bag.add(buildShape(randomString));
		}
		Shape firstShape = bag.pick();
		window.addShape(firstShape);
	}
	/**
     * initializing strings to be constant
     */

	public WhackAShape(String[] inputs) {
		window = new Window();
		bag = new SimpleArrayBag<>();
		quitButton = new Button("Quit");
		window.addButton(quitButton, WindowSide.SOUTH);

	}
	/**
     * parses the provided input
     * 
     */

	private Shape buildShape(String input) {
        TestableRandom generator = new TestableRandom();
  
        int size = generator.nextInt(101) + 100;
        
        int x = generator.nextInt(window.getGraphPanelWidth() - size);
        int y = generator.nextInt(window.getGraphPanelHeight() - size);

        Color color;
        if (input.contains("red")) {
            color = Color.RED;
        } else if (input.contains("blue")) {
            color = Color.BLUE;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
        Shape currentShape;
        if (input.contains("circle")) {
            currentShape = new CircleShape(x, y, size, color);
        } else if (input.contains("square")) {
            currentShape = new SquareShape(x, y, size, color);
        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;
	}
	/**
     * event handler for the the clicked house
     */
	private void clickedShape(Shape shape) {
		window.removeShape(shape);
		bag.remove(shape);
		Shape nextShape = bag.pick();

		if (nextShape == null) {
			TextShape other = new TextShape(window.getGraphPanelWidth() / 2, window.getGraphPanelHeight() / 2,
					"You win");
			window.addShape(other);

		} else {
			window.addShape(nextShape);
		}

	}
	/**
     * event handler for the clicked quit button
     * @param quit button 
     */

	public void clickedQuit(Button button) {
		System.exit(0);
	}
	/**
     * returns window
     */

	public Window getWindow() {
		return window;

	}
	/**
     * returns bag
     */

	public SimpleBagInterface<Shape> getbag() {
		return bag;
	}
}
