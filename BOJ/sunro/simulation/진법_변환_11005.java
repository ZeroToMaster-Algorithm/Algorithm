package Array.gold.simulation;

import java.util.Scanner;

public class 진법_변환_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String answer = "";
        while(N>0){
            int D = N%M;
            //나머지 N이 M보다 크면 그대로 저장
            if(D<10){
                answer += D;
            }//그게 아닌경우에는 알파벳으로 저장
            else{
                answer += (char)('A'+D-10);
            }
            N/=M;
        }
        System.out.println(new StringBuilder(answer).reverse());
    }
}
