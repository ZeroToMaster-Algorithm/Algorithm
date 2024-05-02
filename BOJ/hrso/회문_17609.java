import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            str = br.readLine();
            System.out.println(palindrome(0, str.length()-1, 0));
        }
    }

    public static int palindrome (int lt, int rt, int del) {
        if (del == 2) return del;

        while (lt < rt){
            if (str.charAt(lt) == str.charAt(rt)){
                lt ++;
                rt --;
            } else {
                int ltSliding = palindrome(lt+1,rt,del+1);
                int rtSliding = palindrome(lt,rt-1,del+1);
                return Math.min(ltSliding,rtSliding);
            }

        }

        return del;
    }
}

