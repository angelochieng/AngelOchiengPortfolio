//Project 1 2025 Spring
//Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// -- AngelOchieng (906580673)
package project1;
import bag.Bag;
import bag.BagInterface; import cs2.TextShape;
import student.TestableRandom; import cs2.Window; import cs2.Button;
import cs2.WindowSide;
/**
 * demonstrates functionality of shapeWindow and display collection 
 * @author Angel Ochieng
 * @version 2015.02.17, 2015.06.15
 */
public class ProjectRunner {
	/**
	 * creates new instance of displayCollection and ShapeWindow
	 */
	public static void main(String[] args) {
		DisplayCollection collection = new DisplayCollection();
		ShapeWindow window = new ShapeWindow(collection.getItemBag());
    }
}
