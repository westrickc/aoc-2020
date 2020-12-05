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
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("/day4/input")))) {
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

                    if ("byr".equals(key)) {
                        int year = Integer.parseInt(value);
                        if (year >= 1920 && year <= 2002) {
                            fields |= 1;
                        }
                    } else if ("iyr".equals(key)) {
                        int year = Integer.parseInt(value);
                        if (year >= 2010 && year <= 2020) {
                            fields |= 1 << 1;
                        }
                    } else if ("eyr".equals(key)) {
                        int year = Integer.parseInt(value);
                        if (year >= 2020 && year <= 2030) {
                            fields |= 1 << 2;
                        }
                    } else if ("hgt".equals(key)) {
                        if (value.endsWith("in")) {
                            int h = Integer.parseInt(value.substring(0, value.length() - 2));
                            if (h >= 59 && h <= 76) {
                                fields |= 1 << 3;
                            }
                        } else if (value.endsWith("cm")) {
                            int h = Integer.parseInt(value.substring(0, value.length() - 2));
                            if (h >= 150 & h <= 193) {
                                fields |= 1 << 3;
                            }
                        }
                    } else if ("hcl".equals(key)) {
                        if (value.matches("#[a-f0-9]{6}")) {
                            fields |= 1 << 4;
                        }
                    } else if ("ecl".equals(key)) {
                        if (value.matches("amb|blu|brn|gry|grn|hzl|oth")) {
                            fields |= 1 << 5;
                        }
                    } else if ("pid".equals(key)) {
                        if (value.matches("[0-9]{9}")) {
                            fields |= 1 << 6;
                        }
                    } else if ("cid".equals(key)) {
                        fields |= 1 << 7;
                    }

                }
                if (fields == 0b11111111 || fields == 0b1111111) {
                    valid++;
                }
            }
            System.out.println(valid);
        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
