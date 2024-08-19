import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_12015 {
    static int N;
    static int[] list;
    static int[] lis;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        lis[0] = list[0];
        int idx = 1;

        for (int i = 1; i < N; i++) {
            int elem = list[i];

            // elem이 LIS의 마지막 값보다 크면 뒤에 추가
            if (lis[idx - 1] < elem) {
                lis[idx++] = elem;
            } else {
                // lower bound 탐색
                int low = 0;
                int high = idx;

                while (low < high) {
                    int mid = (low + high) >> 1;

                    if (lis[mid] < elem) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                lis[low] = elem;
            }
        }

        return String.valueOf(idx);
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}