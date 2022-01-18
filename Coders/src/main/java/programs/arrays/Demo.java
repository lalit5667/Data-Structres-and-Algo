package main.java.programs.arrays;

import java.util.*;

class Pair{
    public int x;
    public int y;
    public Pair(int p, int q){
        x = p;
        y = q;
    }
}




public class Demo {

    public static void main(String args[]){
        int     A = 10;
        int[]   B = new int[]{7, 9, 3, 2, 9, 1, 6, 4, 10, 8};
        int[][] C = new int[][]{{1, 5}, {2, 6}, {3, 7}, {3, 9}, {3, 10}, {4, 5}, {4, 7}, {4, 10}, {5, 7}, {5, 9}};
        int     D = 26;
        System.out.println(solve(A, B, C, D));
    }

    public static int solve(int A, int[] B, int[][] C, int D) {

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[A+1];

        for(int i=0; i<=A; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<C.length; i++){
            adj.get(C[i][0]).add(C[i][1]);
            adj.get(C[i][1]).add(C[i][0]);
        }

        int count = 0;
        for(int i=1; i<=A; i++){
            if(!vis[i]){
                int curr = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;

                while(!q.isEmpty()){
                    int temp = q.poll();
                    curr += B[temp-1];
                    for(int k : adj.get(temp)){
                        if(!vis[k]){
                            q.offer(temp);
                            vis[k] = true;
                        }
                    }
                }

                if(curr >= D){
                    count +=1;
                }
            }
        }

        return count;
    }

}
