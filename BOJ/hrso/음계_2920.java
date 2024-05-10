import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> asc = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> dsc = new ArrayList<>(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> tmp = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tmp.add(Integer.parseInt(st.nextToken()));
        }

        if (tmp.equals(asc)) {
            System.out.println("ascending");
        } else if (tmp.equals(dsc)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

}