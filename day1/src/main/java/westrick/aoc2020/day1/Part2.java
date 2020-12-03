package westrick.aoc2020.day1;

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
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("/input")))) {
            List<Integer> data = input.lines().map(Integer::parseInt).collect(Collectors.toList());
            // Search
            for (int i = 0; i < data.size() - 2; ++i) {
                int x = data.get(i);
                for (int j = i; j < data.size() - 1; ++j) {
                    int y = data.get(j);
                    for (int k = j; k < data.size(); ++k) {
                        int z = data.get(k);
                        if (x + y + z == 2020) {
                            // Output
                            System.out.println("" + x + "*" + y + "*" + z + "=" + x * y * z);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
