import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner answer = new StringJoiner("\n");

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            String s = br.readLine();
            Queue<Character> queue = new LinkedList<>();

            for(char ch : s.toCharArray()) {
                if(ch=='(') {
                    queue.add(ch);
                }else {
                    if(queue.isEmpty()){
                        queue.add(ch);
                        break;
                    }
                    queue.poll();
                }
            }

            answer.add(queue.isEmpty() ? "YES" : "NO");
        }

        System.out.println(answer);
    }
}