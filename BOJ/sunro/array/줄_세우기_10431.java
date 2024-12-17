package Array.gold.array;

import java.util.LinkedList;
import java.util.Scanner;

public class 줄_세우기_10431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int idx=1;
        while (N-- > 0) {
            int[] arr = new int[20];
            sc.nextInt();
            for (int i = 0; i < 20; i++) {
                arr[i]=sc.nextInt();
            }
            int result = sortAndCount(arr);
            System.out.println(idx+" "+result);
            idx++;
        }
    }

    private static int sortAndCount(int[] arr) {
        int count =0;
        for (int i = 0; i < 20; i++) {
            for (int j = i+1; j < 20; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                    swap(arr,i,j);
                }
            }
        }
        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
