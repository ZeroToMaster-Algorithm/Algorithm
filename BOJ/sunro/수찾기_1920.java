package Array.gold;
import java.util.*;
import java.io.*;

public class 수찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());
        int[] list  = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(list);

        int len2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < len2; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 이진 탐색 수행
            if (binarySearch(list, target)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
    }

    // 이진 탐색 메서드
    private static boolean binarySearch(int[] list, int target) {
        int l = 0;
        int r = list.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (list[m] == target) {
                return true;
            } else if (list[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
