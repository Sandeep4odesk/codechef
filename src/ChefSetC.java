import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/*
 * Problem Statement
 * 
 * Chef likes problems which using some math. Now he asks you to solve next one. You have 4 integers, Chef wondering is there non-empty subset which has sum equals 0.

Input

The first line of input contains T - number of test cases.

Each of the next T lines containing four pairwise distinct integer numbers - a, b, c, d.

Output

For each test case output "Yes", if possible to get 0 by choosing non-empty subset of {a, b, c, d} with sum equal 0, or "No" in another case.

Constraints

1 ≤ T ≤ 103
-106 ≤ a, b, c, d ≤ 106
Example

Input:
3
1 2 0 3
1 2 4 -1
1 2 3 4

Output:
Yes
Yes
No
Explanation

Example case 1. We can choose subset {0}

Example case 2. We can choose subset {-1, 1}
 * */

public class ChefSetC {

    public static void main(String[] st) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfTestCases = Integer.parseInt(br.readLine());
        while (noOfTestCases-- > 0) {
            int[] inputElements = convertStringToInt(br.readLine());
            boolean isZero = Arrays.stream(inputElements).filter(el -> el == 0).findAny().isPresent();
            if (isZero) {
                System.out.println("Yes");
            } else {
                boolean isNegativePresent = Arrays.stream(inputElements).filter(el -> el < 0).findAny().isPresent();
                if (isNegativePresent) {
                    if (isSumOfSubSetZero(inputElements)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static int[] convertStringToInt(String string) {
        return Pattern.compile(" ").splitAsStream(string).mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isSumOfSubSetZero(int set[]) {
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    sum += set[j];
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }
}
