import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_7576 {
    static int[][] boxes;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        boxes = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int nonRipe = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                boxes[j][i] = scanner.nextInt();
                if(boxes[j][i] == 1) {
                    queue.add(new int[]{j, i});
                }else if(boxes[j][i] == 0) {
                    nonRipe++;
                }
            }
        }

        if(nonRipe == 0) {
            System.out.println(0);
            return;
        }

        int dayCount = bfs(nonRipe, queue);
        System.out.println(dayCount);

    }

    public static int bfs(int nonRipe, Queue<int[]> queue) {
        int dayCount = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            dayCount++;

            for(int i=0; i<size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && boxes[nx][ny] == 0) {
                        boxes[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                        nonRipe--;
                    }
                }
            }
        }


        return nonRipe == 0 ?  dayCount : -1;
    }
}
