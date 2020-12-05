package westrick.aoc2020.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Corey
 */
public class Part1 {

    static int strToRow(String s) {
        int low = 0;
        int high = (1 << s.length()) - 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'B') {
                low += (high - low + 1) / 2;
            } else if (s.charAt(i) == 'F') {
                high -= (high - low + 1) / 2;
            }
        }
        assert (low == high);
        return low;
    }

    static int strToCol(String s) {
        int low = 0;
        int high = (1 << s.length()) - 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'R') {
                low += (high - low + 1) / 2;
            } else if (s.charAt(i) == 'L') {
                high -= (high - low + 1) / 2;
            }
        }
        assert (low == high);
        return low;
    }

    static int rcToSeatID(int r, int c) {
        return r * 8 + c;
    }

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class
                .getResourceAsStream("/day5/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());

            int maxSeatID = -1;
            for (String s : data) {
                int row = strToRow(s.substring(0, 7));
                int col = strToCol(s.substring(7, 10));
                int seatID = rcToSeatID(row, col);
                maxSeatID = Math.max(seatID, maxSeatID);
            }

            System.out.println(maxSeatID);
        } catch (IOException ex) {
            Logger.getLogger(Part1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
