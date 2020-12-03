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
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("/day2/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());
            int validPasswords = 0;
            for (int i = 0; i < data.size(); ++i) {
                String[] fields = data.get(i).split("[- :]");
                assert (fields.length == 5);
                int pos1 = Integer.parseInt(fields[0]);
                int pos2 = Integer.parseInt(fields[1]);
                char c = fields[2].charAt(0);
                String password = fields[4];

                // validate
                // count occurences of c
                int occurences = 0;
                if (password.charAt(pos1 - 1) == c) {
                    occurences++;
                }
                if (password.charAt(pos2 - 1) == c) {
                    occurences++;
                }

                if (occurences == 1) {
                    ++validPasswords;
                }
            }
            System.out.println("Valid passwords = " + validPasswords);
        } catch (IOException ex) {
            Logger.getLogger(Part2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
