package hackerearth;

/*
 * Its new year time so is the time for celebration. Mathematician Ronald discovered some numbers following a property and he calls them new numbers. A new number is a number such that all the permutations of that number are greater (old) than that lexicographically . For example 12 is a new number as there is only one another permutation 21 which is greater than that. Some other new numbers are 19 , 157 . Given a 
N as input , you have to count total new natural numbers not greater than N.

Constraints
1≤N≤10^18 
Input
First line contains N as input. 
Output
Print count of total numbers satisfying the given property

SAMPLE INPUT 
15
SAMPLE OUTPUT 
14
Explanation
Except 10 all numbers which are less than or equal to 15 satisfy the given property
 * */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class NewNumbers {

    public static void main(String[] st) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long[] array = LongStream.range(1, n + 1).toArray();
        System.out.println(Arrays.stream(array).parallel().filter(l -> inreasingOrder(l)).count());
    }

    private static boolean inreasingOrder(long l) {
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        sb.append(l);
        if (sb.length() > 1) {
            for (int i = 1; i < sb.length(); i++) {
                if (compareTwoValues(Integer.parseInt(sb.charAt(i - 1) + ""), Integer.parseInt(sb.charAt(i) + ""))) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean compareTwoValues(int a, int b) {
        return a <= b;
    }
}
