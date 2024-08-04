import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_14502 {
    static int[][] map;
    static int[][] tempMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int M;
    static int maxSafeArea = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        tempMap = new int[N][M];

        // 0 : 빈칸 , 1 : 벽, 2 : 바이러스
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        buildWalls(0);
        System.out.println(maxSafeArea);
    }

    // 벽을 세우는 함수
    public static void buildWalls(int count) {
        if(count == 3) {
            spreadVirus();
            return;
        }

        for(int i = 0; i < N ; i ++) {
            for(int j = 0; j < M; j ++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWalls(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

 // 바이러스 퍼트리는 함수(bfs)
    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
                if(tempMap[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        calculateSafeArea();
    }

    //안전지대 확인하는 함수
    static void calculateSafeArea() {
        int safeArea = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}
