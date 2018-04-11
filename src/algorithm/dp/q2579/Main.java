package algorithm.dp.q2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 2579 계단 오르기
 * https://www.acmicpc.net/problem/2579
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 계단 개수
		int[] score; // 계단 점수
		int[][] dp; // j번째 계단을 연속 i번 밟았을 때 점수 최댓값
		int result; // 결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 계단 개수 입력
		n = Integer.parseInt(br.readLine());
		score = new int[n+1];
		dp = new int[3][n+1];
		
		// 계단 점수 입력
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		// 알고리즘
		// i번째 계단을 안밟는 경우 최댓값 : i-1번째 계단을 연속 1번 밟았을 때와 연속 2번 밟았을 때의 최댓값
		// i번째 계단을 연속 1번 밟았을 경우 최댓값 : i-1번째 계단을 안밟았을 경우 최댓값 + 현재 계단 점수
		// i번째 계단을 연속 2번 밟았을 경우 최댓값 : i-1번째 계단을 연속 1번 밟았을 경우 최댓값 + 현재 계단 점수
		for (int i = 1; i <= n; i++) {
			dp[0][i] = dp[1][i-1] > dp[2][i-1] ? dp[1][i-1] : dp[2][i-1];
			dp[1][i] = dp[0][i-1] + score[i];
			dp[2][i] = dp[1][i-1] + score[i];
		}
		
		// 마지막 계단은 밟아야 하므로 연속 1번과 연속 2번 중 최댓값
		result = dp[1][n] > dp[2][n] ? dp[1][n] : dp[2][n]; 
		System.out.println(result);
	}

}
