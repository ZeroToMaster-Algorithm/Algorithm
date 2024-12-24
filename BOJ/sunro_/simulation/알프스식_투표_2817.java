package Array.gold.simulation;

import java.util.Scanner;

public class 알프스식_투표_2817 {

    static class Score{
        double score;
        int staffIdx;
        Score(int staffIdx, double score) {
            this.staffIdx = staffIdx;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleCnt = sc.nextInt();
        int N = sc.nextInt();

        boolean[] staffArr = new boolean[26];
        int[] voteArr = new int[26];
        int validatedCnt = 0;

        double cutLine = peopleCnt * 0.05;
        while (N-- > 0) {
            String target = sc.next();
            int voteCnt = sc.nextInt();
            if (voteCnt >= cutLine) {
                staffArr[target.charAt(0)-'A'] = true;
                voteArr[target.charAt(0)-'A'] = voteCnt;
                validatedCnt++;
            }
        }

        Score[] scores = new Score[validatedCnt*14];
        int scoreIdx = 0;
        for (int i = 0; i < 26; i++) {
            if(staffArr[i]) {
                for (int j = 0; j <= 14; j++) {
                    scores[scoreIdx++] = new Score(i, (double) voteArr[i]/j);
                }
            }
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[i].score > scores[j].score) {
                    Score temp = scores[i];
                    for (int k = i; k >j; k--) {
                        scores[k] = scores[k-1];
                    }
                    scores[j] = temp;
                }
            }
        }

        int[] ans = new int[26];
        for (int i = 0; i < 14; i++)
            ans[scores[i].staffIdx]++;

        // 4. 스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력한다.
        for (int i = 0; i < 26; i++) {
            if (staffArr[i])
                System.out.println((char)(i + 'A') + " " + ans[i]);
        }

    }


}
