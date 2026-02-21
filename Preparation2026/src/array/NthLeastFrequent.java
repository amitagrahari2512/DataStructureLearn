package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The problem in the image is:

Find the Nth least frequent character(s) in a string

Ignore spaces

Consider only alphabetic characters

If multiple characters have the same frequency, return all of them

If n exceeds number of distinct frequencies, return empty list

If multiple characters have same frequency ,return them in alphabetical order
 */

public class NthLeastFrequent {

    public static List<Character> findNthLeastFrequent(String input, int n) {

        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        // Step 1: Count frequency (ignore spaces)
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }
        
        System.out.println("freqMap : "  +freqMap);

        // Step 2: Map frequency -> list of characters
        Map<Integer, List<Character>> frequencyMap = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            frequencyMap
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }
        
        System.out.println("frequencyMap : "  +frequencyMap);

        // Step 3: Sort frequencies
        List<Integer> sortedFrequencies = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(sortedFrequencies);

        // Step 4: Check if n is valid
        if (n > sortedFrequencies.size()) {
            return new ArrayList<>();
        }

        // Step 5: Get nth least frequency
        int targetFrequency = sortedFrequencies.get(n - 1);
        

        List<Character> result = frequencyMap.get(targetFrequency);
        Collections.sort(result);  // alphabetical order

        return result;
    }

    public static void main(String[] args) {
        String input = "AA BBB CCD DDCC EEJJJJ KK";
        int n = 1;

        System.out.println(findNthLeastFrequent(input, n));
    }
}
