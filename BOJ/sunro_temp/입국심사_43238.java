package Array.gold;

public class 입국심사_43238 {
    public long solution(int n, int[] times) {
        long left = 1; // 가능한 최소 시간
        long right = (long) times[0] * n; // 가능한 최대 시간 (최악의 경우)

        for (int time : times) {
            if (time * (long) n > right) {
                right = (long) time * n;
            }
        }

        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 심사관들이 mid 시간 동안 처리할 수 있는 사람의 수

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = mid;
                right = mid - 1; // 시간을 줄여본다.
            } else {
                left = mid + 1; // 시간을 늘린다.
            }
        }

        return answer;
    }
}
