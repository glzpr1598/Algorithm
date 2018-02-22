package algorithm.q11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 11053 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 수열의 개수
		int[] map; // 입력받을 수열
		int[] dp; // i번째 수를 포함하는! 최대 수열 개수
		int result = 0; // 최대값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수열의 개수 입력
		n = Integer.parseInt(br.readLine());
		// 배열 크기 정의
		map = new int[n+1];
		dp = new int[n+1];

		// 수열 입력
		String[] str = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(str[i-1]);
		}
		
		// 알고리즘
		// 현재수보다 작은 수 중에서 dp의 최댓값을 찾아서 1더함
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (map[i] > map[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
					result = Math.max(dp[i], result);
				}
			}
		}
		
		// dp중 최댓값 출력
		System.out.println(result);
		
	}

}
