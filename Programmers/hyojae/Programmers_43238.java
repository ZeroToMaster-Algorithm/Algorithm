import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Programmers_43238 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        long low = 1;
        long high = Long.MIN_VALUE;
        for (int time : times) {
            high = Math.max(high, time);
        }

        high *= n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long people = 0;

            for (int time : times) {
                people += mid / time;
            }

            if (people >= n) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
