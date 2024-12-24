package Array.gold.array;

import java.util.Scanner;

public class 성_지키기_1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int[] checkXLine = new int[N];
        int[] checkYLine = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 'X'){
                    checkXLine[i]++;
                    checkYLine[j]++;
                }
            }
        }
        int xLineCount=0;
        int yLineCount=0;

        for(int x : checkXLine){
            if(x==0) xLineCount++;
        }
        for(int y : checkYLine){
            if(y==0) yLineCount++;
        }
        System.out.println(Math.max(xLineCount,yLineCount));
    }
}
