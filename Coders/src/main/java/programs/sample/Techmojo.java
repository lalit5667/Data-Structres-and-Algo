//package main.java.programs;
//
///**
// * Arry1 --> {1, 7,  9 , 5} -> m lenght
// * Arry2 --> {     1 9  6} -> n lenght
// * <p>
// * <p>
// * 1 7 9 5
// * 1 9 6
// * <p>
// * counter = 100
// * sum = 991
// * digitSUm = 18 + 1 = 9
// * carry = 0
// * <p>
// * 9 4 6 8
// * 9 5 6
// * 10 4 2 4
// * <p>
// * COUNTER = MULTIPLES OF 10 -> 1
// * Sum -> 1 9 9 1
// */
//
//class Techmojo{
//    public static void main(String args[]){
//        int[] A = new int[]{9, 9, 9};
//        int[] B = new int[]{1};
//        AddTwoArrays a = new AddTwoArrays();
//        System.out.println(a.sumOfArrays(A, B));
//
//        int x = 9;
//        if (x == 9)
//        {
//            int x = 8;
//            System.out.println(x);
//        }
//    }
//}
//
//
//class AddTwoArrays {
//    int counter, carry;
//
//    public int sumOfArrays(int[] A, int[] B) {
//        counter = 1;
//        carry = 0;
//
//        int sum = 0;
//        int p = A.length - 1, q = B.length - 1;
//
//        while (p >= 0 && q >= 0) {
//            sum += addNumber(A[p] + B[q] + carry);
//            p--;
//            q--;
//        }
//
//        while (p >= 0) {
//            sum += addNumber(A[p] + carry);
//            p--;
//        }
//
//        while (q >= 0) {
//            sum += addNumber(B[q] + carry);
//            q--;
//        }
//
//        if (carry == 1) {
//            sum += addNumber(carry);
//        }
//
//        return sum;
//    }
//
//    private int addNumber(int digitSum) {
//        if (digitSum > 9) {
//            carry = 1;
//            digitSum -= 10;
//        } else {
//            carry = 0;
//        }
//        int ans = (digitSum * counter);
//        counter *= 10;
//        return ans;
//    }
//
//}
