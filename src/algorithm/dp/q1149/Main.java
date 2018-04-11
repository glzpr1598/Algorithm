package algorithm.dp.q1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1149 RGB거리
// https://www.acmicpc.net/problem/1149
// DP
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");	// 첫째줄 입력
		int n = Integer.parseInt(str[0]);	// 집 수
		
		// 집마다의 RGB 비용
		int[][] p = new int[n+1][3];
		
		// i번째 집을 j로 칠했을 때까지의 최소비용
		int[][] dp = new int[n+1][3];
		
		// RGB 입력
		for(int i=1; i<=n; i++) {
			str = br.readLine().split(" ");
			p[i][0] = Integer.parseInt(str[0]);
			p[i][1] = Integer.parseInt(str[1]);
			p[i][2] = Integer.parseInt(str[2]);
		}
		
		// DP
		for (int i=1; i<=n; i++)
		{
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + p[i][0]; 
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + p[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + p[i][2];
		}
		
		// 마지막 n번째 집에서 3가지 경우 중 최솟값
		int ans = min(dp[n][0], dp[n][1], dp[n][2]);
		
		System.out.println(ans);
		
	}
	
	// 세 수중 최솟값 리턴
	public static int min(int r, int g, int b) {
		int ans = r;
		if (g < ans) ans = g;
		if (b < ans) ans = b;
		
		return ans;
	}
}

