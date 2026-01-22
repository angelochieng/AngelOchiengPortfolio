package dailymixes;

import student.TestCase;

/**
 * Testing the funcionality of the test class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 * 
 */
/**
 * @param <T> array 
 */
public class ArrayQueueTest<T> extends TestCase {

    /**
     * tests the is clear method
     */
    @SuppressWarnings("unchecked")
    public void testClear() {
        ArrayQueue<T> apple = new ArrayQueue<>();
        apple.enqueue((T) "A");
        apple.enqueue((T) "B");
        apple.enqueue((T) "C");
        apple.clear();
        assertEquals(0, apple.getSize());
        assertEquals(21, apple.getLengthOfUnderlyingArray());

    }

    /**
     * tests the to string method
     */

    public void testToString() {
        ArrayQueue<Integer> bear = new ArrayQueue<>();
        assertEquals("[]", bear.toString());
        bear.enqueue(1);
        bear.enqueue(2);
        bear.enqueue(3);
        assertEquals("[1, 2, 3]", bear.toString());
    }

    /**
     * tests the equals method
     */

    public void testEquals() {
        ArrayQueue<Integer> cat = new ArrayQueue<>();
        ArrayQueue<Integer> egg = new ArrayQueue<>();
        cat.enqueue(1);
        cat.enqueue(2);
        assertFalse(cat.equals(egg));
        assertFalse(cat.equals("dog"));
        cat.enqueue(3);
        assertFalse(cat.equals(egg));
        assertTrue(cat.equals(cat));
    }

    /**
     * tests the isEmpty method
     */
    public void testIsEmpty() {
        ArrayQueue<Integer> elf = new ArrayQueue<>();
        assertTrue(elf.isEmpty());
        elf.enqueue(1);
        assertFalse(elf.isEmpty());
    }

    /**
     * tests the dequeue method
     */
    public void testDequeue() {
        ArrayQueue<T> fish = new ArrayQueue<>();
        Exception thrown = null;
        try {
            fish.dequeue();

        } 
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);

    }

    /**
     * tests the underlying array method
     */
    public void testUnderlyingArray() {
        ArrayQueue<Integer> grape = new ArrayQueue<>();
        assertEquals(21, grape.getLengthOfUnderlyingArray());
    }

    /**
     * tests the getfront method
     */
    public void testGetFront() {
        ArrayQueue<Integer> house = new ArrayQueue<>();
        Exception thrown = null;
        try {
            house.getFront();

        } 
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
    }

    /**
     * tests the toarray method
     */
    public void testToArray() {
        ArrayQueue<Integer> indigo = new ArrayQueue<>();

        Exception thrown = null;
        try {
            indigo.toArray();

        } 
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        indigo.enqueue(1);
        Object[] array = indigo.toArray();
        assertEquals(1, array[0]);
    }

}
