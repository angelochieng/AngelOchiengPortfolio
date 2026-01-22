package dailymixes;

import java.io.FileNotFoundException;

import bsh.ParseException;

/**
 * The implementing the song test class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class ProjectRunner {
    public static void main(String[] args) throws FileNotFoundException, ParseException, DailyMixDataException, java.text.ParseException {
        PlaylistReader reader;
        if (args.length == 2) {
            reader = new PlaylistReader(args[0], args[1]);
        } else {
            reader = new PlaylistReader("input.txt", "playlist.txt");
        }
        
       
    }
}
