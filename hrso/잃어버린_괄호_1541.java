import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 가장 작은 값을 만드려면 가장 큰값을 만들어야함
        // 가장 큰값을 만들기위해 "+" 문자 기준으로 split 한것들을 다 더함
        // "-" 문자 기준으로 split 한것들을 다 빼면 가장 최소값을 만들수 있음.
        String[] split = str.split("-");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String x : split) {
            int sum = 0;

            String[] splitPlus = x.split("\\+");
            for (String s : splitPlus) {
                sum += Integer.parseInt(s);
            }
            arrayList.add(sum);
        }

        int answer = arrayList.get(0); //java 21 getfirst()
        for (int i = 1; i < arrayList.size(); i++) {
            answer -= arrayList.get(i);
        }

        System.out.println(answer);
    }
}

