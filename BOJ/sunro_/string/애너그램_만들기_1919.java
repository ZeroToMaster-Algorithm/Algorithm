package Array.gold.string;

import java.util.Arrays;
import java.util.Scanner;

public class 애너그램_만들기_1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine().toLowerCase();
        String word2 = sc.nextLine().toLowerCase();
        int[] alphArr = new int[26];
        int[] alphArr2 = new int[26];

        for (char x : word1.toCharArray()) {
            System.out.println(x-'a');
            alphArr[x-'a']++;
        }
        for (char x : word2.toCharArray()) {
            alphArr2[x-'a']++;
        }
        System.out.println(Arrays.toString(alphArr));
        System.out.println(Arrays.toString(alphArr2));

        int cnt =0;
        for (int i = 0; i < alphArr.length; i++) {
            if(alphArr[i] != alphArr2[i]){
                cnt += Math.abs(alphArr[i]-alphArr2[i]);
            }
        }
        System.out.println(cnt);

    }
}
