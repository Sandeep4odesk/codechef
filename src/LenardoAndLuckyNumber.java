import java.util.Scanner;

public class LenardoAndLuckyNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextLong();
            if (c[i] % 7 == 0 || c[i] % 4 == 0) {
                System.out.println("Yes");
            } else {
                checkIfSumOf4or7(c[i]);
            }
        }

    }

    private static void checkIfSumOf4or7(long num) {
        long rem = num % 7;
        if(rem % 4 == 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
