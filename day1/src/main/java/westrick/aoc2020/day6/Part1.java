package westrick.aoc2020.day6;

import westrick.aoc2020.day5.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
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
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class
                .getResourceAsStream("/day6/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());
         
            int numGroups = 0;
            int totalYesAnswers = 0;
            for (int i=0; i<data.size(); ++i) {

                HashSet<Character> answers = new HashSet<Character>();
                for (; i<data.size(); ++i) {
                    String line = data.get(i);
                    if (line.isBlank()) {
                        // End of group
                        break;
                    }
                    
                    for (char c : line.toCharArray()) {
                        answers.add(c);
                    }
                }
                // end of group
                numGroups++;
                System.out.println("Group " + numGroups + " = " + answers.size());
                totalYesAnswers += answers.size();
            }
            
            System.out.println(numGroups);
            System.out.println(totalYesAnswers);

        } catch (IOException ex) {
            Logger.getLogger(Part1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
