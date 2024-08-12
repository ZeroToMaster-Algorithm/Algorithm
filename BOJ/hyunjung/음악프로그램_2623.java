import java.util.*;

public class 음악프로그램_2623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[N+1];

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int[] number = new int[a];
            for(int j = 0; j < a; j++) {
                int b = sc.nextInt();
                number[j] = b;
            }

            for(int j = 0; j < a-1; j++) {
                int front = number[j];
                int back = number[j+1];

                list.get(front).add(back);
                arr[back]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(arr[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int number = queue.remove();
            answer.add(number);
            for(int j = 0; j < list.get(number).size(); j++) {
                arr[list.get(number).get(j)]--;
                if(arr[list.get(number).get(j)] == 0) {
                    queue.add(list.get(number).get(j));
                }
            }
        }

        if(answer.size() != N) {
            System.out.println(0);
        }else {
            for(int i = 0 ; i < answer.size() ; i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}
