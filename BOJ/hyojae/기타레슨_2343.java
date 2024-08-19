import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    static int N;
    static int M;
    static int[] list;
    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        // start는 일단 각 값을 1개라도 담을 수 있어야 하므로 최댓값으로 설정함
        int start = list[0];
        // 얘는 모든 값을 담을 수 있어야 하므로 길이 전체의 합으로 설정함
        int end = list[0];
        for (int i = 1; i < N; i++) {
            start = Math.max(start, list[i]);
            end += list[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            // 블루레이 1개에 들어가는 강의의 합
            int sum = 0;

            // 블루레이의 개수
            int count = 0;

            for (int i = 0; i < N; i++) {
//                합이 mid보다 크다면 블루레이 개수 1개 추가
                if (sum + list[i] > mid) {
                    sum = 0;
                    count++;
                }

                sum += list[i];
            }

            if (sum > 0) {
                count++;
            }

            // 필요한 블루레이 갯수가 M보다 작거나 같으면
            if (count <= M) {
                end = mid - 1;
            }
            // 필요한 블루레이 갯수가 M보다 크다면
            else {
                start = mid + 1;
            }
        }

        return String.valueOf(start);
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