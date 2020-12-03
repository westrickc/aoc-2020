package westrick.aoc2020.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Corey
 */
public class Part1 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("/day3/input")))) {
            List<char[]> map = input.lines().map(l -> l.toCharArray()).collect(Collectors.toList());
            int width = map.get(0).length;
            int height = map.size();
            int slope = 3;

            // Count trees
            int trees = 0;
            int col = 0;
            for (int row = 0; row < height; ++row) {
                if (map.get(row)[col] == '#') {
                    ++trees;
                }

                col = (col + slope) % width;
            }
            
            System.out.println(trees);
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
