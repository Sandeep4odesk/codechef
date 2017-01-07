package hackerearth;

import java.util.Scanner;

public class SolveEquations {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            int noOfWords = s.nextInt();
            StringBuffer sb = new StringBuffer();
            while (noOfWords-- > 0) {
                switch (s.next().trim()) {
                case "ZERO": {
                    sb.append("0");
                    break;
                }
                case "ONE": {
                    sb.append("1");
                    break;
                }
                case "TWO": {
                    sb.append("2");
                    break;
                }
                case "THREE": {
                    sb.append("3");
                    break;
                }
                case "FOUR": {
                    sb.append("4");
                    break;
                }
                case "FIVE": {
                    sb.append("5");
                    break;
                }
                case "SIX": {
                    sb.append("6");
                    break;
                }
                case "SEVEN": {
                    sb.append("7");
                    break;
                }
                case "EIGHT": {
                    sb.append("8");
                    break;
                }
                case "NINE": {
                    sb.append("9");
                    break;
                }
                case "PLUS": {
                    sb.append("+");
                    break;
                }
                case "MINUS": {
                    sb.append("-");
                    break;
                }
                }
            }
            System.out.println(getResult(sb));
        }
    }

    private static int getResult(StringBuffer sb) {
        Integer result = Integer.parseInt(sb.charAt(0) + "");
        for (int i = 2; i < sb.length(); i++) {
            if (i % 2 == 0) {
                if (sb.charAt(i - 1) == '+') {
                    result += Integer.parseInt(sb.charAt(i) + "");
                } else {
                    result -= Integer.parseInt(sb.charAt(i) + "");
                }
            }
        }
        return result;
    }
}
