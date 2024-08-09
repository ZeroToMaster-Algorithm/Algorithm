import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {

	static int n, m;
	static int[] d;
	static ArrayList<Integer>[] adj;
	static Queue<Integer> q = new LinkedList<>();
	static List<Integer> l = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Scan sc = new Scan();
		n = sc.nextInt();
		m = sc.nextInt();
		d = new int[n + 1];
		adj = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a].add(b);
			d[b]++;
		}

		for (int i = 1; i <= n; i++) {
			if (d[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int c = q.poll();
			l.add(c);
			System.out.println(c);

			for (int v : adj[c]) {
				d[v]--;
				if (d[v] == 0)
					q.add(v);
			}
		}

		var sb = new StringBuilder();
		for (int v : l) {
			sb.append(v).append(' ');
		}

		System.out.print(sb);

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
	}

}
