import java.util.Arrays;
import java.util.Scanner;

public class 수찾기_1920 {
    static int[] arrN;
    static int[] arrM;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arrN = new int[N];

        for(int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }
        Arrays.sort(arrN);

        int M = sc.nextInt();
        arrM = new int[M];

        for(int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }

        for(int i = 0; i < M; i++) {
            System.out.println(binarySearch(i));
        }
    }

    public static int binarySearch(int index) {
        int st = 0;
        int en = arrN.length - 1;

        while(st <= en){
            int mid = (st+en)/2;
            if(arrN[mid] == arrM[index]){
                return 1;
            }else if(arrN[mid] > arrM[index]){
                en = mid -1;
            }else {
                st = mid + 1;
            }
        }

        return 0;
    }
}
