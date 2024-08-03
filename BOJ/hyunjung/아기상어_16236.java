import java.util.*;

public class 아기상어_16236 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 아기 상어 정보 저장 - 위치, 크기, 현재까지 먹은 물고기 수
    static class Shark {
        int x, y, size, eaten;
        Shark(int x, int y, int size, int eaten) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eaten = eaten;
        }
    }

    static Shark shark;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    // 아기 상어의 초기 위치를 빈 칸으로 변경
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(simulate());
    }

    // 아기 상어가 물고기를 먹으며 이동하는 과정
    static int simulate() {
        int time = 0;
        while(true) {
            // 먹을 수 있는 물고기 찾기 위한 BFS 호출
            Fish fish = bfs();
            // 먹을 물고기가 없다면 종료
            if(fish == null) break;
            //먹은 물고기 위치로 아기 상어를 이동시키고, 경과 시간을 업데이트
            time += fish.dist;
            shark.x = fish.x;
            shark.y = fish.y;
            shark.eaten++;
            map[fish.x][fish.y] = 0;

            if(shark.eaten == shark.size) {
                // 아기 상어 크기 증가, 먹은 물고기 수 초기화
                shark.size++;
                shark.eaten = 0;
            }
        }
        return time;
    }

    //물고기 클래스 - 물고기의 위치와 거리를 저장하는 클래스
    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // 우선 순위 큐에서 물고기를 정렬하기 위한 메소드
        @Override
        public int compareTo(Fish o) {
            // 거리가 짧은 물고기가 우선, 거리가 같은 경우 위쪽 및 왼쪽에 위치한 물고기가 우선
            if(this.dist == o.dist) {
                if(this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    // 아기 상어가 먹을 수 있는 물고기를 찾는 메소드
    private static Fish bfs() {
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        List<Fish> fishes = new ArrayList<>();

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= shark.size) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] < shark.size && map[nx][ny] > 0) {
                        fishes.add(new Fish(nx, ny, dist + 1));
                    } else {
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        if(fishes.isEmpty()) return null;
        // 가장 우선순위가 높은 물고기 return 하기 위해 정렬
        Collections.sort(fishes);
        return fishes.get(0);
    }

}
