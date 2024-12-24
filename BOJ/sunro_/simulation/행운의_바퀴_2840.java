package Array.gold.simulation;

import java.util.Scanner;

public class 행운의_바퀴_2840 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[] wheel = new char[N];
        int curPoint = 0;
        for (int i = 0; i < wheel.length; i++) {
            wheel[i] = '?';
        }
        while(M-->0){
            int move = sc.nextInt();
            char nextAlphabet = sc.next().charAt(0);
            int nextPoint = ((curPoint-move)%N+N)%N;
            if (wheel[nextPoint] == '?') wheel[nextPoint] = nextAlphabet;
            else if (wheel[nextPoint] != nextAlphabet) {
                System.out.println("!");
                return;
            }
            curPoint = nextPoint;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < N; i++) {
            if(wheel[i]=='?') continue;
            if(visited[wheel[i] - 'A']) {
                System.out.println("!");
                return ;
            }
            visited[wheel[i] - 'A'] = true;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(curPoint+i)%N]);
        }
    }
}
