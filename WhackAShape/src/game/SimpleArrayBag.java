// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.


package game;
import bag.SimpleBagInterface;
import student.TestableRandom;
/**
* @author Angel Ochieng 906590673
* @version 2023.09.18
*/
/**
* @param <T> bag Array class 
*/
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {
    /**
    * Initializing fields. 
    */
    private T[] bag;
    private static final int MAX = 18;
    private int numberOfEntries;
    
    /*
    * Constructor for the Simple Array Bag. 
    */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }
    /**
    * add method, increments entries to our bag
    */

    @Override
    public boolean add(T anEntry) {
        if (numberOfEntries < MAX) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        } 
        else {
            return false;
        }
    }
    /**
    *returns current number of entries in bag 
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
    */

    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom(); 
        int index = generator.nextInt(numberOfEntries);
        return bag[index];
    }
    /**
    * helper method for remove
    * checks if an entry exists in bag 
    * utilizes equals method
	*/

    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }
    /**
    * ensures entries are removed from bag 
	*/

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < numberOfEntries - 1; i++) {
            bag[i] = bag[i + 1];
        }
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }
}