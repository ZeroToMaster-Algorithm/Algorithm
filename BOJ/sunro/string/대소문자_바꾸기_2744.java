package Array.gold.string;

import java.util.Scanner;
//65 - 90
//97-122
public class 대소문자_바꾸기_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] charArr = line.toCharArray();
        for(char c : charArr){
            if(c>=65 && c<=90){
                System.out.print((char)(c+32));
            }else{
                System.out.print((char)(c-32));
            }
        }
    }
}
