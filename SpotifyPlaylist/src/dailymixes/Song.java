package dailymixes;

//Virginia Tech Honor Code Pledge:
//Project 4 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
 * The implementing the song class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class Song {
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;
    private int pop;
    private int rock;
    private int country;

    /**
     * constructor for the Song class
     * 
     * @param pop       genre
     * @param rock      genre
     * @param country   genre
     * @param name      song
     * @param suggested playlist
     */
    public Song(String name, int pop, int rock, int country, String suggested) {
        this.name = name;
        this.suggestedPlaylist = suggested;
        this.country = country;
        this.rock = rock;
        this.pop = pop;
        this.genreSet = new GenreSet(pop, rock, country);
    }

    /**
     * @return playlist name
     */
    public String getPlaylistName() {
        return suggestedPlaylist;
    }

    /**
     * @return string representation 
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (suggestedPlaylist.isEmpty()) {
            builder.append("No-Playlist ");
        }
        builder.append(name).append(" ").append(genreSet.toString());
        if (!suggestedPlaylist.isEmpty()) {
            builder.append(" Suggested: ").append(suggestedPlaylist);
        }
        return builder.toString();
    } 
    

    /**
     * defines what makes object equal
     * 
     * @param obj being compared 
     * @return obj being compared 
     * 
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Song other = (Song) obj;
        return this.name == 
                other.name && 
                this.pop == other.pop 
                && this.rock == other.rock
                && this.country == other.country && 
                this.suggestedPlaylist.equals(other.suggestedPlaylist);

    }
    /**
     * @return  name
     */
    public String getName() {
        return name;
    }
    /**
     * @return genreSet
     */

    public GenreSet getGenreSet() {
        return genreSet;
    }
}
