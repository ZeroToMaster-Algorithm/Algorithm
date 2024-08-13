
// 기타레슨
// 기타강의의 길이가 강의 순서대로 주어질 경우
// 블루레이의 개수를 최소화 할 수 있는 녹화 가능한 길이 정보를 리턴해라.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ARRAY_COUNT = Integer.parseInt(st.nextToken());
		int MAX_RECORD_COUNT = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		int max = 0;
		array = new int[ARRAY_COUNT];
		for (int i = 0; i < ARRAY_COUNT; i++) {
			// 입력값이 이미 정렬된 상태이므로 정렬할 필요가 없다.
			array[i] = Integer.parseInt(st.nextToken());
			max += array[i];
		}

		int left = array[ARRAY_COUNT - 1];
		int right = max;
		int mid = 0;
		// 이분탐색 시작, 기본 조건
		while (left <= right) {
			mid = (left + right) / 2;
			if (count(mid) <= MAX_RECORD_COUNT) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		answer = Math.min(max, answer);
		System.out.println(answer);
	}

	public static int count(int m) {
		int cnt = 1;
		int target = m;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > target) {
				cnt++;
				target = m;
				target -= array[i];
				continue;
			}
			target -= array[i];
		}
		return cnt;
	}
}
