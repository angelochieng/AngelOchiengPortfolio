package dailymixes;

import java.util.Arrays;

//Virginia Tech Honor Code Pledge:
//Project 4 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
 * The implementing the playlist class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class Playlist implements Comparable<Playlist> {
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;
    private int minPop;
    private int minRock;
    private int minCountry;
    private int maxPop;
    private int maxRock;
    private int maxCountry;
    private int playlistCap;

    /**
     * constructor for playList class
     *  @param playlistName 
     * @param minPop 
     * @param minRock 
     * @param minCountry 
     * @param maxPop 
     * @param maxRock 
     * @param maxCountry 
     * @param playlistCap 
     */
    public Playlist(String playlistName, 
            int minPop, 
            int minRock, 
            int minCountry, 
            int maxPop, 
            int maxRock,
            int maxCountry, 
            int playlistCap) {
        this.numberOfSongs = 0;
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.playlistCap = playlistCap;
        this.name = playlistName;

    }

    /**
     * @return minGenreSet
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }

    /**
     * sets name
     * @param name being set
     */
    public void setName(String name) {
        this.name = name;

    }

    /**
     * @return maxGenreSet
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }

    /**
     * @return the number of spaces left
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }

    /**
     * @return the similarity
     * @param other obj being compared 
     */
    public int compareTo(Playlist other) {
        int pop = Integer.compare(this.minPop, other.minPop);
        if (pop != 0) {
            return pop;
        }
        int maxpop = Integer.compare(this.maxPop, other.maxPop);
        if (maxpop != 0) {
            return maxpop;
        }
        int rock = Integer.compare(this.minRock, other.minRock);
        if (rock != 0) {
            return rock;
        }
        int maxrock = Integer.compare(this.maxRock, other.maxRock);
        if (maxrock != 0) {
            return maxrock;
        }
        int country = Integer.compare(this.minCountry, other.minCountry);
        if (country != 0) {
            return country;
        }
        int maxcountry = Integer.compare(this.maxCountry, other.maxCountry);
        if (maxcountry != 0) {
            return maxcountry;
        }
        int cap = Integer.compare(this.playlistCap, other.playlistCap);
        if (cap != 0) {
            return capacity;
        }
        int spaces = Integer.compare(this.getSpacesLeft(), 
                other.getSpacesLeft());
        if (spaces != 0) {
            return spaces;
        }
        return this.name.compareTo(other.name);

    }

    /**
     * @return numberofsongs
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    /**
     * @return added song and checks capacity
     * @param newSong being added
     */
    public boolean addSong(Song newSong) {
        if (isFull()) {
            return false;
        }
        if (!isQualified(newSong)) {
            return false;

        }
        songs[numberOfSongs] = newSong;
        numberOfSongs++;
        return true;

    }

    /**
     * @return if full
     */

    public boolean isFull() {
        return numberOfSongs == capacity;
    }

    /**
     * @return the number of spaces left
     * @param possibleSong that qualifies 
     */

    public boolean isQualified(Song possibleSong) {
        GenreSet songGenreSet = possibleSong.getGenreSet();  
        return songGenreSet.isWithinRange(minGenreSet, maxGenreSet);  
    }
    /**
     * @return the playlist as string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Playlist: ").append(name);
        builder.append(", # of songs: ").
        append(numberOfSongs).
        append("(cap:").append(playlistCap).append(")");
        builder.append(", Requires: Pop:").append(minPop).
        append("%-").
        append(maxPop).append("%, ");
        builder.append("Rock:").append(minRock).
        append("%-").append(maxRock).append("%, ");
        builder.append("Country:").append(minCountry).
        append("%-").append(maxCountry).append("%");
        return builder.toString();
    }

    /**
     * @return the number of songs in order
     * @param obj that is compared
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Playlist other = (Playlist) obj;

        if (this.capacity != other.capacity || 
                this.numberOfSongs != other.numberOfSongs) {
            return false;
        }

        return this.name.equals(other.name) && 
                this.minPop == other.minPop && 
                this.minRock == other.minRock
                && this.minCountry == 
                other.minCountry && 
                this.maxPop == 
                other.maxPop && this.maxRock == 
                other.maxRock
                && this.maxCountry == 
                other.maxCountry && 
                Arrays.equals(this.songs, other.songs);
    }

    /**
     * @return the songs
     */
    public Song[] getSongs() {
        return songs;

    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name; 
    }

}
