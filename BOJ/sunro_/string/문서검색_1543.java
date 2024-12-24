package Array.gold.string;

import java.util.Scanner;

public class 문서검색_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String docu = sc.nextLine();
        String searchWord = sc.nextLine();

        String replaceWord = docu.replace(searchWord,"");
        int len = docu.length()-replaceWord.length();
        System.out.println(len/searchWord.length());
    }
}
