package hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * String Queries
Given a 1-indexed String S of length N, consisting of lowercase English alphabets, you need to answer queries based on the properties of this string.
You shall be given Q queries to answer. In each query you shall be given 2 integers L and R. Now , you need to report the minimum number of String elements you need to delete in the substring of String S ranging from L to R inclusive, so that each distinct character occurring in the range occurs equal number of times.

For example, consider the String "abcdab" . Here, the characters occurring in this String are 'a','b', 'c' and 'd'. On deleting one occurrence of 
'a' as well as 'b' one of the possible Strings is abcd. Each character occuring in the range now occurs equal number of times. So, the minimum number of deletions is two.

Note that we need to equalize the count of only characters that occur in the range, and not of characters that do not. It is allowed to delete all occurences of a character, so that it no longer occurs in the range at all

Can you do it ?

Input Format :

The first line contains 
2 space separated integers N and Q. The next line contains the String S. Each of the next Q lines contains 2 space separated integers L and R, denoting the parameters of the ith query.

Output Format :
Print the answer to each query on a new line.
Constraints :
1=N,Q=105
1=L=R=N

Sample Input
8 2
abcdabcd
1 6
2 7
Sample Output
2
2
 * */
public class StringQueries {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int n = s.nextInt();
        String str = s.next();
        while (n-- > 0) {
            int start = s.nextInt();
            int end = s.nextInt();
            String newStr = str.substring(start - 1, end);
            int count = 0;
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < newStr.length(); i++) {
                if (!set.add(str.charAt(i))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
