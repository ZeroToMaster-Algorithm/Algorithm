import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타_레슨_2343 {
	static int n, m;
	static int[] a;

	public static void main(String[] args) throws Exception {
		var sc = new Scan();

		n = sc.nextInt();
		m = sc.nextInt();

		a = new int[n];

		int r = 0;
		int l = 0;

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			r += a[i];
			l = Math.max(l, a[i]);
		}

		while (l <= r) {
			int mid = (l + r) / 2;  // renamed to avoid confusion

			int c = count(mid);

			if (c > m) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		System.out.println(l);

	}

	static int count(int mid) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (sum + a[i] > mid) {
				sum = 0;
				c++;
			}
			sum += a[i];
		}

		if (sum != 0)
			c++;
		return c;
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
