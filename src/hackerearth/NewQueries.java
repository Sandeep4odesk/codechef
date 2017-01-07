package hackerearth;

/*
 * 
 * You have an array 
A consisting of N integers and is 1 based index. You have to perform q queries on the given array. Queries can be of 3 types.
1iX : Update the array value at ith position to X i.e. set A[i]=X
2LR : Among all the even numbers from position L to R find the largest even number
3LR : Among all the odd numbers from position L to R find the largest odd number

Constraints
1≤N≤105
1≤L≤R≤N
1≤i≤N
0≤X≤1018
1≤Q≤105

Input
First line contains N and Q as input.
Next line contains N space separated integers denoting A[i].
Next Q lines contain Q queries of any of the three above types 
Output
Print result of each query of type 2 and 3 in a new line

SAMPLE INPUT 
5 5
1 2 3 4 5
2 1 5
2 1 3
3 1 4
3 2 2
3 1 5
SAMPLE OUTPUT 
4
2
3
DNE
5
 * */

import java.util.Arrays;
import java.util.Scanner;

public class NewQueries {

    public static void main(String[] st) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        while (q-- > 0) {
            int qType = s.nextInt();
            int p = s.nextInt();
            int v = s.nextInt();
            if (qType == 1) {
                forQueryOne(arr, p, v);
            } else if (qType == 2) {
                forQueryTwo(arr, p, v);
            } else if (qType == 3){
                forQueryThree(arr, p, v);
            }
        }
    }

    private static void forQueryThree(int[] arr, int start, int end) {
        int[] arrNew = new int[end - start + 1];
        int k = 0;
        for (int i = start - 1; i < end; i++) {
            arrNew[k++] = arr[i];
        }
        int[] evenArr = Arrays.stream(arrNew).parallel().filter(el -> el % 2 != 0).toArray();
        if (evenArr.length > 0) {
            System.out.println(Arrays.stream(evenArr).parallel().max().getAsInt());
        } else {
            System.out.println("DNE");
        }
    }

    private static void forQueryTwo(int[] arr, int start, int end) {
        int[] arrNew = new int[end - start + 1];
        int k = 0;
        for (int i = start - 1; i < end; i++) {
            arrNew[k++] = arr[i];
        }
        int[] evenArr = Arrays.stream(arrNew).parallel().filter(el -> el % 2 == 0).toArray();
        if (evenArr.length > 0) {
            System.out.println(Arrays.stream(evenArr).parallel().max().getAsInt());
        } else {
            System.out.println("DNE");
        }
    }

    private static void forQueryOne(int[] arr, int pos, int value) {
        arr[pos - 1] = value;
    }
}
