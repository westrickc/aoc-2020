package westrick.aoc2020.day8;

import westrick.aoc2020.day7.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
                .getResourceAsStream("/day8/input")))) {
            List<String> program = input.lines().collect(Collectors.toList());

            int acc = 0;
            int pc = 0;
            int[] executeCount = new int[program.size()];
            while (true) {
                executeCount[pc] += 1;
                if (executeCount[pc] > 1) {
                    break;
                }
                String instruction = program.get(pc);
                String op = instruction.substring(0, 3);
                int arg = Integer.parseInt(instruction.substring(4));
                if ("acc".equals(op)) {
                    acc += arg;
                    ++pc;
                } else if ("jmp".equals(op)) {
                    pc += arg;
                } else if ("nop".equals(op)) {
                    ++pc;
                }
            }
            System.out.println(acc);
        } catch (IOException ex) {
            Logger.getLogger(Part1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
