import java.util.Arrays;

public class h_index {

	public int solution(int[] a) {
		int len = a.length;

		Arrays.sort(a);

		for (int i = 0; i < len; i++) {
			int h = len - i;
			if (a[i] >= h) {
				return h;
			}
		}
		return 0;
	}

}
