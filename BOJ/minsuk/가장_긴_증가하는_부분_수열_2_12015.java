import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열_2_12015 {
	static int n;
	static int[] a;
	static List<Integer> l = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		var sc = new Scan();

		n = sc.nextInt();
		a = new int[n];
		l.add(0);

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (a[i] > l.get(l.size() - 1)) {
				l.add(a[i]);
			} else {
				int left = 0;
				int right = l.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (l.get(mid) >= a[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				l.set(right, a[i]);
			}

		}
		System.out.println(l.size() - 1);
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
