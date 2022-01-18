package main.java.programs.sample;

public class SampleProgram {
    public static void main(String args[]){
        int     B = 4;
        int[]   A = new int[]{5, 3, 10, 12, 5, 14, 4, 7, 4};


        Sample1 sample = new Sample1();
        int ans = sample.solve(A, B);
        System.out.print(ans + " ");
    }
}


class Trie{
    int one;
    int zero;
    Trie left;
    Trie right;
    public Trie(){
        one = 0;
        zero = 0;
        left = null;
        right = null;
    }
}

class Sample1 {
    int MOD = 1000 * 1000 * 1000 + 7;
    int bits = 20;
    public int solve(int[] A, int B) {
        int xor = 0;
        Trie root = new Trie();
        add(root, 0);
        int sum = 0;
        for(int x : A){
            xor ^= x;
            sum = (sum + query(root, x, B)) % MOD;
            add(root, xor);
        }
        return sum;
    }

    public int query(Trie curr, int num, int k){
        int sum = 0;
        for(int i=bits; i>=0; i--){
            if(curr == null) return sum;
            int have = (num>>i)&1;
            int req = (k>>i)&1;
            if(req == 1){
                if(have == 1){
                    sum = (sum + curr.one) % MOD;
                    curr = curr.left;
                }else{
                    sum = (sum + curr.zero) % MOD;
                    curr = curr.right;
                }
            }else{
                if(have == 1){
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            }
        }
        return sum;
    }

    public void add(Trie curr, int num){
        for(int i = bits; i>=0; i--){
            int bit = (num>>i)&1;
            if(bit == 1){
                if(curr.right == null){
                    curr.right = new Trie();
                }
                curr.one += 1;
                curr = curr.right;
            }
            else{
                if(curr.left == null){
                    curr.left = new Trie();
                }
                curr.zero += 1;
                curr = curr.left;
            }
        }
    }
}

