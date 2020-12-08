package westrick.aoc2020.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Corey
 */
public class Graph {
    private final HashMap<String, Integer> bagToIndex = new HashMap<>();
    private final HashMap<Integer, String> indexToBag = new HashMap<>();
    private final int[][] edges;
    
    public Graph(int numBags) {
        edges = new int[numBags][numBags];
    }
    
    public void addBag(String color) {
        int index = bagToIndex.size();
        bagToIndex.putIfAbsent(color, index);
        indexToBag.put(index, color);
    }
    
    public void addEdge(String outer, String inner, int numInner) {
        int outerIndex = bagToIndex.get(outer);
        int innerIndex = bagToIndex.get(inner);
        edges[outerIndex][innerIndex] = numInner;
    }
    
    public void parents(String bag, Set<String> result) {
        int innerIndex = bagToIndex.get(bag);
        
        for (int i=0; i<edges.length; ++i) {
            if (edges[i][innerIndex] > 0) {
                String parent = indexToBag.get(i);
                result.add(parent);
                parents(parent, result);
            }
        }
    }
    
    public int childrenCount(String bag) {
        return childrenCount(bagToIndex.get(bag));
    }

    private int childrenCount(int bagIndex) {
        int total = 0;
        for(int i=0; i<edges.length; ++i) {
            int count = edges[bagIndex][i];
            if (count > 0) {
                total += count;
                total += count * childrenCount(i);
            }
        }
        return total;
    }
    
}
