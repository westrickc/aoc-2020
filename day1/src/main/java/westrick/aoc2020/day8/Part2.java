package westrick.aoc2020.day8;

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
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class
                .getResourceAsStream("/day8/input")))) {
            List<String> program = input.lines().collect(Collectors.toList());

            for (int i=0; i<program.size(); ++i) {
                HandheldGameConsole game = new HandheldGameConsole();
                // "Fix" instruction at line i
                List<String> hackedProgram = new ArrayList<>(program);
                String instruction = hackedProgram.get(i);
                if (instruction.startsWith("jmp")) {
                    hackedProgram.set(i, "nop" + instruction.substring(3));
                } else if (instruction.startsWith("nop")) {
                    hackedProgram.set(i, "jmp" + instruction.substring(3));
                } else {
                    // Don't hack acc instructions
                    continue;
                }
                if (game.execute(hackedProgram)) {
                    System.out.println("Terminated!");
                    System.out.println(game.getAcc());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
