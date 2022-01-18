package main.java.programs.sample;


/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input. (MEDIUM)

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] B = new int[][]{{1, 4}, {4, 5}};
        int[][] C = new int[][]{{1, 4}, {2, 3}};
        System.out.println(mergeArray(B));
    }

    public static List<List<Integer>> mergeArray(int[][] A) {
        List<List<Integer>> list = new ArrayList<>();

        for (int[] ints : A) {
            int start = ints[0];
            int end = ints[1];

            if (!list.isEmpty()) {
                List<Integer> curr = list.get(list.size() - 1);
                if (curr.get(1) >= start) {
                    curr.set(1, Math.max(curr.get(1), end));
                } else {
                    addInterval(list, start, end);
                }
            } else {
                addInterval(list, start, end);
            }
        }
        return list;
    }

    public static void addInterval(List<List<Integer>> list, int start, int end) {
        List<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);
        list.add(interval);
    }

}
