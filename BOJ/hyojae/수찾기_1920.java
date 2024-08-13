import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    static int N;
    static int[] A;
    static int M;
    static int[] B;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        A = new int[N];
        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(lines[2]);
        B = new int[M];
        st = new StringTokenizer(lines[3]);
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int num : B) {
            int start = 0;
            int end = A.length - 1;
            int mid = (start + end) / 2;
            boolean exist = false;

            while (start <= end) {
                if (A[mid] == num) {
                    exist = true;
                    break;
                }
//              num이 mid의 오른쪽에 있다면
                else if (A[mid] < num) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                }
//              num이 mid의 왼쪽에 있다면
                else {
                    end = mid - 1;
                    mid = (start + end) / 2;
                }
            }

            if (exist) {
                output.append("1").append("\n");
            } else {
                output.append("0").append("\n");
            }
        }

        return output.toString();
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