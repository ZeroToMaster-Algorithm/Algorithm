import java.io.*;
import java.util.*;

public class 아기상어_16236 {
    static int N;
    static int curX;
    static int curY;
    static int curSize;
    static int countEat;
    static int canEat;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] matrix;

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
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == 9) {
                    curX = i;
                    curY = j;
                }
            }
        }

        // 아기 상어 기본 크기
        curSize = 2;

        // 크기가 커진 후 먹은 물고기 수
        countEat = 0;
    }

    static void process(BufferedWriter bw) throws IOException {
        int count = 0;
        matrix[curX][curY] = 0;

        while (true) {
            List<Point> canEatList = bfs(curX, curY);

            // 더 이상 먹을 수 있는 물고기가 공간에 없다면, 엄마 상어에게 도움 요청
            if (canEat == 0) break;

            // 거리 최솟값 -> 가장 위 -> 가장 왼쪽 순으로 정렬
            Collections.sort(canEatList);

            Point next = canEatList.get(0);
            count += next.getDistance();
            matrix[next.getX()][next.getY()] = 0;
            curX = next.getX();
            curY = next.getY();
            countEat++;
            if (curSize == countEat) {
                curSize++;
                countEat = 0;
            }
        }

        bw.append(String.valueOf(count));
    }

    // x, y를 기준으로 모든 matrix까지의 거리 목록을 반환
    private static List<Point> bfs(int x, int y) {
        Deque<Point> q = new ArrayDeque<>();
        List<Point> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        canEat = 0;

        q.offer(new Point(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int tempX = p.getX();
            int tempY = p.getY();
            int tempDistance = p.getDistance();
            for (int i = 0; i < 4; i++) {
                int xx = tempX + dx[i];
                int yy = tempY + dy[i];
                if (isValidPosition(xx, yy) && !visited[xx][yy] && matrix[xx][yy] <= curSize) {
                    visited[xx][yy] = true;

                    Point next = new Point(xx, yy, tempDistance + 1);
                    q.offer(next);

                    if (matrix[xx][yy] != curSize && matrix[xx][yy] > 0) {
                        canEat++;
                        list.add(next);
                    }
                }
            }
        }

        return list;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Point implements Comparable<Point>{
        private final int x;
        private final int y;
        private final int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDistance() {
            return this.distance;
        }

        // 정렬 : distance 최솟값 > 가장 위 > 가장 왼쪽
        @Override
        public int compareTo(Point o) {
            int compDist = this.distance - o.distance;
            int compX = this.x - o.x;
            int compY = this.y - o.y;
            if (compDist != 0) {
                return compDist;
            } else if (compX != 0) {
                return compX;
            } else {
                return compY;
            }
        }
    }
}