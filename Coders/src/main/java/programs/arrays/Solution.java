package main.java.programs.arrays;

import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<String> result = new ArrayList<>();
        for(int i=0; i<T; i++){
            String S = scanner.next();
            int M = scanner.nextInt();
            List<Pairs> list = new ArrayList<>();
            for(int j=0; j<M; j++){
                String to = scanner.next();
                String from = scanner.next();
                //System.out.println(to.length() + " " + to);
                list.add(new Pairs(to.charAt(0), from.charAt(0)));
            }
            result.add(isFlexible(S, list));
        }

        System.out.println(result);

    }

    public static String isFlexible(String s, List<Pairs> list){
        Collections.sort(list);

        for(Pairs p: list){
            s = s.replace(p.from, p.to);
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                return "NO";
            }
        }
        return "YES";
    }
}

class Pairs implements Comparable<Pairs>{
    char from;
    char to;
    public Pairs(char f, char t){
        from  = f;
        to = t;
    }

    @Override
    public int compareTo(Pairs o){
        if(this.to <= o.from){
            return -1;
        }
        return 1;
    }
}
