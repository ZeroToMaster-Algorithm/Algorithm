import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15]; // row는 다섯줄, column은 최대 15개 미리 할당
        int max = 0;

        //2차원 배열 초기화
        for (int i = 0; i < arr.length; i++) {
            String str = br.readLine();
            if (str.length() > max) max = str.length();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] != 0) System.out.print(arr[j][i]);
            }
        }
    }
}

