package hackerearth;

/*
 * Vivek bought a new phone but due to some defects its qwerty keypad has some keys at wrong position or some keys duplicated. Vivek says that he will not change the way of typing i.e. he does not cares whether key is correct or not (he just types blindly) . Now Vivek knows a magic but that magic can fix only 
k keys. Fixing a key just replaces that key. For example if there is a key f at position of key a then you simply rename f to a. This can also result in the same keys more than once in that keyboard. Now vivek has to type some 
N names . You have to guide him while using the magic so that total names that are erroneous are minimzed. 

Important Note : By default the configuration of the keyboard is given by qwertyuiopasdfghjklzxcvbnm 

Input 
First line contains a string of 26 characters as input. These 26 characters denote the arrangement of the keyboard of Vivek.
Next line contains N and K as input where N is the total number of words Vivek has to type and K total keys his magic can fix. Each of the next N lines contain a word. 
Total errors in the string will be less than or equal to 10 
Output
In output you have to print a number which denotes the maximum number of words that Vivek will be able to type without any error if he uses the magic
Constraints
1≤N≤105
1≤K≤10
1≤Sumoflengthsofallstrings≤106

SAMPLE INPUT 
qwertyuiopasdfghjklpxcvbnm
5 2
zoom
xeta
zeta 
die
mobius
SAMPLE OUTPUT 
5
Explanation
Since only one key z is erroneous and magic has ability to fix two keys. So we will fix the key z and so all the 5 words will be typed correctly
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewPhone {

    public static void main(String[] st) {
        Scanner sc = new Scanner(System.in);
        StringBuffer right = new StringBuffer();
        right.append("qwertyuiopasdfghjklzxcvbnm");
        StringBuffer faulty = new StringBuffer();
        faulty.append(sc.next());
        char[] differ = getDifference(right, faulty);
        int n = sc.nextInt();
        int magic = sc.nextInt();
        int validCount = 0;
        for (int i = 0; i < n; i++) {
            if (isValidWord(sc.next(), differ, magic)) {
                validCount++;
            }
        }
        System.out.println(validCount);
    }

    private static char[] getDifference(StringBuffer right, StringBuffer faulty) {
        List<Character> lst = new ArrayList<Character>();
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) != faulty.charAt(i)) {
                lst.add(right.charAt(i));
            }
        }
        char[] arr = new char[lst.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }
        return arr;
    }

    private static boolean isValidWord(String st, char[] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (st.indexOf(arr[i]) != -1) {
                count++;
            }
        }
        return key >= count;
    }
}
