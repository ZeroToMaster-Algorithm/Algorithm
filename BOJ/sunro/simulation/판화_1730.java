package Array.gold.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 판화_1730 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        String order = br.readLine();

        Robot robot = new Robot(N); // N을 전달하여 Robot 생성
        for (int i = 0; i < order.length(); i++) {
            robot.move(order.charAt(i), robot.curPos);
        }
        robot.print(robot.visitedRow, robot.visitedCol);
    }

    static class Robot {
        int[] curPos = new int[]{0, 0};
        boolean[][] visitedRow;
        boolean[][] visitedCol;

        public Robot(int n) {
            this.visitedRow = new boolean[n][n];
            this.visitedCol = new boolean[n][n];
        }

        public void move(char direction, int[] curPos) {
            if (direction == 'L') {
                if (curPos[1] - 1 < 0) {
                    return;
                } else {
                    visitedRow[curPos[0]][curPos[1]] = true;
                    curPos[1]--;
                    visitedRow[curPos[0]][curPos[1]] = true;
                }
            }
            if (direction == 'R') {
                if (curPos[1] + 1 >= N) {
                    return;
                } else {
                    visitedRow[curPos[0]][curPos[1]] = true;
                    curPos[1]++;
                    visitedRow[curPos[0]][curPos[1]] = true;
                }
            }
            if (direction == 'U') {
                if (curPos[0] - 1 < 0) {
                    return;
                } else {
                    visitedCol[curPos[0]][curPos[1]] = true;
                    curPos[0]--;
                    visitedCol[curPos[0]][curPos[1]] = true;
                }
            }
            if (direction == 'D') {
                if (curPos[0] + 1 >= N) {
                    return;
                } else {
                    visitedCol[curPos[0]][curPos[1]] = true;
                    curPos[0]++;
                    visitedCol[curPos[0]][curPos[1]] = true;
                }
            }
        }

        public void print(boolean[][] row, boolean[][] cul) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (row[i][j] && cul[i][j]) {
                        System.out.print('+');
                    } else if (row[i][j] && !cul[i][j]) {
                        System.out.print('-');
                    } else if (cul[i][j] && !row[i][j]) {
                        System.out.print('|');
                    } else {
                        System.out.print('.');
                    }
                }
                System.out.println();
            }
        }
    }
}
