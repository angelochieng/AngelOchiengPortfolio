package dailymixes;

import student.TestCase;


/**
 * Testing the functionality of GenreSet test class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class GenreSetTest extends TestCase {
    /**
     * sets up test cases
     */
    public void setUp() {
        GenreSet set = new GenreSet(10, 5, 2);
    }

    /**
     * tests the lessthanequalto method
     */
    public void testLessEqual() {
        GenreSet set1 = new GenreSet(10, 5, 2);
        GenreSet set2 = new GenreSet(20, 10, 5);
        assertTrue(set1.isLessThanOrEqualTo(set2));
        assertFalse(set2.isLessThanOrEqualTo(set1));
        assertTrue(set1.isLessThanOrEqualTo(set1));
        GenreSet set4 = new GenreSet(10, 20, 31);
        assertTrue(set1.isLessThanOrEqualTo(set4));
    } 

    /**
     * tests the withinrange method
     */
    public void testWithinRange() {
        GenreSet set1 = new GenreSet(30, 40, 30);
        GenreSet set2 = new GenreSet(5, 10, 10);
        GenreSet set3 = new GenreSet(60, 80, 50);
        GenreSet set4 = new GenreSet(30, 40, 30);
        GenreSet set5 = new GenreSet(10, 20, 15);
        GenreSet set6 = new GenreSet(50, 70, 40);
        assertTrue(set1.isWithinRange(set5, set6));
        assertFalse(set2.isWithinRange(set5, set6));
        assertFalse(set3.isWithinRange(set5, set6));
        assertTrue(set4.isWithinRange(set5, set6));
        

    }
    /**
     * tests the equals method
     */
    public void testEquals() {
        GenreSet set1 = new GenreSet(50, 40, 30);
        GenreSet set2 = new GenreSet(50, 40, 30);
        GenreSet set3 = new GenreSet(5, 10, 15);
        assertTrue(set1.equals(set2));
        assertFalse(set3.equals(set1));
        assertFalse(set1.equals("cat"));
        assertFalse(set1.equals(null));
        assertTrue(set1.equals(set1));
    }
    /**
     * tests the compare method
     */
    public void testCompare() {
        GenreSet set1 = new GenreSet(10, 20, 30);
        GenreSet set2 = new GenreSet(10, 20, 30);
        GenreSet set3 = new GenreSet(20, 35, 45);
        assertEquals(0, set1.compareTo(set2));
        assertTrue(set1.equals(set2));
        assertFalse(set1.equals(set3));
        assertTrue(set1.equals(set1));
        assertFalse(set3.compareTo(set1) < 0);
        assertFalse(set1.compareTo(set3) > 0);
       
        
    }
    /**
     * tests the tostring method
     */
    public void testString() {
        GenreSet set1 = new GenreSet(10, 20, 30);
        assertEquals("Pop:10 Rock:20 Country:30", set1.toString());
    }
    /**
     * tests the Rock method
     */
    public void testRock() {
        GenreSet set1 = new GenreSet(10, 20, 30);
        assertEquals(20, set1.getRock());
    }
    /**
     * tests the pop method
     */
    public void testPop() {
        GenreSet set1 = new GenreSet(10, 20, 30);
        assertEquals(10, set1.getPop());
    }
    /**
     * tests the country method
     */
    public void testCountry() {
        GenreSet set1 = new GenreSet(10, 20, 30);
        assertEquals(30, set1.getCountry());
    }
    

}
