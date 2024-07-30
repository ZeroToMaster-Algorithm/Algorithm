import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    static List<List<Integer>> list = new ArrayList<>();
    static int result = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalComputer = Integer.parseInt(br.readLine());
        int connectNum = Integer.parseInt(br.readLine());
        visited = new boolean[totalComputer+1];

        for(int i = 0; i <= totalComputer; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < connectNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(1);
        System.out.println(result);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int i = 0; i < list.get(start).size() ; i ++) {
            if(!visited[list.get(start).get(i)]) {
                dfs(list.get(start).get(i));
            }
        }
        result++;
    }

}
