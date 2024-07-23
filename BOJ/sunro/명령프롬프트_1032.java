package Simulation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *  패턴에는 알파벳 . 그리고 ? 만 넣을수 있음
 *  최소한의 ?를 쓸것
 *  파일 이름 길이는 모두 동일
 *  .뒤에는 확장자
 *
 */
public class Programmers_1032 {
    static int N;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String target = br.readLine();
            list.add(target);
        }

        int len = list.get(0).length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            boolean flag = true;
            char c = list.get(0).charAt(i);
            for (int j = 1; j < N; j++) {
                if(c != list.get(j).charAt(i)) flag = false;
            }
            if (flag) {
                sb.append(c);
            }else{
                sb.append("?");
            }
        }
        System.out.println(sb);



    }
}
