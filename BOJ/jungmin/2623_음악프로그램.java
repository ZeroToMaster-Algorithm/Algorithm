// import java.util.*;
// import java.io.*;

// public class BOJ_음악프로그램 {
//     static ArrayList<ArrayList<Integer>> arr;
//     static int N, M;
//     static int[] idx;

//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());

//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());

//         arr = new ArrayList<>();
//         for (int i = 0; i < N + 1; i++) {
//             arr.add(new ArrayList<>());
//         }
//         idx = new int[N + 1];
//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(bf.readLine());

//             int count = Integer.parseInt(st.nextToken());
//             int[] temp = new int[count];

//             for (int j = 0; j < count; j++) {
//                 temp[j] = Integer.parseInt(st.nextToken());
//             }

//             for (int j = 1; j < count; j++) {
//                 idx[temp[j]]++;
//                 arr.get(temp[j - 1]).add(temp[j]);
//             }
//         }

//         System.out.println(Arrays.toString(idx));
//         ArrayList<Integer> caseArr = new ArrayList<>();
//         for (int i = 1; i < N + 1; i++) {
//             if (idx[i] == 0) {
//                 caseArr.add(i);
//             }
//         }

//         for (int caseNum : caseArr) {
//             System.out.println("caseNumber: " + caseNum);
//             Queue<Integer> q = new LinkedList<>();
//             q.add(caseNum);

//             StringBuilder sb = new StringBuilder();
//             int tempCnt = 0;
//             while (!q.isEmpty()) {
//                 int num = q.poll();
//                 sb.append(num + " ");
//                 tempCnt++;
//                 for (int number : arr.get(num)) {

//                     if (idx[number] - 1 == 0) {

//                         q.add(number);
//                     }
//                     idx[number] -= 1;


//                 }
//             }
//             System.out.println(sb);

//             System.out.println("@@@@@@@@@@@@");
//         }


//     }
// }
// a

import java.util.*;
 
public class Main {
 
    static ArrayList<Integer>[] list;
    static int[] indegree;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        //입력
        int n = scan.nextInt();
        int m = scan.nextInt();
 
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
 
        indegree = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int count = scan.nextInt();
            if(count == 0) continue;
            int s = scan.nextInt();
            for(int j = 0; j < count - 1; j++) {
                int e = scan.nextInt();
                indegree[e]++;
                list[s].add(e);
                s = e;
            }
        }

 
        ArrayList<Integer> result = topologySort(n);
        if(result.size() == n)  {
            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        } else {
            System.out.println("0");
        }
    }
 
    public static ArrayList<Integer> topologySort(int n) {
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
 
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int current = q.poll();
            result.add(current);
 
            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
        return result;
    }
}
