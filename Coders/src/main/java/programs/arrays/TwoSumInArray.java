package main.java.programs.arrays;

import java.util.HashMap;
import java.util.Map;


public class TwoSumInArray {
    
    // To get two numbers from array whose sum equals to given target sum

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer> h = new HashMap<>();
        for (var i = 0; i < array.length; i++) {
            int c = targetSum - array[i];
            if (h.containsKey(c)) {
                return new int[]{array[i], c};
            }
            h.put(array[i], i);
        }
        return new int[]{};
    }
}

