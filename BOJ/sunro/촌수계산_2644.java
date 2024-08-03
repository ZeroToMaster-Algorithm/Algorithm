package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 촌수계산_2644 {

    static boolean[] visited; //방문 배열
    static int[] dist; //거리 계산
    static List<Integer>[] list;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        visited = new boolean[N + 1]; //1부터 시작하기때문에 N+1
        dist = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        //계산할 촌수
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        //edge 수
        st = new StringTokenizer(br.readLine());
        int edge = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        System.out.println(findDistance(p1, p2));

    }

    private static int findDistance(int p1, int p2) {
        Queue<Integer> que = new LinkedList<>();
        dist[p1] = 0;
        visited[p1] = true;
        que.offer(p1);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int x : list[now]) {
                if (!visited[x]) {
                    dist[x] = dist[now] + 1;
                    if (x == p2) {
                        return dist[x];
                    }
                    que.offer(x);
                    visited[x]=true;
                }
            }
        }
        return -1;
    }
}
