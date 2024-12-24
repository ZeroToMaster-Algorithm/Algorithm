package Array.gold;
/*
 1. 야구 게임에 사용할 수 있는 모든 수 저장
 2. 스코어 셋 클래스와 각 수를 비교해서 일치하는 숫자를 카운트
 */

import java.util.ArrayList;
import java.util.Scanner;

public class 숫자야구_2503 {
    static int N;

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ArrayList<scoreSet> list = new ArrayList<>();

        int target;
        int strike;
        int ball;
        int answer =0;
        for (int i = 0; i < N; i++) {
            target = sc.nextInt();
            strike = sc.nextInt();
            ball = sc.nextInt();
            list.add(new scoreSet(target, strike, ball));
        }

        boolean[] arr = new boolean[999];
        for (int i = 123; i <987 ; i++) {
            String str = Integer.toString(i);

            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2) || str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                arr[i] = false;
            }
            else{
                arr[i] = true;
            }
        }

        for (int i = 123; i < 987; i++) {
            if (arr[i]) {
                //모든 카운트 테스트를 통과하는 경우 계속 true
                for (int j = 0; j < N; j++) {
                    int strikeCnt = list.get(j).checkStrike(i);
                    int ballCnt = list.get(j).checkBall(i);
                    if (strikeCnt == list.get(j).strike && ballCnt == list.get(j).ball) {
                        continue;
                    } else {
                        arr[i] = false;
                    }
                }

            }
        }

        for (int i = 123; i < 987; i++) {
            if(arr[i]) answer++;
        }

        System.out.println(answer);
    }


}

 class scoreSet {
    int num;
    int strike;
    int ball;

    scoreSet(int num,int  strike,int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }

     int checkStrike(int target) {
         String compNum = Integer.toString(target);
         String Num = Integer.toString(this.num);
         int cnt = 0;

         for (int i = 0; i < 3; i++) {
             if(compNum.charAt(i) == Num.charAt(i)) cnt++;
         }
         return  cnt;
     }

     int checkBall(int target) {
         String compNum = Integer.toString(target);
         String num = Integer.toString(this.num);
         int cnt=0;
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if ((compNum.charAt(i) == num.charAt(j)) && i != j) {
                     cnt++;
                 }
             }
         }
            return cnt;
     }



}//class scoreSet
