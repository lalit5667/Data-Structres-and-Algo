package main.java.programs.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find 2nd non repeated number in an array of integers
 * arr = [1, 3, 4, 7, 2, 3, 4, 10, 12, 10]
 * output = ?
 */

/**
 * Find subarray with given sum
 *
 * arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * arr = {1, 7, 4, 10, 25, 10, 12}, sum = 47
 * arr = {1, 5, 10, 13, 7, 6, 19}, sum = 25
 */
public class DMG {

    public static void main(String[] args){
        int[] A = new int[]{1, 7, 4, 10, 25, 10, 12};

        int[] ans = subArraySum(A, 47);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] subArraySum(int[] A, int sum){
        int p=0, q = 0, temp = 0;
        while(p<A.length || q<A.length){
            if(temp == sum){
                return new int[]{p, q-1};
            }
            else if(q<A.length && temp < sum){
                temp += A[q++];
            }
            else if(p<A.length){
                temp -= A[p++];
            }
        }
        return new int[]{-1, -1};
    }

    public int getNonRepeatedNumber(int[] A){
        if(A == null){
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: A){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int count = 0;
        for(int n: A){
            if(map.get(n) == 1){
                count += 1;
                if(count == 2){
                    return n;
                }
            }
        }
        return -1;
    }
}
