import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringJoiner answer = new StringJoiner(" ");
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(scan.nextLine());

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
                answer.add(String.valueOf(queue.poll()));
                if(!queue.isEmpty()) {
                    queue.add(queue.poll());
                }
        }

        System.out.println(answer);
    }
}
