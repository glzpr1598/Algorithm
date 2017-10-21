package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 14501 퇴사
// https://www.acmicpc.net/problem/14501
// 미해결, dfs 함수 수정 필요.
public class Q14501 {
	
	static int[] t;
	static int[] p;
	static int[] visited;
	static int ans = 0;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		t = new int[n+1];		// 상담 기간
		p = new int[n+1];		// 상담 수익
		visited = new int[n+1];	// 방문 여부
		
		
		// t, p 배열 입력
		for (int i=1; i<=n; i++) {
			String[] str = br.readLine().split(" ");
			t[i] = Integer.parseInt(str[0]);
			p[i] = Integer.parseInt(str[1]);
		}
		
		dfs(1, 0);
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int day, int sum) {
		// 현재 day에 상담을 하지 않는 경우
		if (day + 1 > n) {	// 마지막 날인 경우
			if (t[day] == 1)
				sum += p[day];
			ans = Math.max(ans, sum);
			return;
		}
		dfs(day + 1, sum);
		
		// 현재 day에 상담을 하는 경우
		if (day + t[day] > n) {		// 다음 날짜가 n을 초과할 경우 종료
			ans = Math.max(ans, sum);
			return;
		}
		sum += p[day];		// 수익 더함
		dfs(day + t[day], sum);	// t[day] 더한 날의 dfs 수행
			
	}

}
