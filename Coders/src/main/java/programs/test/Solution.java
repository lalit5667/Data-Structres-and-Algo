package main.java.programs.test;

import java.util.Vector;

//50033 34389 6963 10804 52611 41717 4372 22667 8162 16385 45463 5364 7443 57826 5364 4987 25844 8549 5592 27926

class Test {
    public static void main(String args[]) {
        int[] A = new int[]{6430, 648, 5697, 1429, 7620, 203, 8471, 5114, 3195, 1185, 665, 6829, 2418, 8657, 3784, 9168, 3139, 8696, 9509, 6963};
        int[][] B = new int[][]{{2, 6, 5663}, {1, 6195, 0}, {1, 5466, 0}, {3, 16, 0}, {2, 4, 2673}, {3, 6, 0}, {2, 14, 5389}, {2, 7, 4883}, {3, 12, 0}, {4, 5, 14}, {4, 3, 10}, {1, 9153, 0}, {3, 19, 0}, {3, 7, 0}, {2, 6, 3184}, {2, 13, 609}, {3, 12, 0}, {3, 10, 0}, {2, 3, 148}, {4, 14, 14}, {4, 5, 6}, {2, 8, 4987}, {3, 6, 0}, {1, 2642, 0}, {3, 15, 0}, {3, 9, 0}, {1, 4870, 0}, {3, 9, 0}, {3, 9, 0}, {1, 3292, 0}, {1, 6516, 0}, {1, 8685, 0}, {4, 4, 14}, {2, 12, 4372}, {1, 1184, 0}, {3, 2, 0}, {4, 8, 14}, {4, 11, 11}, {4, 8, 10}, {4, 12, 13}, {3, 8, 0}, {2, 8, 2456}, {4, 13, 15}, {3, 7, 0}, {2, 11, 8210}, {1, 2360, 0}, {3, 9, 0}, {1, 3004, 0}, {2, 2, 8549}, {1, 5784, 0}, {4, 6, 14}, {1, 9023, 0}, {4, 14, 15}, {3, 9, 0}, {1, 2743, 0}, {3, 4, 0}, {4, 5, 6}, {1, 2398, 0}, {3, 9, 0}, {2, 3, 9452}, {1, 9977, 0}, {4, 4, 15}, {4, 11, 12}, {3, 7, 0}, {3, 11, 0}, {3, 6, 0}, {2, 11, 8189}, {1, 7286, 0}, {3, 15, 0}, {3, 1, 0}, {2, 11, 5592}, {2, 6, 9400}, {3, 13, 0}, {4, 4, 4}, {3, 7, 0}, {1, 2151, 0}, {2, 9, 4085}, {4, 2, 5}, {4, 1, 1}, {1, 7823, 0}, {1, 5877, 0}, {3, 2, 0}, {4, 9, 9}, {1, 4213, 0}, {1, 2408, 0}, {4, 8, 13}, {3, 7, 0}, {1, 7994, 0}, {1, 6018, 0}, {1, 9735, 0}, {3, 16, 0}};
        Solution s = new Solution();
        int[] ans = s.solve(A, B);

        for(int k: ans){
            System.out.print(k + " ");
        }
    }
}

class Solution {
    int N = (int) 2e5 + 10;
    // To store the sum of
    // the array elements
    int[] bit = new int[N];
    // To keep track of how many type 3
    // queries have been performed before
    // a particular index
    int[] idx = new int[N];

    // Function to perform the point
    // update in Fenwick tree
    void update(int idx, int val, int[] bitt) {
        while (idx < N) {
            bitt[idx] += val;
            idx += idx & (-idx);
        }
    }

    // Function to return the sum
    // of the elements A[1...idx]
    // from BIT
    int sum(int idx, int[] bitt) {

        int res = 0;
        while (idx > 0) {
            res += bitt[idx];
            idx -= idx & (-idx);
        }

        return res;
    }

    // Function to perform the queries and
    // return the answer vector
    Vector<Integer> peformQueries(Vector<Integer> A, int[][] B) {

        // For 1 bases indexing
        // insert 0 in the vector
        A.insertElementAt(0, 0);

        // Updated size of the vector
        int n = (int) A.size();

        // Updating the bit tree
        for (int i = 1; i < n; ++i) {
            update(i, A.elementAt(i), bit);
        }

        // Vector to store the answers
        // of range sum
        Vector<Integer> ans = new Vector<>();

        // Iterating in the query
        // vector
        for (int[] i : B) {

            int type = i[0];
            int x = i[1], v = i[2];

            // If the query is of
            // type 1
            if (type == 1) {

                // Updating the tree
                // with x in the last
                update(n, x, bit);

                // Pushing back the value
                // in the original vector
                A.add(x);

                // Incrementing the size
                // of the vector by 1
                n++;
            }

            // If the query is of type 2
            else if (type == 2) {

                // Getting the updated index
                // in case of any query of
                // type 3 occured before it
                int id = x + sum(x, idx);

                // Making the effect to that
                // value to 0 by subtracting
                // same value from the tree
                update(id, -A.elementAt(id), bit);

                // Updating the A[id] to v
                A.set(id, v);

                // Now update the
                // bit by v at x
                update(id, v, bit);
            }

            // If the query is of type 3
            else if (type == 3) {

                // Get the current index
                int id = x + sum(x, idx);

                // Remove the effect of that
                // index from the bit tree
                update(id, -A.elementAt(id), bit);

                // Update the idx tree
                // because one element has
                // been deleted
                update(x, 1, idx);

                // Update the idx val to 0
                A.set(id, 0);
            }

            // If the query is of type 4
            else {

                // Get the updated range
                int xx = x + sum(x, idx);
                int vv = v + sum(v, idx);

                // Push_back the value
                ans.add(sum(vv, bit) - sum(xx - 1, bit));
            }
        }

        return ans;
    }

    public int[] solve(int[] A, int[][] B) {
        Vector<Integer> v = new Vector<>();
        for (int j : A) v.addElement(j);
        Vector<Integer> ans = peformQueries(v, B);
        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}

