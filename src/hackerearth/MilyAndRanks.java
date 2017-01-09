package hackerearth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
 * Milly and ranks
Milly is shocked after seeing her result as some of the students were given same ranks. So she started predicting ranks of her classmates. She is more interested in giving distinct ranks to all of the students. She can increase any rank by a factor of 1 any number of times. But this single operation requires 1 unit amount of thinking at a time. You are required to help her in giving distinct ranks to all of the students with utilizing minimum amount of thinking.

Input

First line of the input will contain T denoting the number of test cases.
For every test case, first line will contain N (No. of students). Next line will contain N space separated integers denoting Ri, rank of ith student.
Output

For every test case, print minimum thinking utilized in a new line.
Constraints

1 = T = 10
1 = N = 105
1 = Ri = N
Sample Input
2
2
1 1
3
1 1 2
Sample Output
1
2
Explanation
Test case #1 : She can increase any of the one rank by 1.
Test case #2 : She can increase the rank of the first student by two times.
 * */

public class MilyAndRanks {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            int noOfSt = s.nextInt();
            int[] marks = new int[noOfSt];
            Queue<Integer> duplicates = new LinkedList<Integer>();
            Set<Integer> set = new HashSet<Integer>();
            int counter = 0;
            for (int i = 0; i < noOfSt; i++) {
                marks[i] = s.nextInt();
            }
            getDuplicates(marks, set, duplicates);
            while (!duplicates.isEmpty()) {
                int i = duplicates.remove();
                counter += insertRank(i, set);
            }
            System.out.println(counter);
        }
    }

    private static int insertRank(int i, Set<Integer> set) {
        int counter = 0;
        while (set.contains(i)) {
            i++;
            counter++;
        }
        set.add(i);
        return counter;
    }

    private static void getDuplicates(int[] marks, Set<Integer> set, Queue<Integer> duplicates) {
        for (int i = 0; i < marks.length; i++) {
            if (!set.add(marks[i])) {
                duplicates.add(marks[i]);
            }
        }
    }
}
