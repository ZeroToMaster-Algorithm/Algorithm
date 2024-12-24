package Array.gold.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수는 1000000보다 작다
public class 두_수의_합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //최대 10만개 주어짐
        int[] arr = new int[N];

        String[] line = br.readLine().split(" ");

        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int  M = Integer.parseInt(br.readLine()); //수열안에 두 개를 더해서 이 합이 되어야 한다.

        int cnt=0;
        int l = 0;
        int r = N-1;
        while(l<r){
            int sum = arr[l]+arr[r];
            if(sum==M){
                cnt++;
                l++;
                r--;
            } else if (sum<M) {
                l++;
            }else{
                r--;
            }
        }
        System.out.println(cnt);

    }
}
