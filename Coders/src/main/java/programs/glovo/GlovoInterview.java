package main.java.programs.glovo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Write an algorithm that returns the first non-repeated character in a string. For example:

1. firstNonRepeatedCharacter("ABCA") returns B
2. firstNonRepeatedCharacter("BCABAC") returns null
3. firstNonRepeatedCharacter("BAC") returns B
4. firstNonRepeatedCharacter("GlovoOnGlovo") returns O
5. firstNonRepeatedCharacter("What is the first non-repeated character?") returns W
 */

/*
Write an algorithm that given a string containing any combination of the characters
'(', ')', '{', '}', '[' and ']', determines if the input string is valid.

An input string is valid when:

- Opening parentheses are closed by the same type of closing parentheses, and
- Opening parentheses are closed in the correct order.

No other characters are present in the string except those mentioned above.

Examples:

1. "()" -> true
2. "()[]{}" -> true
3. "(]" -> false
4. ")(" -> false
5. "([)]" -> false
6. "{[]}" -> true
7. ")" -> false
8. "([]" -> false
9. "{" -> false
10. "([)])" -> false
11. "(((((((((())))))))))" -> true
12. "" -> true

Note that an empty string is also considered valid.
 */

/*
Given an array of integers e, arrange the elements in it so that:

e[0] ≤ e[1] ≥ e[2] ≤ e[3] ≥ e[4] ...

The elements in e need not be unique (they may be repeated)

For example:
(1 2 5 7 8 9)
5 2 1 7 9 8 ->  1 ≤ 7 ≥ 5 ≤ 9 ≥ 2 ≤ 8  or  2 ≤ 5 ≥ 1 ≤ 9 ≥ 7 ≤ 8 or ...  1 5 2 8 7 9

1 2 3 4 5 6 ->  1 ≤ 3 ≥ 2 ≤ 5 ≥ 4 ≤ 6  or ...  1  4  2  5  3  6 or 1 3 2 5 4 6

-2 3 3 -3   ->  3 ≤ 3 ≥ -3 ≤ -2  or  -2 ≤ 3 ≥ -3 ≤ 3 or ...  -2 3 -3 3

1 3 5 2 4 ->  1 5 2 4 3

 */

public class GlovoInterview {

    public static void main(String[] args){
        int[] A = new int[]{5, 2 ,1, 7, 9, 8};
        rearrangeArray(A);
        for(int v : A){
            System.out.print(v + " ");
        }
        System.out.println();

        int[] B = new int[]{1, 2, 3, 4, 5, 6};
        rearrangeArray(B);
        for(int v : B){
            System.out.print(v + " ");
        }
        System.out.println();

        int[] C = new int[]{-2, 3, 3, -3};
        rearrangeArray(C);
        for(int v : C){
            System.out.print(v + " ");
        }
        System.out.println();

        int[] D = new int[]{1, 3, 5, 2, 4};
        rearrangeArray(D);
        for(int v : D){
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void rearrangeArray(int[] A){
        if(A == null || A.length == 0){
            return;
        }
        Arrays.sort(A);
        for(int i = 1; i<A.length-1; i+=2 ){
            int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
        }
    }

    public static boolean isBalancedString(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        if(s.length() % 2 != 0 ){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                char top = stack.isEmpty() ? '#' : stack.peek();
                if( !stack.isEmpty() && (top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static Character getFirstNonRepeatedCharacter(String s){
        if(s == null){
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch: s.toCharArray()){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return null;
    }
}
