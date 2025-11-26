package dailymixes;

import java.io.FileNotFoundException;

import bsh.ParseException;

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
