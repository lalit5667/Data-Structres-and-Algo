package main.java.programs.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Input String  : My name is Lalit Kumar
 * output: yM eman si tilaL ramuK
 */

class Node {
    Node left;
    Node right;
    int data;

    Node(int x) {
        left = null;
        right = null;
        data = x;
    }
}

class Paytm {

    public static void main(String args[]) {
        System.out.println(reverseWords("My name is Lalit Kumar"));
    }

    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static void printSpiral(int[][] A) {
        int N = A.length;
        int p = N - 1, q = N - 1;
        int x = 0, y = 0;

        int count = 0;

        while (count < N * N) {

            //left to right
            for (int i = y; i <= q; i++) {
                System.out.print(A[x][i] + " ");
                count++;
            }
            x++;


            // right to down
            for (int i = x; i <= p; i++) {
                System.out.print(A[i][q] + " ");
                count++;
            }
            p--;

            //down to left
            for (int i = p; i >= 0; i--) {
                System.out.print(A[q][i] + " ");
                count++;
            }
            q--;

            //left to top
            for (int i = p; i >= x; i--) {
                System.out.print(A[i][y] + " ");
                count++;
            }
            y++;
        }

    }

    public boolean isMirror(Node left, Node right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.data != right.data) {
            return false;
        }
        boolean l = isMirror(left.left, right.right);
        boolean r = isMirror(left.right, right.left);
        return l && r;
    }

}
