package algorithm.dp.q11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 11055 가장 큰 증가 부분 수열
 * https://www.acmicpc.net/problem/11055
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
		int n; // 수열의 개수
		int[] map; // 주어진 수열
		int[] dp; // i까지의 증가 수열의 합
		int result = 0; // 결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 수열의 개수 입력
		map = new int[n+1];
		dp = new int[n+1];
		
		// map에 수열 저장
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			map[i+1] = Integer.parseInt(str[i]);
		}
		
		// 알고리즘
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				if (map[i] > map[j] && dp[i] < dp[j]) { // 증가하는 수열이고, 최대값이 증가한다면
					dp[i] = dp[j];
				}
			}
			dp[i] += map[i]; // 마지막에 자신의 수를 더함
			result = Math.max(result, dp[i]); // 결과 : dp의 최대값
		}
		System.out.println(result);
		
	}

}
