package algorithm.dp.q1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1912 연속합
 * https://www.acmicpc.net/problem/1912
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 수열의 개수
		int[] a; // 주어진 수열
		int[] dp; // i번째까지 연속합의 최댓값
		int result; //결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 수열의 개수 입력
		
		// 배열 크기 할당
		a = new int[n+1];
		dp = new int[n+1];
		
		// 수열 입력
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i+1] = Integer.parseInt(str[i]);
		}
		
		// 알고리즘
		result = a[1];
		for (int i = 1; i <= n; i++) {
			if (dp[i-1] < 0) {
				dp[i] = a[i];
			} else {
				dp[i] = dp[i-1] + a[i];
			}
			result = Math.max(result, dp[i]); // dp의 최댓값
		}
		System.out.println(result);
		
	}

}
