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
 * The implementing the playlist test class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */

public class PlaylistTest extends TestCase {
    /**
     * sets up test cases
     */
    public void setUp() {
        // Initialize GenreSets for min and max
        GenreSet minGenreSet = new GenreSet(30, 50, 50);
        GenreSet maxGenreSet = new GenreSet(5, 15, 30);

    }

    /**
     * test min genre method
     */
    public void testMinGenre() {
        GenreSet minGenreSet = new GenreSet(10, 20, 30);
        Playlist playlist = 
                new Playlist("Christian", 10, 20, 30, 40, 5, 50, 20);
        assertEquals(minGenreSet, playlist.getMinGenreSet());
    }

    /**
     * test max genre method
     */
    public void testMaxGenre() {
        GenreSet maxGenreSet = new GenreSet(40, 5, 50);
        Playlist playlist = 
                new Playlist("Christian", 10, 20, 30, 40, 5, 50, 20);
        assertEquals(maxGenreSet, playlist.getMaxGenreSet());
    }

    /**
     * test spaces left method
     */

    public void testGetSpacesLeft() {
        Playlist playlist = 
                new Playlist("Christian", 10, 20, 30, 40, 5, 50, 20);
        assertEquals(0, playlist.getSpacesLeft());
    }

    /**
     * test compare method
     */

    public void testCompareTo() {
        Playlist base = 
                new Playlist("Christian", 10, 10, 10, 60, 60, 60, 5);
        Playlist identical = 
                new Playlist("Christian", 10, 10, 10, 60, 60, 60, 5);
        assertEquals(0, base.compareTo(identical));
    }

    /**
     * test addsong method
     */
    public void testAddSong() {
        Playlist playlist = 
                new Playlist("Christian", 10, 20, 30, 40, 5, 50, 20);
        assertEquals(0, playlist.getNumberOfSongs());
        assertTrue(playlist.isFull());

    }

    /**
     * test equals method
     */
    public void testEquals() {
        Playlist playlist = 
                new Playlist("Christian", 10, 20, 30, 40, 5, 50, 20);
        Playlist playlist2 = 
                new Playlist("Rock", 10, 20, 30, 40, 5, 50, 20);
        Playlist playlist3 = 
                new Playlist("country", 5, 10, 15, 40, 5, 50, 20);
        assertFalse(playlist.equals(playlist3));
        assertTrue(playlist.equals(playlist));
        assertFalse(playlist.equals(playlist2));
    }

}