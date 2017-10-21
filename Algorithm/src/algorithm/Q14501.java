package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 14501 퇴사
// https://www.acmicpc.net/problem/14501
// 
public class Q14501 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] t = new int[n+1];		// 상담 기간
		int[] p = new int[n+1];		// 상담 수익
		
		// t, p 배열 입력
		for (int i=1; i<=n; i++) {
			String[] str = br.readLine().split(" ");
			t[i] = Integer.parseInt(str[0]);
			p[i] = Integer.parseInt(str[1]);
		}
		
		
	}

}
