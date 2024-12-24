package Array.gold.simulation;

import java.util.Scanner;

public class 회문인_수_11068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int M = sc.nextInt();
            if (isRotateNum(String.valueOf(M))) {
                System.out.println(1);
            } else if (isRotateNumUsingDigit(M)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean isRotateNumUsingDigit(int m) {
        for (int i = 2; i <= 64; i++) {
            String result = convertTo(m, i);
            if (isRotateNum(result)) {
                return true;
            }
        }
        return false;
    }

    private static String convertTo(int m, int i) {
        StringBuilder sb = new StringBuilder();
        while (m > 0) {
            int digit = m % i; //255 -> 15 // 15-> 15
            if (digit >= 10) {
                int pos = digit-10;
                sb.append((char) ('A' + pos)); // 'A'+5 -> F // 'A' + 5 -> F
            } else {
                sb.append(digit);
            }
            m /= i; // 15 //0
        }
        return sb.reverse().toString();
    }

    private static boolean isRotateNum(String m) {
        StringBuilder target = new StringBuilder(m);
        return m.equals(target.reverse().toString());
    }

}
