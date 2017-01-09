package hackerearth;

import java.util.Scanner;

/*
 * Distinct Powers.
Aayush has just arrived home after his Maths Class.Today he learnt a very special thing that every number could be represented as a sum of distinct powers of 2.He was amazed when he came to know about this.

Example:

6 - > 4 + 2

11 -> 8 + 2 + 1

On his way he back home he kept testing this given property.While testing he realized that this special summation is unique for every number but it may be a subset of many other numbers.

Example :

3 -> 2+1 Thus 2+ 1 is unique for 3 but this pattern is a subset for 7 as 7 -> 4 + 2 + 1 , 11 -> 8 + 2 + 1 etc.

Since he got baffled after coming to this conclusion he asks you for help.

Given a numbers A you need to output the smallest number such that the special summation of A is subset of the special summation for that number.

Input:

The first line contains T denoting the number of test cases.

Then T lines follow each containing 1 integer A.

Output:

Print the smallest number which satisfy the above condition.

Constraints:

1 <= T <= 10000

1<= A <= 10^9

Sample Input
2
3
9

Sample Output
7
11
Explanation
Test Case #2:

9 -> 8 + 1

11 -> 8 + 2 + 1

Thus the special summation of 9 that is 8 +1 is also present in 11 as 8 + 2+ 1.
 * */

public class DistinctPowers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            boolean isConverted = false;
            String str = Long.toBinaryString(s.nextLong());
            char[] c = new char[str.length()];
            for (int i = str.length() - 1; i > -1; i--) {
                if (str.charAt(i) == '0' && !isConverted) {
                    c[i] = '1';
                    isConverted = true;
                } else {
                    c[i] = str.charAt(i);
                }
            }
            str = new String(c);
            if (!isConverted) {
                str = "1" + str;
            }
            System.out.println(Long.parseLong(str, 2));
        }
    }

}
