package algorithm.dp.q2193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2193 이친수
// https://www.acmicpc.net/problem/2193
// DP
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 입력받을 수
		long[][] dp; // i번째 자리 j숫자의 경우의 수
		long result; // 결과

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dp = new long[n + 1][2];
		dp[1][0] = 0; // 이친수는 0으로 시작하지 않음.
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 0은 앞의 수가 뭐가와도 상관없음.
			dp[i][1] = dp[i - 1][0]; // 1은 앞의 수가 0인 경우에만 올 수 있음.
		}

		result = dp[n][0] + dp[n][1];
		System.out.println(result);

	}

}
