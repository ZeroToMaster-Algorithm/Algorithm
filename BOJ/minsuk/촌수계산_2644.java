import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산_2644 {

	static int n, p1, p2, m, ret = -1;
	static boolean[][] map;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		var sc = new Scan();
		n = sc.nextInt();
		p1 = sc.nextInt();
		p2 = sc.nextInt();
		m = sc.nextInt();

		map = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();

			map[p][c] = true;
			map[c][p] = true;
		}

		v = new boolean[n + 1];
		go(p1, 0);

		System.out.println(ret);
	}

	static void go(int p1, int d) {
		v[p1] = true;

		if (p1 == p2) {
			ret = d;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (map[p1][i] && !v[i])
				go(i, d + 1);
		}

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
