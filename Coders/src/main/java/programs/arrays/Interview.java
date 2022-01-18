package main.java.programs.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Interview {
    public static void main(String args[]){
        System.out.println(alien("cba", "dabcabd"));
    }


    public static String alien(String alienDir, String input){
        Character[] word = new Character[input.length()];
        for(int i=0; i<input.length(); i++){
            word[i] = input.charAt(i);
        }

        int[] p = new int[26];
        Arrays.fill(p, 26);

        for(int i=0; i<alienDir.length(); i++){
            char ch = alienDir.charAt(i);
            p[ch-'a'] = i;
        }

        Arrays.sort(word, Comparator.comparingInt(o -> p[o - 'a']));
        StringBuilder sb = new StringBuilder();
        for(char ch: word){
            sb.append(ch);
        }
        return sb.toString();
    }
}
