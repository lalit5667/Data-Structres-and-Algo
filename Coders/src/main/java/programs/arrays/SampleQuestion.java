package main.java.programs.arrays;

public class SampleQuestion {


//    String sentence = "your name is Lalit kumar. And Lalit kumar works as IT profession, in ChainThat Limited.”
//
//    o/p: your- 1
//    Lalit - 2
//    kumar 2
//    etc
//
//            [][]

    public static void main(String[] args){
        String s  = "abc abc def def";
        wordCount(s);
    }

    public static void wordCount(String s){

        String word[] =  s.split(" ");
        int[] count = new int[word.length];

        for(int i=0; i<word.length; i++){
            String temp =  word[i];
            if(count[i] != -1){
                int ans = 0;
                for(int j = i; j < word.length; j++){
                    if(temp.equals(word[j])){
                        ans += 1;
                        count[j] = -1;
                    }
                }
                count[i] = ans;
            }
        }

        for(int i= 0; i< word.length; i++){
            if(count[i] != -1){
                System.out.println(word[i] + " " + count[i]);
            }
        }
    }

    public static String clean(String s){
        return s;
    }
}
