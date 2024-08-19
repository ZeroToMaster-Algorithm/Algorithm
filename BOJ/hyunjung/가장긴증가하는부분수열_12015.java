import java.util.*;

public class 가장긴증가하는부분수열_12015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i ++) {
            numbers[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int length = 0;

        for (int i = 0; i < n; i++) {
            int pos = check(dp, 0, length, numbers[i]);
            //int pos = Arrays.binarySearch(dp, 0, length, numbers[i]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            dp[pos] = numbers[i];
            if (pos == length) {
                length++;
            }
        }

        System.out.println(length);
    }

    public static int check(int[] dp, int start, int finish, int key){
        int low = start;
        int high = finish - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(dp[mid] < key) {
                low = mid + 1;
            }else if(dp[mid] > key) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -(low+1);
    }

}
