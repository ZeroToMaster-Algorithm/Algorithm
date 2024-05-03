package day240503.p17609;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = Integer.parseInt(scan.nextLine());
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			String line = scan.nextLine();
			StringBuilder sb = new StringBuilder(line);
			int result = 2;
			
			int front = 0, back = line.length()-1;
			int cnt = 0;
			
			if(sb.toString().equals(sb.reverse().toString())) {
				result = 0;
				answer.append(result).append("\n");
				continue;
			}
			
			while(front < back) {
				if(line.charAt(front) != line.charAt(back)) {
					StringBuilder delFront = new StringBuilder(sb).deleteCharAt(front);
					StringBuilder delBack = new StringBuilder(sb).deleteCharAt(back);
					
					if(delFront.toString().equals(delFront.reverse().toString()) || delBack.toString().equals(delBack.reverse().toString())) {
						result = 1;
					}
					break;
				}				
				front++;
				back--;
			}
			
			answer.append(result).append("\n");
		}
		System.out.println(answer);
	}
}
