
// H-INDEX란
// 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
// h의 최댓값이 H-INDEX이다.

import java.util.Arrays;

public class HINDEX_42747 {
	public static void main(String[] args) {
		int[] citations = new int[] {5,6,7,8 };
		solution(citations);
	}

	private static int solution(int[] citations) {
		// 정렬 한다.
		Arrays.sort(citations);
		int len = citations.length;

        for (int i = 0; i < len; i++) {
            // 현재 논문이 인용된 횟수가 hIndex보다 크거나 같은지 확인
            int hIndex = len - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
		
		return 0;
	}
}
