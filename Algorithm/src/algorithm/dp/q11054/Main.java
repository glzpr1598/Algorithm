package algorithm.dp.q11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 11054 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 * DP
 */
public class Main {

	public static void main(String[] args) throws Exception {

		int n; // 수열의 크기
		int[] a; // 주어진 수열
		int[] dpA; // 증가하는 수열 최대값
		int[] dpD; // 뒤에서부터 증가하는 수열 최대값
		int result = 0; // 결과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 수열 크기 입력
		// 배열 크기 할당
		a = new int[n+2];
		dpA = new int[n+2];
		dpD = new int[n+2];
		
		// 수열 입력
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i+1] = Integer.parseInt(str[i]);
		}
		
		// 알고리즘
		// LIS
		for (int i = 1; i <= n; i++) {
			dpA[i] = 1; // 기본값 1
			for (int j = 1; j < i; j++) {
				if (a[i] > a[j] && dpA[i] <= dpA[j]) {
					dpA[i]++;
				}
			}
		}
		// LIS 반대로
		for (int i = n; i >= 1; i--) {
			dpD[i] = 1;
			for (int j = n; j > i; j--) {
				if (a[i] > a[j] && dpD[i] <= dpD[j]) {
					dpD[i]++;
				}
			}
		}
		
		// dpA + dpD - 1 의 최댓값을 찾음.
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dpA[i] + dpD[i] -1);
		}
		System.out.println(result);
		
	}

}
