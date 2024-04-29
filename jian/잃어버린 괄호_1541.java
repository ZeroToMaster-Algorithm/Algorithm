import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String A = br.readLine();

        // - 를 구분자로 나누고, 첫번째 배열을 제외한 나머지 배열을 모두 빼면 정답이다.

        String[] strArr = A.split("-");
        int sum = 0;
        for(int i=0; i<strArr.length; i++){
            String [] subStrArr = strArr[i].split("\\+");
            if(i==0){//첫번째 배열은 첫번째요소가 양수임.
                for(int j=0; j< subStrArr.length; j++){
                    sum += Integer.parseInt(subStrArr[j]);
                }
            }else{//나머지는 모두 빼버리자.
                for(int j=0; j< subStrArr.length; j++){
                    sum -= Integer.parseInt(subStrArr[j]);
                }//for-2
            }//else
        }//for-1
        bw.write(sum+"");


        bw.flush();
        bw.close();
        br.close();

    }//main

}//Main
