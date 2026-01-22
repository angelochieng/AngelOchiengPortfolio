package dailymixes;

/**
 * The implementing the GenreSet class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class GenreSet implements Comparable<GenreSet> {
    private int pop;
    private int rock;
    private int country;

    /**
     * constructor for the GenreSet class
     * 
     * @param pop     genre
     * @param rock    genre
     * @param country genre
     * 
     */
    public GenreSet(int pop, int rock, int country) {
        this.country = country;
        this.rock = rock;
        this.pop = pop;
    }

    /**
     * can check if a song's genreset is accepted based on a playlist's required
     * genreset range.
     * 
     * @param other to be compared
     * @return if value is less than or eq to the other
     * 
     */
    public boolean isLessThanOrEqualTo(GenreSet other) {
        return this.pop <= other.pop &&
                this.rock <= other.rock && 
                this.country <= other.country;
    }

    /**
     * defines range of genreSet
     * aasaX
     * @param minGenreSet returns min genre
     * @param maxGenreSet returns max genre
     * @return if value is greater than the other
     * 
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        return this.pop >= minGenreSet.pop && 
                this.pop <= maxGenreSet.pop && 
                this.rock >= minGenreSet.rock
                && this.rock <= maxGenreSet.rock && 
                this.country >= minGenreSet.country
                && this.country <= maxGenreSet.country;
    }

    /**
     * defines what makes obj equal
     * 
     * @param obj  to be compared 
     * @return true or false if equal
     * 
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        GenreSet other = (GenreSet) obj;
        return this.pop == 
                other.pop && 
                this.rock == 
                other.rock && 
                this.country == other.country;
    }

    /**
     * defines what makes obj equal
     * 
     * @param other set to be compared 
     * @return -1 if less than 
     *      1 if greater than
     * 
     */
    @Override
    public int compareTo(GenreSet other) {
        int x = this.pop + this.rock + this.country;
        int y = other.pop + other.rock + other.country;
        if (x < y) {
            return -1;
        } 
        else if (x > y) {
            return 1;
        } 
        else {
            return 0;
        }
    }

    /**
     * returns string representation of set
     * 
     * @return GenreSet
     */
    public String toString() {
        return "Pop:" + this.pop +
                " Rock:" + this.rock +
                " Country:" + this.country;
    }

    /**
     * gets the pop method
     * 
     * @return pop
     */
    public int getPop() {
        return pop;
    }

    /**
     * gets the rock method
     * 
     * @return rock
     */
    public int getRock() {
        return rock;
    }

    /**
     * gets the country method
     * 
     * @return country
     */
    public int getCountry() {
        return country;
    }
}
