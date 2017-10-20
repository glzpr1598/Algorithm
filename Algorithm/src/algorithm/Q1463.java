package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1463 1로 만들기
// https://www.acmicpc.net/problem/1463
// DP 이용
public class Q1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 1부터 n까지 가는 최소 연산
		int[] dp = new int[n+1];
		
		dp[1] = 0;
		
		// dp[i]는 dp[i-1], dp[i/2], dp[i/3] 중 최솟값에 1을 더함
		for (int i=2; i<=n; i++)
		{
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(dp[n]);
	}
}



// 처음 시도 : bfs 이용 -> 시간 초과
/*
public class Q1463 {

	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		bfs(n);
		
	}
	
	public static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> d = new LinkedList<>();	// bfs 깊이도 같이 저장
		q.add(cur);
		d.add(0);
		
		int count = 0;	// bfs 깊이 카운트
		while(true)
		{
			int here = q.remove();
			count = d.remove();
			
			if (here == 1)	// 큐에서 빼낸 숫자가 1이면 종료
			{
				System.out.println(count);	// 결과 출력
				break;
			}
			
			count++;
			// 큐에 숫자를 넣을 때 깊이(카운트)도 같이 저장
			if (here % 3 == 0)
			{
				q.add(here/3);
				d.add(count);
			}
			if (here % 2 == 0)
			{
				q.add(here/2);
				d.add(count);
			}
			q.add(here-1);
			d.add(count);
		}
	}

}
*/