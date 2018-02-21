package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11057 오르막 수
// https://www.acmicpc.net/problem/11057
// DP
public class Q11057 {

	static final int DIV = 10007; // 나눌 수
	
	public static void main(String[] args) throws Exception {

		int n; // 입력 받은 수
		int result = 0; // 결과
		int[][] dp; // i번째 자리의 수 j까지 올 수 있는 경우의 수
		
		// 숫자 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1][10]; // dp 배열 크기 지정
		
		// 첫번째 자리에 올 수 있는 경우의 수(1) 초기화
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// n이 2 이상인 경우부터
		// 바로 앞자리에서 현재 수보다 작거나 같은 수의 경우를 모두 합침
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % DIV;
				}
			}
		}
		
		// 결과는 n번째 dp의 합
		for (int i = 0; i < 10; i++) {
			result = (result + dp[n][i]) % DIV;
		}
		
		System.out.println(result);
		
	}

}
