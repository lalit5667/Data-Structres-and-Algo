package main.java.programs.sample;
//
//import java.util.*;
//
////class Trie{
////    public Trie even;
////    public Trie odd;
////    public int count;
////    public boolean isEnd;
////    public Trie(){
////        even = null;
////        odd = null;
////        count = 0;
////        isEnd = false;
////    }
////}
//
//class Fraction{
//    public double value;
//    public int num;
//    public int den;
//    public Fraction(double v, int n, int d){
//        num = n;
//        den = d;
//        value = v;
//    }
//}
//public class Solution {
//    static int[] tree;
//
//    public static void main(String[] args) {
//
////        int[] a = solve(new int[]{1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297}, 42);
////       System.out.println(a[0] + " " + a[1]);
//
//    //    System.out.println(coinchange2(new int[]{1, 2, 3}, 4));
//        System.out.println(longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
//
//    }
//
//
//    public static int longestValidParentheses(String A) {
//        int N = A.length();
//        dp = new int[N];
//        int max = 0;
//        char[] arr = A.toCharArray();
//
//        for(int i = 0; i<N; i++){
//            char ch = arr[i];
//
//            if(i > 0 && ch == ')'){
//                char prev = arr[i-1];
//
//                if(prev == '('){
//                    dp[i] =  ((i-1>0)?dp[i-2]:0) + 2;
//                }else{
//                    int l = dp[i-1];
//                    if(i-l-1>=0 && arr[i-l-1] == '('){
//                        dp[i] = ((i-l-1>0)?dp[i-l-2]:0) + 2 + dp[i-1];
//                    }
//
//
//                }
//
//
//            }
//            max = Math.max(dp[i], max);
//
//        }
//        return max;
//    }
//
//    int MOD = 1000 * 1000 + 7;
//    static int[] dp;
//    public static int coinchange2(int[] A, int B) {
//        Arrays.sort(A);
//        dp = new int[B+1];
//        Arrays.fill(dp, -1);
//
//        return count(B, 0, A);
//    }
//
//    public static int count(int N, int index, int[] A){
//
//        if(index == A.length || N < 0){
//            return 0;
//        }
//
//        if(N == 0){
//            return 1;
//        }
//
//        if(dp[N] != -1){
//            return dp[N];
//        }
//
//        int ans = count(N - A[index], index, A) + count(N, index + 1, A);
//
//        dp[N] = ans;
//        return ans;
//    }
//
//
//    public static int[] solve(int[] A, int B) {
//
//        Arrays.sort(A);
//
//        PriorityQueue<Fraction> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.value, p2.value));
//
//        for(int i=0; i<A.length; i++){
//            for(int j=A.length-1; j>i; j--){
//                pq.offer(new Fraction(Double.valueOf(A[i])/Double.valueOf(A[j]), i, j));
//            }
//        }
//
//        int n = 0, d = 0;
//        for(int i=0; i<B; i++){
//            Fraction f = pq.poll();
//            n = f.num;
//            d = f.den;
//        }
//
//        return new int[]{A[n], A[d]};
//
//    }
//
//    public static int count(Trie root, String s){
//
//        Trie head = root;
//        int count = 0;
//
//        for(int i = s.length()-1; i>=0; i--){
//            int num =Integer.parseInt(String.valueOf(s.charAt(i)));
//
//            if(num % 2 == 0){
//                if(head != null){
//                    head = head.even;
//                }else{
//                    break;
//                }
//            }else{
//                if(head != null){
//                    head = head.odd;
//                }else{
//                    break;
//                }
//            }
//        }
//
//
//        while(head != null){
//            if(head.isEnd){
//                count += head.count;
//            }
//            head = head.even;
//        }
//
//        return count;
//
//    }
//
//    public static void delete(Trie root, String s){
//        Trie head = root;
//        for(int i = s.length()-1; i>=0; i--){
//            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
//            if(num % 2 == 0){
//                head = head.even;
//            }else{
//                head = head.odd;
//            }
//        }
//
//        head.count = head.count - 1;
//        if(head.count == 0){
//            head.isEnd = false;
//        }
//
//    }
//
//    public static void insert(Trie root, String s){
//        Trie head = root;
//        for(int i = s.length()-1; i>=0; i--){
//            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
//
//            if(num % 2 == 0){
//                if(head.even == null){
//                    head.even = new Trie();
//                }
//                head = head.even;
//            }else{
//                if(head.odd == null){
//                    head.odd = new Trie();
//                }
//                head = head.odd;
//            }
//        }
//        head.count = head.count + 1;
//        head.isEnd = true;
//    }
//
//
//    public  static int Bsolve(int[] A) {
//
//
//        int count  = 0;
//        int min = A[0];
//
//        int p = 0, q = 0;
//
//        while(q < A.length){
//
//            if(p == q){
//                q++;
//            }
//            else{
//                if(q < A.length - 1 && A[q+1] > A[q] && A[q+1] < A[p]){
//                    q++;
//                }else{
//                    count += (q-p);
//                    p++;
//                }
//            }
//
//        }
//        return count;
//    }
//
//    public static int maxProduct(final int[] A) {
//
//        if(A.length == 1){
//            return A[0];
//        }
//
//        int[] dp_min = new int[A.length];
//        int[] dp_max = new int[A.length];
//        dp_min[0] = A[0];
//        dp_max[0] = A[0];
//        int ans = Integer.MIN_VALUE;
//        int i = 1;
//        for(i = 1; i<A.length; i++){
//            int min = dp_min[i-1] * A[i];
//            int max = dp_max[i-1] * A[i];
//            dp_min[i] = Math.min(A[i], Math.min(min, max));
//            dp_max[i] = Math.max(A[i], Math.max(min, max));
//        }
//
//        return dp_max[i-1];
//    }
//
//    public static int[] solve(int[] A, int[][] B) {
//
//        tree = new int[4 * A.length];
//        build(0, 0, A.length - 1, A);
//
//        int size = 0;
//        for (int i = 0; i < B.length; i++) {
//            if (B[i][0] == 1) {
//                size++;
//            }
//        }
//
//        int[] result = new int[size];
//        int index = 0;
//        for (int i = 0; i < B.length; i++) {
//
//            if (B[i][0] == 0) {
//                int k = B[i][1] - 1;
//                int val = B[i][2];
//                A[k] = val;
//                update(0, 0, A.length, k, val);
//            } else {
//                int l = B[i][1] - 1;
//                int r = B[i][2] - 1;
//                result[index++] = query(0, 0, A.length - 1, l, r);
//            }
//        }
//        return result;
//    }
//
//
//    //query segement tree
//    public static int query(int index, int start, int end, int left, int right) {
//        if (right < start || left > end) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (left <= start && right >= end) {
//            return tree[index];
//        }
//
//        int mid = (start + end) / 2;
//        int queryLeft = query(2 * index + 1, start, mid, left, right);
//        int queryRight = query(2 * index + 2, mid + 1, end, left, right);
//
//        return Math.min(queryLeft, queryRight);
//    }
//
//
//    // update segement tree
//    public static void update(int index, int start, int end, int i, int val) {
//        if (start == end) {
//            tree[index] = val;
//            return;
//        }
//        int mid = (start + end) / 2;
//        if (i <= mid) {
//            update(2 * index + 1, start, mid, i, val);
//        } else {
//            update(2 * index + 2, mid + 1, end, i, val);
//        }
//        tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
//    }
//
//    // build segement tree
//    public static void build(int index, int start, int end, int[] A) {
//        if (start == end) {
//            tree[index] = A[start];
//            return;
//        }
//        int mid = (start + end) / 2;
//        build(2 * index + 1, start, mid, A);
//        build(2 * index + 2, mid + 1, end, A);
//        tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
//    }
//
//
//}
//

import java.util.*;

class Check {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        for (int n = 0; n < Integer.parseInt(t); n++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            boolean ans = isFriend(a.length()-1, b.length()-1, a.trim(), b.trim());
            String p = ans ? "YES" : "NO";
            System.out.println(p);
        }

    }

    public static boolean isFriend(int i, int j, String a, String b){
        if(j < 0){
            return true;
        }
        if(i < 0){
            return false;
        }

        if(a.charAt(i) == b.charAt(j)){
            return isFriend(i-1, j-1, a, b);
        }else{
            return isFriend(i-1, j, a, b);
        }

    }
}
