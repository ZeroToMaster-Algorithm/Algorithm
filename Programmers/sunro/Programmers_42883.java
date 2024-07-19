package greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 인덱스중 가장 큰 첫뻔째 인덱스 앞의 요소들 삭제
 * 2. 그  뒤는 앞에서부터 가장 작은 숫자를 하나씩 삭제
 */

public class Programmers_42883 {
    static String number;
    static int k;
    static String answer = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        number = sc.nextLine();
        k = sc.nextInt();

        char[] charArray = number.toCharArray();

        int len= charArray.length-k;

        int start=0;

        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i+k; j++) {
                if (charArray[j] > max) {
                    max = charArray[j];
                    start = j+1;
                }
            }
            answer += max;
            }
        System.out.println(answer);
        }


    }
