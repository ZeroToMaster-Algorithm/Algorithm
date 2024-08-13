import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기_1920 {

	static int n, m;
	static int[] a;

	public static void main(String[] args) throws Exception {
		var sc = new Scan();

		n = sc.nextInt();
		a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		m = sc.nextInt();
		var sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			if (bs(sc.nextInt())) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb);
	}

	static boolean bs(int t) {
		int s = 0;
		int e = n - 1;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (a[mid] < t) {
				s = mid + 1;
			} else if (a[mid] > t) {
				e = mid - 1;
			} else {
				return true;
			}
		}

		return false;
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
