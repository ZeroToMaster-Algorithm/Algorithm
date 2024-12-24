package Array.gold.simulation;

import java.util.Scanner;

public class 사탕_게임_3085 {

    //1.가능한 모든 쌍의 캔디를 서로 교환
    //2. 교환 상태에서 가장 긴 행/열을 찾음
    //3. 교환 사탕을 원복
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = findMaxInRow(j, n, map, i, ans);
                ans = findMaxInCol(i, n, map, j, ans);
            }
            if(ans==n) break;
        }
        System.out.println(ans);
    }

    private static int findMaxInCol(int i, int n, char[][] map, int j, int ans) {
        if (i + 1 < n && map[i][j] != map[i + 1][j]) {
            swap(map, i, j, i + 1, j);
            ans = Math.max(ans, Math.max(findMaxCol(map), findMaxRow(map)));
            swap(map, i, j, i + 1, j);
        }
        return ans;
    }

    private static int findMaxInRow(int j, int n, char[][] map, int i, int ans) {
        if (j + 1 < n && map[i][j] != map[i][j + 1]) {
            swap(map, i, j, i, j + 1);
            ans = Math.max(ans, Math.max(findMaxCol(map), findMaxRow(map)));
            swap(map, i, j, i, j + 1);
        }
        return ans;
    }

    public static int findMaxRow(char[][] map) {
        int N = map.length;
        int maxRow = 0;
        for (char[] chars : map) {
            int len = 1;
            for (int c = 1; c < N; c++) {
                if (chars[c] == chars[c - 1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len); //len값 초기화되기전에 업데이트
        }
        return maxRow;
    }

    public static int findMaxCol(char[][] map) {
        int N = map.length;
        int maxrow = 0;
        for (int c = 0; c < N; c++) {
            int len = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r-1][c]) {
                    len++;
                } else {
                    maxrow = Math.max(maxrow, len);
                    len = 1;
                }
            }
            maxrow = Math.max(maxrow, len);
        }
        return maxrow;
    }


    public static void swap(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }


}
