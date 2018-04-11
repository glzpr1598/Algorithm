package algorithm.dp.q11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11722 가장 긴 감소하는 부분 수열
// https://www.acmicpc.net/problem/11722
// DP
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 수열의 개수
		int[] a; // 주어진 수열
		int[] dp; // i까지의 감소 수열 길이 최댓값
		int result = 0; // 결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 개수 입력
		// 배열 크기 할당
		a = new int[n+1];
		dp = new int[n+1];
		
		// 수열 입력
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i+1] = Integer.parseInt(str[i]);
		}
		
		// 알고리즘
		for (int i = 1; i <= n; i++) {
			dp[i]++; // 기본값 1
			for (int j = 1; j < i; j++) {
				if (a[i] < a[j] && dp[i] <= dp[j]) {
					dp[i]++;
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
	}

}
