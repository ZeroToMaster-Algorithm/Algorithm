package Array.gold.array;

import java.io.*;

public class 수_정렬하기_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[10_001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                bw.write(arr[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
