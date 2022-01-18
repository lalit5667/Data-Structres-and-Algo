package main.java.programs.demo3;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 1     5      8     3
 *
 * 2     4      0     0
 *
 * 2     6      8     1
 *
 * (1, 2)
 * (1, 3)
 */


public class ProgramOne {



    public static void main(String[] args){
    }

    /**
     *             19
     *
     * 		  12		29
     *
     *
     * 	     10	       15       20          39
     *
     * p = 12  q = 20
     * [10, 12, 15, 19, 20, 29, 39 ]

     */

//    public boolean twoSum(Tree root, int sum){
//        Stack<Tree> q = new Stack<>();
//        Set<Integer> set = new HashSet<>();
//
//        while(root != null && !q.isEmpty()){
//            while(root != null){
//                q.offer(root);
//                root = root.left;
//            }
//            Tree curr = q.poll();
//            if(set.contains(sum - curr.data)){
//                return true;
//            }
//            set.add(curr.data);
//            root = curr.right;
//        }
//        return false;
//    }

    public static void convertMatrix(int[][] A){

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row: rows){
            Arrays.fill(A[row], 0);
        }

        for(int col: cols){
            for(int i=0; i<A.length; i++){
                A[i][col] = 0;
            }
        }

    }
}


