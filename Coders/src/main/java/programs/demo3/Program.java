package main.java.programs.demo3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Lalit Kumar
// lmr

import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.

    public static void main(String[] args){
//        int[] red = new int[]{1, 2, 3, 4, 5};
//        int[] blue = new int[]{5, 4, 3, 2, 1};
//
//        System.out.println(tandemBicycle(red, blue, true));
        SuffixTrie suffixTrie = new SuffixTrie("abc");

    }


    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            int N = str.length();

            for(int i=0; i<N; i++){
                TrieNode node = root;
                for(int j=i; j<N; j++){
                    char ch = str.charAt(j);
                    if(!root.children.containsKey(ch)){
                        TrieNode newNode = new TrieNode();
                        node.children.put(ch, newNode);
                    }
                    node = node.children.get(ch);
                }
                node.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            // Write your code here.
            TrieNode node = root;
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(!node.children.containsKey(ch)){
                    return false;
                }
                node = node.children.get(ch);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}



//public class Program {
//
//    public static void main(String[] args){
//        int[] red = new int[]{1, 2, 3, 4, 5};
//        int[] blue = new int[]{5, 4, 3, 2, 1};
//
//        System.out.println(tandemBicycle(red, blue, true));
//    }
//
//
//    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
//        // Write your code here.
//        int ans = 0;
//        Arrays.sort(redShirtSpeeds);
//        Arrays.sort(blueShirtSpeeds);
//
//
//        for(int i=0; i<blueShirtSpeeds.length; i++){
//            ans += Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
//        }
//        return ans;
//    }
//
//
//    public static boolean checkString(String one, String order){
//
//        if(one == null || order==null || one.length() < order.length()){
//            return false;
//        }
//
//        one = one.toLowerCase();
//        order = order.toLowerCase();
//        int p=0, q=0;
//
//        while(p < one.length() && q < order.length()){
//            if(one.charAt(p) == order.charAt(q)){
//                q += 1;
//            }
//            p += 1;
//        }
//        return q == order.length();
//    }
//
//
//    public static String getLargestNumber(List<Integer> list){
//        Collections.sort(list, (x, y)-> {
//            String a = String.valueOf(x);
//            String b = String.valueOf(y);
//            if(a.length() == b.length()){
//                return  y.compareTo(x);
//            }
//            else{
//                int p = 0, q=0;
//                while(p < a.length() && q < b.length()){
//                    if(a.charAt(p) == b.charAt(q)){
//                        p ++;
//                        q ++;
//                    }
//                    else{
//                        return b.charAt(q) - a.charAt(p);
//                    }
//                }
//                return a.length() - b.length();
//            }
//        });
//        String ans = "";
//        for(int x: list){
//            ans += String.valueOf(x);
//        }
//        return ans;
//    }
//}


/**
 *
 *  There is a contact list ->  Name - Number
 *  Contract list is at multiple sources - phone, laptop, etc
 *
 *  HashMap <K, V>
 *
 *  TreeMap<String, HashSet<String>>
 *          Name -> Set of contacts
 *
 *          1,2,3,9,8,7  -> 987321
 *          23,34,56    -> 563423  56 34 23
 *          10, 8, 45 311 -> 94531110
 *          80, 7, 45 311  ->
 *          9,23,34  -> 93423  -> 9 34 23
 *
 *          88, 8812  ->
 */
