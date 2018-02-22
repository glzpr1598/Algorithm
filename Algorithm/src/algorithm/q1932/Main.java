package algorithm.q1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1932 숫자삼각형
// https://www.acmicpc.net/problem/1932
// DP 문제
public class Main {
	public static void main(String[] agrs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 첫번째 줄 입력
		
		int ans = 0;
		int[][] tri = new int[n+1][n+1];	// 숫자 삼각형
		int[][] dp = new int[n+1][n+1];		// (i, j)까지 합의 최대
		for (int i=1; i<=n; i++)
		{
			String[] str = br.readLine().split(" ");
			for (int j=1; j<=i; j++)
			{
				tri[i][j] = Integer.parseInt(str[j-1]);	// 숫자 입력 받음
				
				dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);	// DP
				
				if (i == n)	// 마지막 줄에서
				{
					if (ans < dp[i][j]) ans = dp[i][j];	// 최댓값 찾음
				}
			}
		}		
		System.out.println(ans);
	}

}
