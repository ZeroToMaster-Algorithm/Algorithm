import java.io.*;
import java.util.*;

public class BOJ_바이러스 {

    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(bf.readLine());
        v = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int n = q.poll();

            for (int num : arr[n]) {
                if (!v[num]) {
                    q.add(num);
                    cnt++;
                    v[num] = true;

                }
            }
        }

//        int cnt = 0;
//        for (int i = 0; i < N; i++) {
//            if (v[i]) {
//                cnt++;
//            }
//        }
        System.out.println(cnt);

    }

}
