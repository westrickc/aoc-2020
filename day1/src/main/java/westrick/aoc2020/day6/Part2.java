package westrick.aoc2020.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class
                .getResourceAsStream("/day6/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());
         
            int numGroups = 0;
            int totalYesAnswers = 0;
            int everyoneYesAnswers = 0;
            for (int i=0; i<data.size(); ++i) {

                int persons = 0;
                HashMap<Character, Integer> answers = new HashMap<>();
                for (; i<data.size(); ++i) {
                    String line = data.get(i);
                    if (line.isBlank()) {
                        // End of group
                        break;
                    }
                    persons++;
                    for (char c : line.toCharArray()) {
                        int count = answers.getOrDefault(c, 0);
                        answers.put(c, ++count);
                    }
                }
                // end of group
                numGroups++;

                int everyoneYesCount = 0;
                for (int count : answers.values()) {
                    if (count == persons){
                        everyoneYesCount++;
                    }
                }
                System.out.println("Group " + numGroups + " = " + persons + "," + answers.size() + "," + everyoneYesCount);
                
                
                totalYesAnswers += answers.size();
                everyoneYesAnswers += everyoneYesCount;
            }
            
            System.out.println(numGroups);
            System.out.println(totalYesAnswers);
            System.out.println(everyoneYesAnswers);

        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
