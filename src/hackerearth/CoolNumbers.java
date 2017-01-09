package hackerearth;

import java.util.Scanner;

/*
 * Cool numbers
Today Oz is busy with cool numbers. Cool numbers are positive integers whose decimal representation contains only the cool digits 2 and 5. For example, numbers 25, 522, 2 are cool and 7, 15, 265 are not.
Let f(k) be the smallest cool number greater than or equals k. Oz is interested what is the value of the following expression for a given pair (l,r) :
enter image description here

Input :
The first line of input contains an integer T - number of test cases. Each test case consist of two integers l and r.

Output :
For each test case output required answer.

Constraint : 
1 = T = 50
1 = l = r = 109

Sample Input
1
3 7
Sample Output
59
 * */
public class CoolNumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            long start = s.nextInt();
            long end = s.nextInt();
            long sum = 0;
            StringBuffer sb = new StringBuffer();
            sb.append("2");
            for (long i = start; i <= end; i++) {
                sum += getCoolNumber(i, sb);
            }
            System.out.println(sum);
        }
    }

    private static long getCoolNumber(long num, StringBuffer sb) {
        long n = 0;
        while (n < num) {
            n = Long.parseLong(sb.toString());
            sb = new StringBuffer(getString(sb));
        }
        return n;
    }

    private static StringBuffer getString(StringBuffer sb) {
        if (sb.lastIndexOf("2") != -1) {
            char[] c = new char[sb.length()];
            boolean converted = false;
            for (int i = sb.length() - 1; i > -1; i--) {
                if (sb.charAt(i) == '2' && !converted) {
                    c[i] = '5';
                    converted = true;
                } else {
                    c[i] = '2';
                }
            }
            sb = new StringBuffer();
            sb.append(c);
        } else {
            char[] c = new char[sb.length() + 1];
            for (int i = 0; i < c.length; i++) {
                c[i] = '2';
            }
            sb = new StringBuffer();
            sb.append(c);
        }
        return sb;
    }
}
