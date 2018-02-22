package algorithm.dp.q10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 10844 쉬운 계단 수
// https://www.acmicpc.net/problem/10844
// DP문제
public class Main {
	final static int DIV = 1000000000;	// 이 수로 나눈 나머지를 출력해야 하므로.(int 범위를 벗어남)
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// i번째 자릿수의 숫자 j까지 오는 경우의 수
		int[][] dp = new int[n][10];
		
		// 첫번째 수 초기화 (0은 안되므로)
		for (int i=0; i<10; i++) {
			if (i == 0)
				dp[0][i] = 0;
			else
				dp[0][i] = 1;
		}
		int ans = 9;	// for문에 안들어가면 결과가 9
		
		for (int i=1; i<n; i++) {
			ans = 0;	// for문에 들어오면 ans를 초기화해야 함
			for (int j=0; j<10; j++) {
				if (j == 0)		// 0은 앞의 수가 1인 경우만 존재
					dp[i][j] = dp[i-1][j+1] % DIV;
				else if (j == 9)	// 9는 앞의 수가 8인 경우만 존재
					dp[i][j] = dp[i-1][j-1] % DIV;
				else		// 나머지는 앞의 수가 -1, +1 인 경우를 더함
					dp[i][j] = ( dp[i-1][j-1] + dp[i-1][j+1] ) % DIV;
				
				if (i == n-1)	// 마지막 자릿수에서는 경우의 수를 모두 더함
					ans = ( ans + dp[i][j] ) % DIV;
			}
		}
		
		System.out.println(ans);
	}

}
