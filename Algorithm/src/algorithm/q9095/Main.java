package algorithm.q9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9095 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095
// DP
public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		int[] n = new int[t]; // 입력받을 정수
		int[] dp = new int[11];

		for (int i = 0; i < t; i++) {
			n[i] = Integer.parseInt(br.readLine()); // 정수 입력
		}
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]; // 계산 식
		}
		
		for (int i = 0; i < t; i++) {
			System.out.println(dp[n[i]]); // 결과 출력
		}

	}

}
