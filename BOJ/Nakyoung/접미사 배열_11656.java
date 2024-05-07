import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String line = scan.nextLine();
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<line.length(); i++) {
			list.add(line.substring(i));
		}
		
		list.sort(Comparator.naturalOrder());
		
		for(String str : list) {
			System.out.println(str);
		}
		
		scan.close();
	}
}
