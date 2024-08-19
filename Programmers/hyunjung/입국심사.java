import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(6, new int[]{7,10});
        System.out.println(answer);
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;
        long high = (long)times[times.length-1]* n;
        while(low < high) {
            long mid = (low+high) / 2;

            if(check(mid, times, n)) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean check(long limit, int[]times, int n){
        long total = 0;

        for(int time : times) {
            total += limit / time;
            if(total >= n) {
                return true;
            }
        }
        return false;
    }
}
