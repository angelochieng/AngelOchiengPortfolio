//Project 1 2025 Spring
// -- AngelOchieng
package project1;
import java.awt.Color;

import bag.Bag;
import bag.BagInterface; import cs2.TextShape;
import student.TestableRandom; import cs2.Window; import cs2.Button;
import cs2.WindowSide;
/**
 * @author Angel Ochieng
 * @version 2015.02.17, 2015.06.15
 * Class containing GUI functionality necessary for project
 */
public class ShapeWindow {
	private Window window;
	private TextShape textShape;
	private Button quitButton;
	private Button chooseButton;
	private BagInterface<String> itemBag;
	/**
     * Creating and implementing object buttons.
     * Creating new instance of Project1 class. 
     * Implementing shape        
     */
	public ShapeWindow(BagInterface<String> itemBag) {
        window = new Window();
        window.setTitle("Project1");
        this.itemBag = itemBag;
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);

        textShape = new TextShape(0,0, "");
        window.addShape(textShape);
    }
	/**
	 * Event handler for the "quit" button. Closes the window.
	 * 
	 * @param quitButton
	 *            the button that closes the system.
	 */
	public void clickedQuit(Button button) {
        System.exit(0);
	}
	/**
	 * Event handler for the "Choose" button. Changes the shape's color.
	 * loops through bag items and removes if empty
	 * @param ChooseButton
	 *            the button that originates the event.
	 */
	public void clickedChoose(Button button) {
		if (!itemBag.isEmpty()) {
			String item = itemBag.remove();
			textShape.setText(item);
			
		} else {
			textShape.setText("No more Items");
		}
		
		colorText();
		centerText();
		
		
	}
	/**
	 * Checks if text contains the string and returns respective color            
	 */
	private void colorText() {
		String text = textShape.getText();
		if (text.contains("red")) {
			textShape.setForegroundColor(Color.RED);
		} else if (text.contains("blue")) {
			textShape.setForegroundColor(Color.BLUE);
		} else {
			textShape.setForegroundColor(Color.BLACK);
		}
	}
	/**
	 * Checks if text is centered on the screen.            
	 */
	private void centerText() {
		int windowWidth = window.getGraphPanelWidth();
		int windowHeight = window.getGraphPanelHeight();
		
		int textWidth = textShape.getWidth();
		int textHeight = textShape.getHeight();
		
		int x = (windowWidth - textWidth) /2;
		int y = (windowHeight - textHeight) /2;
		textShape.moveTo(x, y);
	}
}
