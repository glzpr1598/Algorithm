package algorithm.dp.q11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 11727 2xn 타일링2
// https://www.acmicpc.net/problem/11727
// dp
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int[] dp = new int[1001]; // 2xn 직사각형 채우는 경우의 수

		dp[1] = 1;
		dp[2] = 3;
		// 3부터는 dp[i] = (dp[i-2] * 2) + dp[i-1]
		for (int i = 3; i <= num; i++) {
			dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
		}
		System.out.println(dp[num]); 

	}

}
