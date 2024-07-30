import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
    static List<List<Integer>> list = new ArrayList<>();
    static int result = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum =  Integer.parseInt(br.readLine());
        visited = new boolean[inputNum + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= inputNum; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer relation = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(relation.nextToken());
            int child = Integer.parseInt(relation.nextToken());

            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        dfs(targetX, targetY, 0);
        System.out.println(result);
    }

    private static void dfs(int current, int target, int depth) {
        if(current == target) {
            result = depth;
            return;
        }

        visited[current] = true;

        for(int i = 0; i < list.get(current).size(); i++) {
            if(!visited[list.get(current).get(i)]) {
                dfs(list.get(current).get(i), target, depth+1);
            }
        }
    }


}
