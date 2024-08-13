import java.util.*;
import java.io.*;

public class BOJ_기타레슨 {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(bf.readLine());

        int low = 0;
        int high = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            high += A[i];
            low = Math.max(low, A[i]);
        }

        // 1 2 3 4 5
        // low = 5
        // high = 15
        // m = 2 이면 답은 9

        // mid = 6

        int mid = 0;
        int sum = 0;
        int cnt = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            sum = 0;
            cnt = 0;
            for (int i = 0; i < A.length; i++) {
                if (sum + A[i] <= mid) {
                    sum += A[i];
                } else {
                    sum = 0;
                    sum += A[i];
                    cnt++;
                }
            }
            if (sum > 0) {
                cnt++;
            }

            ////    System.out.println("mid: " + mid);
            // System.out.println("cnt: " + cnt);

            if (cnt <= M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);


    }
}
