package Array.gold;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class 가장긴증가하는부분수열2_12015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = A[i];

            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int pos = Collections.binarySearch(lis, num);
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                lis.set(pos, num);
            }
        }

        System.out.println(lis.size());

        sc.close();
    }
}
