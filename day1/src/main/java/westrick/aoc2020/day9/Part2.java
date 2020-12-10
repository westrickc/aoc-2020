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
public class Part2 {

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
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class
                .getResourceAsStream("/day9/input")))) {
            List<Long> data = input.lines().map(Long::parseLong).collect(Collectors.toList());

            long invalidNumber = -1;
            for (int i = 25; i < data.size(); ++i) {
                if (!isSum(data, i)) {
                    invalidNumber = data.get(i);
                    break;
                }
            }

            // Find run of numbers that adds up to invalid number
            int start = 0;
            int end = 1;
            for (start = 0; start < data.size() - 1; ++start) {
                long sum = data.get(start);
                for (end = start + 1; end < data.size(); ++end) {
                    sum += data.get(end);
                    if (sum >= invalidNumber) {
                        break;
                    }
                }
                if (sum == invalidNumber) {
                    break;
                }
            }
            List<Long> run = data.subList(start, end + 1);

            // Get smallest
            long smallest = run.stream().reduce(Long.MAX_VALUE, Long::min);
            // Get largest
            long largest = run.stream().reduce(Long.MIN_VALUE, Long::max);

            System.out.println(smallest + largest);

        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
