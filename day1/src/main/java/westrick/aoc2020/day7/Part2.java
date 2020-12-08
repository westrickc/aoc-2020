package westrick.aoc2020.day7;

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
public class Part2 {

    public static void main(String[] args) {
        // Read input
        try (BufferedReader input = new BufferedReader(new InputStreamReader(Part2.class
                .getResourceAsStream("/day7/input")))) {
            List<String> data = input.lines().collect(Collectors.toList());

            // Parse input and build graph
            Graph graph = new Graph(data.size());
            for (String line : data) {
                String[] parts = line.split(" bags contain ");
                String outer = parts[0];
                graph.addBag(outer);
                String[] innerList = parts[1].split(" bags?(, |\\.)");
                for (String foobar : innerList) {
                    if ("no other".equals(foobar)) {
                        continue;
                    }
                    String[] baz = foobar.split(" ", 2);
                    int count = Integer.parseInt(baz[0]);
                    String inner = baz[1];
                    graph.addBag(inner);
                    graph.addEdge(outer, inner, count);
                }
            }
            
            // Search the graph
            int count = graph.childrenCount("shiny gold");
            System.out.println(count);
        } catch (IOException ex) {
            Logger.getLogger(Part2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
