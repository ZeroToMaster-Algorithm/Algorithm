package Array.gold.simulation;

import java.util.Scanner;

public class ACM_호텔_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int request = sc.nextInt();

            int XX = ((request-1)/H)+1;
            int YY = ((request-1)%H)+1;

            System.out.printf("%d%02d",YY,XX);
        }
    }
}
