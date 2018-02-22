package algorithm.dp.q11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 11052 붕어빵 판매하기
// https://www.acmicpc.net/problem/11052
// DP
/*
 * dp[n]을 n개의 붕어빵을 팔 때의 최댓값이라 하면
 * dp[n]은 
 * dp[n-1] + 붕어빵 1개 세트 가격,
 * dp[n-2] + 붕어빵 2개 세트 가격, 
 * dp[n-3] + 붕어빵 3개 세트 가격, 
 * ...
 * dp[0] + 붕어빵 n개 세트 가격 
 * 중의 최댓값이다.
 */
public class Main {

	public static void main(String[] args) throws Exception {

		// 붕어빵 수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 변수 선언
		int n = Integer.parseInt(br.readLine()); // 붕어빵 수
		int[] p = new int[n + 1]; // 세트메뉴 가격
		int[] dp = new int[n + 1]; // n개까지의 최대 수익
		
		// p 입력
		String[] str = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(str[i - 1]);
		}

		// 알고리즘
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
			}
		}

		// 출력
		System.out.println(dp[n]);

	}

}
