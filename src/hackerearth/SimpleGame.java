package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleGame {

    public static void main(String[] st) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputRanksForPlayers = br.readLine().split(" ");
        int monkOneOptions = Integer.parseInt(inputRanksForPlayers[0]);
        int monkTwoOptions = Integer.parseInt(inputRanksForPlayers[1]);

        String[] inputForMonkOne = br.readLine().split(" ");
        int[] monkOneNumbers = new int[monkOneOptions];
        for (int i = 0; i < monkOneOptions; i++) {
            monkOneNumbers[i] = Integer.parseInt(inputForMonkOne[i]);
        }

        String[] inputForMonkTwo = br.readLine().split(" ");
        int[] monktwoNumbers = new int[monkTwoOptions];
        for (int i = 0; i < monkTwoOptions; i++) {
            monktwoNumbers[i] = Integer.parseInt(inputForMonkTwo[i]);
        }

        long monkOneScore = getScore(monkOneNumbers, monktwoNumbers);
        long monkTwoScore = getScore(monktwoNumbers, monkOneNumbers);
        if (monkOneScore > monkTwoScore) {
            System.out.println("Monk " + (monkOneScore - monkTwoScore));
        } else if (monkOneScore < monkTwoScore) {
            System.out.println("!Monk " + (monkTwoScore - monkOneScore));
        } else {
            System.out.println("Tie");
        }
    }

    private static long getScore(int[] arrayOne, int[] arrayTwo) {
        int[] f = new int[arrayOne.length];
        int[] g = new int[arrayOne.length];
        long sum = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            String[] result = countAllShortAndGreaterValues(arrayOne[i], arrayTwo).split("~");
            f[i] = Integer.parseInt(result[0]);
            g[i] = Integer.parseInt(result[1]);
            sum += (long) f[i] * g[i];
        }
        return sum;
    }

    private static String countAllShortAndGreaterValues(int num, int[] target) {
        int shorter = 0;
        int greater = 0;
        for (int targetNum : target) {
            if (num < targetNum) {
                shorter++;
            } else if (num > targetNum) {
                greater++;
            }
        }
        return "" + shorter + "~" + greater;
    }
}
