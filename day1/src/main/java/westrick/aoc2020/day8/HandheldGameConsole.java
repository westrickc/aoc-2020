package westrick.aoc2020.day8;

import java.util.List;

public class HandheldGameConsole {

    private int acc = 0;
    private int pc = 0;

    public boolean execute(List<String> program) {
        int pc = 0;
        int[] executeCount = new int[program.size()];
        while (pc < program.size()) {
            // Infinite loop detector
            executeCount[pc] += 1;
            if (executeCount[pc] > 1) {
                return false;
            }

            // "Decode" the instruction
            String instruction = program.get(pc);
            String op = instruction.substring(0, 3);
            int arg = Integer.parseInt(instruction.substring(4));

            // Execute
            if ("acc".equals(op)) {
                acc += arg;
                ++pc;
            } else if ("jmp".equals(op)) {
                pc += arg;
            } else if ("nop".equals(op)) {
                ++pc;
            }
        }
        return true;
    }

    public int getAcc() {
        return acc;
    }

    public int getPc() {
        return pc;
    }
}
