package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9465 스티커
// https://www.acmicpc.net/problem/9465
// DP
public class Q9465 {

	public static void main(String[] args) throws Exception {
		
		int t; // 테스트케이스
		int n; // 열 개수
		int[][] socre; // 스티커 점수
		int[][] dp; // 경우의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		
		// 테스트케이스별 실행
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine()); // 열 개수 입력
			dp = new int[n+1][2]; // dp 크기 지정
			
			
		}
		
	}

	// 3개의 숫자 중 최대값
	int max(int a, int b, int c) {
		int result;
		result = a > b ? a : b;
		result = result > c ? result : c;
		return result;
	}

}
