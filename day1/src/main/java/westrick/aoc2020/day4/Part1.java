package westrick.aoc2020.day4;

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

    public static final int keyToBit(String key) {
        switch (key) {
            case "byr":
                return 1;
            case "iyr":
                return 1 << 1;
            case "eyr":
                return 1 << 2;
            case "hgt":
                return 1 << 3;
            case "hcl":
                return 1 << 4;
            case "ecl":
                return 1 << 5;
            case "pid":
                return 1 << 6;
            case "cid":
                return 1 << 7;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part1.class
                .getResourceAsStream("/day4/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());

            List<String> records = new ArrayList<>();
            StringBuilder record = new StringBuilder();
            for (String line : data) {
                if (line.isBlank()) {
                    records.add(record.toString());
                    record = new StringBuilder();
                } else {
                    if (record.length() > 0) {
                        record.append(" ");
                    }
                    record.append(line);
                }
            }

            int valid = 0;
            for (String r : records) {
                String[] parts = r.split("[ :]");
                assert ((parts.length) % 2 == 0);
                int fields = 0;
                for (int i = 0; i < parts.length; i += 2) {
                    String key = parts[i];
                    String value = parts[i + 1];
                    fields |= keyToBit(key);
                }
                if (fields == 0b11111111 || fields == 0b1111111) {
                    valid++;
                }
            }
            System.out.println(valid);
        } catch (IOException ex) {
            Logger.getLogger(Part1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
