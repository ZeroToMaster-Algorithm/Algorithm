package Array.gold;

import java.io.*;
import java.util.*;

public class 기타레슨_2343 {
    static int N;
    static int M;
    static int[] record;
    static int maxRecord = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        record = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            record[i] = Integer.parseInt(st.nextToken());
            maxRecord = Math.max(record[i], maxRecord);
        }

        int l = maxRecord;
        int r = Arrays.stream(record).sum();
        int answer = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            int blueRay = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum + record[i] > m) {
                    blueRay++;
                    sum = record[i];
                } else {
                    sum += record[i];
                }
            }
            if (blueRay <= M) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.print(answer);
    }
}

