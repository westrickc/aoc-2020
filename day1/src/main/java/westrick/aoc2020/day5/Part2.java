package westrick.aoc2020.day5;

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
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class
                .getResourceAsStream("/day5/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());

            boolean[] seats = new boolean[931];
            for (String s : data) {
                int row = strToRow(s.substring(0, 7));
                int col = strToCol(s.substring(7, 10));
                int seatID = rcToSeatID(row, col);
                seats[seatID] = true;
            }
            
            for (int i=1; i<seats.length-1; ++i) {
                if (seats[i-1] && !seats[i] & seats[i+1]) {
                    System.out.println(i);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
