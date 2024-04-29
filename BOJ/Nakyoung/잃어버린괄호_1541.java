import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		String[] su = line.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
    
		int sum = 0; 

		if(su.length > 0) {	
			int index = 1;
			
			for(String s : su) {
				if(s.equals("-")) {
					index = -1;
				}else if(!s.equals("+") && !s.equals("-")) {
					sum += Integer.parseInt(s) * index;
				}
			}
		}
		
		System.out.println(sum);
	}
}
