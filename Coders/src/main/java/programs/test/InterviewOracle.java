package main.java.programs.test;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Array Of integers
 * [1, 2, 1, 2, 4, 6, 6]  ->  1, 2, 4, 6 -> 4
 * 1  2
 * [1, 2, 3] -> [1, 2, 3] -> 3
 * [ 7, 7, 7, 7] -> [7] -> 1
 *
 */
public class InterviewOracle {

    public static void main(String[] args){
        int[] A = new int[]{1, 2, 1, 2, 4, 6, 6};
        int ans = removeDuplicate(A);
        System.out.println("Distinct Elements: " + ans);
        for(int i=0; i<ans; i++){
            System.out.print(A[i] + " ");
        }
    }

    public static int removeDuplicate(int[] A) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int x : A) {
            if(!set.contains(x)) {
                set.add(x);
                A[index++] = x;
            }
        }
        return index;
    }

}
