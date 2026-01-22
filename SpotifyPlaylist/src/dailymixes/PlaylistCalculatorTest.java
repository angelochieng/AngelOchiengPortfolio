package dailymixes;

import student.TestCase;


/**
 * The implementing the playlist class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class PlaylistCalculatorTest extends TestCase {
    private PlaylistCalculator calculator;
    private Playlist[] playlists;
    private ArrayQueue<Song> songQueue;

    /**
     * sets up the tests
     */

    public void setUp() {

        songQueue = new ArrayQueue<>();
        playlists = new Playlist[3];
        playlists[0] = new Playlist("Summer", 0, 0, 0, 5, 10, 15, 20);
        calculator = new PlaylistCalculator(songQueue, playlists);
    }

    /**
     * tests the reject method
     */

    public void testReject() {
        Song song = new Song("Song1", 40, 30, 30, "Christian");
        PlaylistCalculator calculator1 = 
                new PlaylistCalculator(songQueue, playlists);
        songQueue.enqueue(song);
        Playlist[] summer = new Playlist[1];
        summer[0] = new Playlist("Romance", 5, 10, 15, 30, 40, 20, 25);
        calculator1.reject();
        assertEquals(0, songQueue.getSize());
        assertEquals(1, calculator1.getRejectedTracks().getLength());
    }

    /**
     * tests the getplaylist method
     */
    public void testGetPlaylist() {
        Song song = new Song("Song1", 40, 30, 30, "Christian");
        Playlist fall = calculator.getPlaylistForSong(null);
        assertNull(fall);

    }

    /**
     * tests the emptyqueue method
     */
    public void testEmptyQueue() {
        songQueue.clear();
        boolean queue = calculator.addSongToPlaylist();
        assertFalse(queue);

    }

    /**
     * tests the getPlaylist method
     */
    public void testPlaylist() {
        Playlist[] lyn = calculator.getPlaylists();
        assertEquals("Summer", lyn[0].getName());
    }
}
