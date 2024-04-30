package PS_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS_240429_잃어버린괄호_BJ1541 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    // 1. 아이디어: 마이너스(-) 기호를 기준으로 최대한 큰 값을 할당하도록 해보자
    // 2. 시간 복잡도: O(N) N = 50;
    // 3. 자료구조:
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        String[] strSplitMinus = str.split("-");
        int sum = 0;
        int idx = 0;
        for (String s1 : strSplitMinus) {
            String[] strSplitPlus = s1.split("\\+");

            for (String s2 : strSplitPlus) {
                if (idx == 0) {
                    sum += Integer.parseInt(s2);
                }
                else {
                    sum -= Integer.parseInt(s2);
                }
            }
            idx++;
        }
        System.out.println(sum);
    }
}
