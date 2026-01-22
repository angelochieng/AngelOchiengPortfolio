package dailymixes;

import java.util.Arrays;

import list.AList;

/**
 * The implementing the playlist class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class PlaylistCalculator {
    /**
     * initializing fields
     */

    private Playlist[] playlists;
    /**
     * initializing num playlists
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * initializing minimum percentage
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    /**
     * initializing max percentage
     */
    public static final int MAX_PERCENT = 100;
    /**
     * @param songQueue
     * @param playlists available 
     * @param songQueue songs in queue
     * class constructor 
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, 
            Playlist[] playlists) {
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<Song>();

    }
    /**
     * rejects song and adds song to playlist
     */

    public void reject() {
        if (!songQueue.isEmpty()) {
            rejectedTracks.add(songQueue.dequeue());
        }

    }
    /**
     * attempts to add the next song
     * @return false if song not added to playlist 
     */

    public boolean addSongToPlaylist() {
        if (songQueue.isEmpty()) {
            return false;
        }
        Song nextSong = songQueue.getFront();
        Playlist suggested = getPlaylistForSong(nextSong);
        if (suggested != null) {
            suggested.addSong(nextSong);
            songQueue.dequeue();
            return true;
        }

        return false;

    }
    /**
     * @return if song accepted to playlist 
     * helper method to add songs to playlist 
     */

    private boolean canAccept(Playlist playlist, Song song) {
        return !playlist.isFull() && playlist.isQualified(song);
    }
    /**
     * @return greatest playlist capacity for 
     * song to be added to
     * @param nextSong to be added 
     */

    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        String x = nextSong.getPlaylistName();
        if (!x.isEmpty()) {
            int index = getPlaylistIndex(x);
            if (index >= 0) {
                Playlist playlist = playlists[index];
                if (!playlist.isFull() && playlist.isQualified(nextSong)) {
                    return playlist;
                }
            }
            return null;
        }
        
        return getPlaylistWithMaximumCapacity(nextSong);
    } 
    /**
     * helper method that aids in adding songs to playlist
     * @return null if song not accepted
     */

    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        Playlist[] copy1 = Arrays.copyOf(playlists, playlists.length);
        Arrays.sort(copy1);
        for (int i = 0; i < copy1.length; i++) {
            if (canAccept(copy1[i], aSong)) {
                return copy1[i];
            }
        }
        return null;
    }
    /**
     * gets the songs in queue
     * @return songQueue
     */

    public ArrayQueue<Song> getQueue() {
        return songQueue;

    }
    /**
     * returns int representation of 
     * given string
     * @param playlist returns the index of playlist
     * @return -1 
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;

    }
    /**
     * gets playlists
     * @return playlists
     */
    public Playlist[] getPlaylists() {
        return playlists;

    }
    /**
     * gets rejected tracks 
     * @return rejected Tracks 
     */

    public AList<Song> getRejectedTracks() {
        return rejectedTracks;

    }

}
