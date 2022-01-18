package main.java.programs.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int x, y;

    Pair(int m, int n) {
        x = m;
        y = n;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }
}

class Sample {

    public static void main(String[] args) {
        Test t = new Test();
        int[][] A = new int[][]{
                {0, 0, 0, -1, 0},
                {-1, 0, -1, -1, -1},
                {0, 0, 0, -1, 0},
                {-1, 0, 0, 0, 0},
                {0, 0, -1, 0, 0}
        };
        //System.out.println(t.isPathExist(A));
        //List<Pair> list = new ArrayList<>();
        //t.printPaths(A, list, new Pair(0, 0));

        int[] B = new int[]{1, 2, 3};
        int[] C = new int[]{2, 2, 10};
        int[] D = new int[]{2, 3, 9};

        System.out.println(t.solve(B,C,D,8));
    }
}

class Test {
    int N, M;

    public int solve(int[] A, int[] B, int[] C, int D) {
        int N = A.length;
        int[] sweetness = new int[N];

        for(int i=0; i<N; i++){
            sweetness[i] = A[i] * B[i];
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=D; i++){
            for(int j=0; j<N; j++){
                if(C[j] <= i && i-C[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i-C[j]] + sweetness[j]);
                }
            }
        }

        return dp[N];
    }

    public void printPaths(int[][] A, List<Pair> path, Pair p) {
        path.add(p);
        if (p.x == A.length - 1 && p.y == A[0].length - 1) {
            System.out.println(path);
        } else {

            if (p.x + 1 < A.length && A[p.x + 1][p.y] == 0) {
                printPaths(A, path, new Pair(p.x + 1, p.y));
            }

            if (p.y + 1 < A[0].length && A[p.x][p.y + 1] == 0) {
                printPaths(A, path, new Pair(p.x, p.y + 1));
            }
        }
        path.remove(path.size() - 1);
    }


    public boolean isPathExist(int[][] A) {
        N = A.length;
        M = A[0].length;
        Boolean flag = false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                flag = true;
                break;
            }
            A[p.x][p.y] = -1;

// down
            if (isValid(A, p.x + 1, p.y)) {
                q.offer(new Pair(p.x + 1, p.y));
            }
// right
            if (isValid(A, p.x, p.y + 1)) {
                q.offer(new Pair(p.x, p.y + 1));
            }


        }
        return flag;
    }

    public boolean isValid(int[][] A, int x, int y) {
        return x < N && y < M && A[x][y] == 0;
    }

}
