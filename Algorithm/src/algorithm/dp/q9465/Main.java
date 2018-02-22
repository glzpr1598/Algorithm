package algorithm.dp.q9465;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9465 스티커
// https://www.acmicpc.net/problem/9465
// DP
public class Main {

	public static void main(String[] args) throws Exception {

		int t; // 테스트케이스
		int n; // 열 개수
		int[][] score; // 스티커 점수
		int[][] dp; // 경우의 수
		int[] result; // 결과

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		result = new int[t];

		// 테스트케이스별 실행
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine()); // 열 개수 입력
			score = new int[n + 1][2]; // score 크기 지정
			dp = new int[n + 1][2]; // dp 크기 지정

			// 스티커 점수 배열에 입력
			for (int j = 0; j < 2; j++) {
				String[] str = br.readLine().split(" ");
				for (int k = 1; k <= n; k++) {
					score[k][j] = Integer.parseInt(str[k - 1]);
				}
			}

			// 초기값
			dp[1][0] = score[1][0];
			dp[1][1] = score[1][1];
			// 알고리즘
			for (int j = 2; j <= n; j++) {
				dp[j][0] = max(dp[j - 2][0], dp[j - 2][1], dp[j - 1][1]) + score[j][0];
				dp[j][1] = max(dp[j - 2][0], dp[j - 2][1], dp[j - 1][0]) + score[j][1];
			}
			result[i] = max(dp[n][0], dp[n][1]); // 각 테스트케이스별 결과값

		}
		
		// 모든 결과값 출력
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}

	}

	// 더 큰 수 반환
	static int max(int a, int b) {
		return a > b ? a : b;
	}

	// 3개의 숫자 중 최대값 반환
	static int max(int a, int b, int c) {
		int result;
		result = a > b ? a : b;
		result = result > c ? result : c;
		return result;
	}

}
