import java.util.Scanner;

public class 기타레슨_2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lectures = new int[N];

        for(int i = 0; i < N; i++) {
            lectures[i] = sc.nextInt();
        }

        int result = minBlueRaySize(N, M, lectures);
        System.out.println(result);
    }

    private static int minBlueRaySize(int N, int M, int[] lectures) {
        int low = 0;
        int high = 0;

        for(int lecture : lectures) {
            low = Math.max(low, lecture); //최소 블루레이 크기는 가장 긴 강의의 길이
            high += lecture; // 최대 블루레이 크기는 모든 강의 길이의 합
        }

        while(low < high) {
            int mid = (low + high) / 2;
            if(canDivide(mid, lectures, M)) {
                high = mid; // 가능한 경우, 더 작은 크기를 시도
            }else {
                low = mid + 1; //불가능 한 경우, 더 큰 크기를 시도
            }
        }
        return low;
    }

    private static boolean canDivide(int maxSize, int[] lectures, int M) {
        int currentSum = 0;
        int requiredBlueRays = 1; // 필요한 블루레이 개수

        for(int lecture : lectures) {
            if(currentSum + lecture > maxSize) {
                requiredBlueRays++;
                currentSum = lecture;
                if(requiredBlueRays > M) {
                    return false;
                }
            } else {
                currentSum += lecture;
            }
        }
        return true;
    }
}
