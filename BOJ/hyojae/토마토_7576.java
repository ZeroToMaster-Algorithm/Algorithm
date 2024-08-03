import java.io.*;
import java.util.*;

public class 토마토_7576 {
    static int M;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] matrix;
    static boolean[][] visited;
    static boolean change;
    static Deque<int[]> deque;
    static Deque<int[]> tempDeque;
    static int zeroCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input(br);

        process(bw);

        // output
        bw.flush();

        br.close();
        bw.close();
    }

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];
        deque = new ArrayDeque<>();
        zeroCount = 0;
        tempDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                int item = input[j];
                matrix[i][j] = item;
                if (item == 1) {
                    deque.add(new int[]{i, j});
                }
                if (item == 0) {
                    zeroCount++;
                }
            }
        }
    }

    static void process(BufferedWriter bw) throws IOException {
        int day = 0;
        while (true) {
            change = false;
            while (!deque.isEmpty()) {
                int[] xy = deque.poll();
                int x = xy[0];
                int y = xy[1];
                bfs(x, y);

            }
            if (change) day++;
            else if (day == 0) {
                bw.append(zeroCount > 0 ? "-1" : "0");
                return;
            }
            else {
//                    모두 익지 못했다면
                if (zeroCount > 0) {
                    bw.append("-1");
                    return;
                }
                bw.append(String.valueOf(day));
                return;
            }
            deque = tempDeque;
            tempDeque = new ArrayDeque<>();
        }
    }

    private static void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && matrix[xx][yy] == 0 && !visited[xx][yy])  {
                matrix[xx][yy] = 1;
                tempDeque.add(new int[]{xx, yy});
                change = true;
                visited[xx][yy] = true;
                zeroCount--;
            }
        }
    }
}