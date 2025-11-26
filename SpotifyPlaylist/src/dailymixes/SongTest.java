package dailymixes;

import student.TestCase;

//Virginia Tech Honor Code Pledge:
//Project 4 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
 * The implementing the song test class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class SongTest extends TestCase {
    /**
     * sets test cases up
     */
    public void setUp() {
        Song song = new Song("Birds", 30, 40, 50, "Christian");
    }

    /**
     * tests the get playlist method
     */
    public void testGetPlaylist() {
        Song song = new Song("Birds", 30, 40, 50, "Christian");
        assertEquals("Christian", song.getPlaylistName());
    }

    /**
     * tests the tostring method
     */
    public void testToString() {
        Song song = new Song("Birds", 30, 40, 50, "Christian");
        assertEquals("Birds Pop:30 Rock:40 Country:50 Suggested: Christian", 
                song.toString());
        
    }
    /**
     * tests the get name method
     */
    public void testGetName() {
        Song song = new Song("Birds", 30, 40, 50, "Christian");
        assertEquals("Birds", song.getName());
        
    }

    /**
     * tests the equals method
     */
    public void testEquals() {
        Song song = new Song("Birds", 30, 40, 50, "Christian");
        Song song2 = new Song("Cows", 40, 50, 90, null);
        Song song3 = new Song("Birds", 30, 40, 50, "Christian");
        assertTrue(song.equals(song3));
        assertFalse(song2.equals(song));
        assertFalse(song.equals("cat"));
        assertFalse(song3.equals(null));
        assertTrue(song.equals(song));
        assertFalse(song2.equals(song3));

    }
}
