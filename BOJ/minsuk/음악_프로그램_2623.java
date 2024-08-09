import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악_프로그램_2623 {
	static int n, m;
	static ArrayList<Integer>[] a;
	static int[] d;
	static List<Integer> l = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();


	public static void main(String[] args) throws Exception {

		Scan sc = new Scan();
		n = sc.nextInt();
		m = sc.nextInt();
		a = new ArrayList[n + 1];
		d = new int[n+1];

		for(int i = 1; i <= n; i++){
			a[i] = new ArrayList<>();
		}

		while(m-- > 0){
			int c = sc.nextInt();
			int prev = sc.nextInt();

			for(int i = 0; i < c - 1; i++){
				int k = sc.nextInt();
				a[prev].add(k);
				d[k]++;

				prev = k;
			}

		}

		for(int i = 1; i <= n; i++){
			if(d[i] == 0) q.add(i);
		}

		while(!q.isEmpty()){
			int f = q.poll();
			l.add(f);

			for(int v : a[f]){
				d[v]--;

				if(d[v] == 0) q.add(v);
			}

		}

		if(l.size() != n){
			System.out.println(0);
			return;
		}

		var sb = new StringBuilder();

		for(int v : l){
			sb.append(v).append('\n');
		}

		System.out.println(sb);

	}



	static class Scan{
		BufferedReader br;
		StringTokenizer st;

		Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception{
			while(st == null || !st.hasMoreElements()){
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception{
			return Integer.parseInt(next());
		}
	}
}
