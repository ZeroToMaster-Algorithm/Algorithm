import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
	static int ROW, COL;
	static int[][] MAP;
	static int answer = 0;
	static int[] xArray = { -1, 0, 1, 0 };
	static int[] yArray = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());

		MAP = new int[ROW][COL];

		int[][] tempMap = new int[ROW][COL];
		// 1. 입력값에 대한 MAP 정보 처리
		// 0은 빈칸, 1은 벽, 2는 바이러스
		for (int i = 0; i < ROW; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < COL; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				tempMap[i][j] = MAP[i][j];
			}
		}

		boolean[][] checked = new boolean[ROW][COL];
		// 2. 전체 맵에서 0: 빈칸에 대한 벽 적용 DFS로 적용
		findBuildWallSpotByDfs(tempMap, checked, 0);
		br.close();
		System.out.println(answer);
	}

	private static void findBuildWallSpotByDfs(int[][] tempMap, boolean[][] checked, int changedSpot) {
		// 변경한 벽이 3이 된 순간 그 스팟을 찾고 해당 지점에 벽을 세워 bfs 탐색 시작
		if (changedSpot == 3) {
			// bfs start
			answer = Math.max(searchByBfs(tempMap), answer);
			return;
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// 벽이고 체크하지 않았다면
				if (tempMap[i][j] == 0 && !checked[i][j]) {
					tempMap[i][j] = 1;
					checked[i][j] = true;
					findBuildWallSpotByDfs(tempMap, checked, changedSpot + 1);
					checked[i][j] = false;
					tempMap[i][j] = 0;
				}
			}
		}
	}

	private static int searchByBfs(int[][] tempMap) {
		int sum = 0;
		Queue<int[]> myQ = new LinkedList<>();
		boolean[][] visited = new boolean[ROW][COL];

		// tempMap의 내부 값을 바이러스로 변경시키지 않기 위해 bfs 탐색을 위한 map 추가 생성
		int[][] cloneMap = new int[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			cloneMap[i] = tempMap[i].clone();
			for (int j = 0; j < COL; j++) {
				// 바이러스만 넣어놓는다.
				if (MAP[i][j] == 2) {
					myQ.offer(new int[] { i, j });
					visited[i][j] = true;
				}

			}
		}

		while (!myQ.isEmpty()) {
			int[] cur = myQ.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 4; i++) {
				int movedX = curX + xArray[i];
				int movedY = curY + yArray[i];
				if (movedX >= 0 && movedX < ROW && movedY >= 0 && movedY < COL && !visited[movedX][movedY]
						&& cloneMap[movedX][movedY] == 0) {
					visited[movedX][movedY] = true;
					// 감염시킨다. 바이러스로
					cloneMap[movedX][movedY] = 2;
					myQ.offer(new int[] { movedX, movedY });
				}
			}
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// 바이러스만 넣어놓는다.
				if (cloneMap[i][j] == 0) {
					sum++;
				}
			}
		}
		return sum;
	}
}
