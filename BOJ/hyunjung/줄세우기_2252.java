import java.util.*;

public class 줄세우기_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] inDegree = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            graph.get(A).add(B);
            inDegree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < N+1; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }


        while(!queue.isEmpty()) {
            int studentNumber = queue.poll();
            result.append(studentNumber + " ");

            List<Integer> list = graph.get(studentNumber);

            for(int i = 0; i < list.size(); i++) {
                int student = list.get(i);
                inDegree[student]--;
                if(inDegree[student] == 0) {
                    queue.add(student);
                }
            }
        }

        System.out.println(result);

    }
}
