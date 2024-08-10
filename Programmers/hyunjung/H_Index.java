import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        H_Index ob = new H_Index();
        int result = ob.solution(citations);
        System.out.println(result);
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < citations.length; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[i] <= citations[j]) count++;
            }

            if(citations[i] >= count) {
                list.add(count);
            }
        }

        if(list.isEmpty()) return 0;
        return list.get(0);
    }
}
