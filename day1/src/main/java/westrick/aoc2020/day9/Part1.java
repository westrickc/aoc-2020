package westrick.aoc2020.day9;

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

    static boolean isSum(List<Long> data, int index) {
        int start = index - 25;
        int end = index;
        long value = data.get(index);
        for (int i = start; i < end - 1; ++i) {
            for (int j = i + 1; j < end; ++j) {
                if (value == data.get(i) + data.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class
                .getResourceAsStream("/day9/input")))) {
            List<Long> data = input.lines().map(Long::parseLong).collect(Collectors.toList());

            for (int i = 25; i < data.size(); ++i) {
                if (!isSum(data, i)) {
                    System.out.println(data.get(i));
                    break;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Part1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
