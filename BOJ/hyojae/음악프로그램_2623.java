import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음악프로그램_2623 {
    static int N;
    static int M;
    static List<List<Integer>> adj;
    static int[] degree;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        degree = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(lines[i + 1]);

            int len = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < len - 1; j++) {
                int B = Integer.parseInt(st.nextToken()) - 1;

                adj.get(A).add(B);
                degree[B]++;
                A = B;
            }

//            int A = Integer.parseInt(st.nextToken()) - 1;
//            int B = Integer.parseInt(st.nextToken()) - 1;
        }
        output = new StringBuilder();
    }

    static String process() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            output.append(cur + 1).append("\n");

            for (Integer i : adj.get(cur)) {
                degree[i]--;

                if (degree[i] == 0) {
                    q.add(i);
                }
            }
        }

        for (int i : degree) {
            if (i != 0) {
                return "0";
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