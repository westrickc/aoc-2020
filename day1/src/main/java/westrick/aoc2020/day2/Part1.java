package westrick.aoc2020.day2;

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
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("/day2/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());
            int validPasswords = 0;
            for (int i=0; i<data.size()-1; ++i) {
                String[] fields = data.get(i).split("[- :]");
                assert(fields.length == 5);
                int min = Integer.parseInt(fields[0]);
                int max = Integer.parseInt(fields[1]);
                char c = fields[2].charAt(0);
                String password = fields[4];
                
                // validate
                // count occurences of c
                int occurences = 0;
                for (char d : password.toCharArray()) {
                    if (c == d) {
                        ++occurences;
                    }
                }
                
                if (occurences >= min && occurences <= max) {
                    ++validPasswords;
                }
            }
            System.out.println("Valid passwords = " + validPasswords);
        } catch (IOException ex) {
            Logger.getLogger(Part1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
