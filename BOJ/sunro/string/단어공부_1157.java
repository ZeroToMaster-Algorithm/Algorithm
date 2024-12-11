package Array.gold.string;

import java.util.Scanner;

public class 단어공부_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toLowerCase().toCharArray();
        int[] alphArr = new int[26];



        for (char x : charArr) {
            if (x >= 'a' && x <= 'z') {
                alphArr[x - 'a']++;
            }
        }
        int max = -1;
        int maxIndex = -1;
        char answer='?';

        for (int i = 0; i < 26; i++) {
            if (alphArr[i] > max) {
                max = alphArr[i];
                maxIndex = i;
                answer=(char)(maxIndex+'A');
            }else if (alphArr[i] == max){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}

