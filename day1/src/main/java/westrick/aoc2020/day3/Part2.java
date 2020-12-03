package westrick.aoc2020.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Corey
 */
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("/day3/input")))) {
            List<char[]> map = input.lines().map(l -> l.toCharArray()).collect(Collectors.toList());
            int width = map.get(0).length;
            int height = map.size();
            int[] down = {1, 1, 1, 1, 2};
            int[] right = {1, 3, 5, 7, 1};
            long[] trees = new long[down.length];

            // Count trees
            for (int i=0; i<down.length; ++i) {
                trees[i] = 0;
                int col = 0;
                int row = 0;
                while (row < height) {
                    if (map.get(row)[col] == '#') {
                        trees[i] += 1;
                    }

                    row = row + down[i];
                    col = (col + right[i]) % width;
                }
            }
            for (long t : trees) {
                System.out.println(t);
            }
            long product = Arrays.stream(trees).reduce(1, (a,b)->a*b);
            System.out.println(product);
        } catch (IOException ex) {
            Logger.getLogger(Part2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
