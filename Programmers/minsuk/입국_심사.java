public class 입국_심사 {
	public long solution(int n, int[] times) {
		long left = 1;
		long right = (long) times[times.length - 1] * n;
		long answer = right;

		while (left <= right) {
			long mid = (left + right) / 2;
			long t = 0;

			for (int time : times) {
				t += mid / time;
				if (t >= n) {
					break;
				}
			}

			if (t >= n) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}
}
