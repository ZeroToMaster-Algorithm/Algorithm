import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스_2606 {

	static int n, m, ret;
	static boolean[][] map;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		var sc = new Scan();
		n = sc.nextInt();
		m = sc.nextInt();
		map = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a][b] = true;
			map[b][a] = true;
		}

		v = new boolean[n + 1];
		go(1);
		System.out.println(ret - 1);
	}

	static void go(int k) {
		v[k] = true;

		ret++;
		for (int i = 1; i <= n; i++) {
			if (map[k][i] && !v[i])
				go(i);
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
