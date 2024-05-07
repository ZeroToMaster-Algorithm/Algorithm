import java.io.*;
import java.util.*;

public class Main {
    static int[] check;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] ch = (br.readLine()).toCharArray();
        check = new int[4]; //{'A','C','G','T'}의 최소 개수
        arr = new int[4]; // 부분문자열이 가진 {'A','C','G','T'}의 개수
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<P; i++) {
            add(ch[i]);
        }
        //처음 부분 문자열 비밀번호 가능 여부 체크
        if(isCheck()) count++;

        int lt = 0;
        int rt = 0;
        for(rt=P; rt<S; rt++) {
            lt = rt-P;
            remove(ch[lt]);
            add(ch[rt]);
            if(isCheck()) count++;
        }

        System.out.println(count);

    }

    public static boolean isCheck() {
        if(check[0]<=arr[0] && check[1]<=arr[1] &&
                check[2]<=arr[2] && check[3]<=arr[3]){
            return true;
        }
        return false;
    }

    public static void add(char c) {
        switch(c) {
            case 'A':
                arr[0]++;
                break;
            case 'C':
                arr[1]++;
                break;
            case 'G':
                arr[2]++;
                break;
            case 'T':
                arr[3]++;
                break;
        }
    }

    public static void remove(char c) {
        switch(c) {
            case 'A':
                arr[0]--;
                break;
            case 'C':
                arr[1]--;
                break;
            case 'G':
                arr[2]--;
                break;
            case 'T':
                arr[3]--;
                break;
        }
    }
}