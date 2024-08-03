import java.io.*;
import java.util.*;


public class 아기상어_16236 {

	static int n, size = 2, ret, y, x, e;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};

	static boolean[][] v;
	static int[][] a;

	static Queue<int[]> q = new LinkedList<>();
	static List<int[]> l = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		var sc = new Scan();
		n = sc.nextInt();
		a = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){

				a[i][j] = sc.nextInt();
				if(a[i][j] == 9){
					y = i;
					x = j;
					a[i][j] = 0;
				}
			}
		}

		while(true){
			l.clear();
			q.clear();

			v = new boolean[n][n];
			v[y][x] = true;
			q.add(new int[]{y,x,0});
			if(go()) break;
		}

		System.out.println(ret);
	}

	static boolean go(){
		int sd = -1;
		while(!q.isEmpty()){
			int[] f = q.poll();
			int y = f[0];
			int x = f[1];
			int d = f[2];

			if(sd != -1 && d > sd) break;

			if(a[y][x] > 0 && a[y][x] < size){ //
				l.add(new int[]{y,x,d});
				sd = d;
			}

			for(int i = 0; i < 4; i++){
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(ny < 0 || nx < 0 || ny >= n || nx >= n || v[ny][nx])
					continue;
				if(a[ny][nx] > size)
					continue;

				v[ny][nx] = true;
				q.add(new int[]{ny, nx, d + 1});
			}
		}

		if(l.isEmpty()) return true;

		l.sort((a,b) -> {
			if(a[0] == b[0]){
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int[] p = l.get(0);
		y = p[0];
		x = p[1];
		ret += p[2];
		a[y][x] = 0;
		if(size == ++e){
			size++;
			e = 0;
		}
		return false;
	}

	static class Scan {

		BufferedReader br;
		StringTokenizer st;

		Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		String nextLine() throws Exception {
			return br.readLine();
		}

		void clear() throws Exception {
			br.close();
		}
	}
}

