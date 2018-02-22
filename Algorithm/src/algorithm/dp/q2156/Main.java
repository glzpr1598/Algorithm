package algorithm.dp.q2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2156 포도주 시식
// https://www.acmicpc.net/problem/2156
// DP
public class Main {

	public static void main(String[] args) throws Exception {
		
		int n; // 포도주 개수
		int[] map; // 포도주의 양
		int[][] dp; // i번째잔까지의 최대값(j번 연속 마심)
		int result; // 결과
		
		// 포도주 개수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 배열 크기 지정
		map = new int[n+1];
		dp = new int[n+1][3];
		
		// 포도주 양 입력
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		// 초기값 설정
		dp[1][0] = 0;
		dp[1][1] = map[1];
		
		// 알고리즘
		for (int i = 2; i <= n; i++) {
			dp[i][0] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + map[i];
			dp[i][2] = dp[i-1][1] + map[i];
		}
		result = max(dp[n][0], dp[n][1], dp[n][2]);

		System.out.println(result);
		
	}

	static int max(int a, int b, int c) {
		int result;
		result = a > b ? a : b;
		result = result > c ? result : c;
		return result;
	}
}
