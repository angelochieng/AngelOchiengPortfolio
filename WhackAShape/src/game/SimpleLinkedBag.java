// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Angel Ochieng 906580673
// * @version 2023.09.10
package game;
import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;
/**
* @author Angel Ochieng 906580673
* @version 2023.09.18
*/
/**
 * @param <T> 
 * simple linked bag class
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    /**
	 * initializes fields
	 */
	private Node<T> firstNode;
	private int numberOfEntries; 
	
	/**
	 * Constructor for the Simple linked Bag. 
	 */
	public SimpleLinkedBag() {
	    firstNode = null;
	    numberOfEntries = 0;
	}
	/**
	 * add method, increments entries to our bag
	 */
	@Override 
	public boolean add(T anEntry) {
		if (anEntry == null) {
		    return false;
		}
		Node<T> newNode = new Node<T>(anEntry, firstNode);
		
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}
	/**
	 * returns current number of entries in bag
	 */
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}
	/**
	 * checks if bag is empty 
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	/**
     * Generates a random numbers
     * utilizes testable random
     */

	@Override
	public T pick() {
		if (isEmpty()) {
			return null;
		}
		TestableRandom generator = new TestableRandom(); 
        int index = generator.nextInt(numberOfEntries);
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
        	currentNode = currentNode.getNext();
        }
        return currentNode.getData();
	}
	/**
     * @param <T> for specified entry
     *     @return found entry
     */

	public Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while (!found && currentNode != null) {
			if (anEntry.equals(currentNode.getData())) {
		        found = true;
			} 
			else {
				currentNode = currentNode.getNext();
			}
		}
		return currentNode;
	}
	/**
     * removes entries in bag 
     */


	@Override
	public boolean remove(T anEntry) {
	    Node<T> newNode = getReferenceTo(anEntry);
        if (newNode == null) {
            return false;
		}
        newNode.setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
		return true;
	}

}
