import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

	static int n, m, ret;
	static int[][] a;
	static boolean[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		Scan sc = new Scan();

		m = sc.nextInt();
		n = sc.nextInt();

		a = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int k = sc.nextInt();
				a[i][j] = k;

				if (k == 1) {
					q.add(new int[] {i, j});
					v[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {

			int s = q.size();

			for (int k = 0; k < s; k++) {
				int[] f = q.poll();
				int y = f[0];
				int x = f[1];

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] || a[ny][nx] == -1) {
						continue;
					}
					v[ny][nx] = true;
					a[ny][nx] = 1;
					q.add(new int[] {ny, nx});
				}

			}

			if (!q.isEmpty()) {
				ret++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(ret);
	}

	static class Scan {

		BufferedReader br;
		StringTokenizer st;

		Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		String nextLine() throws Exception {
			return br.readLine();
		}

		void clear() throws Exception {
			br.close();
		}
	}
}

