package algorithm.bfs.q13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 13549 숨바꼭질3
 * https://www.acmicpc.net/problem/13549
 * 
 * 방문한 시간 배열을 이용해 *2인 경우에는 현재시간과 같게 넣고,
 * -1, +1인 경우에는 현재시간+1을 넣는다.
 */
public class Main {
	
	static Queue<Integer> q = new LinkedList<>();  // 방문 지점
	static int[] visited = new int[100001];  // 방문한 시간
	static int[] dx = {-1, 1};
	
	public static void main(String[] args) throws IOException {
		
		int n, k;  // 수빈이와 동생의 위치
		int result;  // 최단 시간
		
		// 위치 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);  // 수빈이 위치
		k = Integer.parseInt(str[1]);  // 동생 위치
		
		// visited -1으로 초기화
		for(int i = 0; i <= 100000; i++) {
			visited[i] = -1;
		}
		
		// BFS
		result = bfs(n, k);
		
		System.out.println(result);
	}

	private static int bfs(int n, int k) {
		
		q.add(n);
		visited[n] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			int next = curr;
			int time = visited[curr];
			
			// 동생 위치에 다다르면
			if(curr == k) {
				return time;
			}
			
			// K*2
			next = curr * 2;
			if(next <= 100000 && visited[next] == -1) {
				q.add(next);
				visited[next] = time;
			}
			
			for(int i = 0; i < 2; i++) {
				// K-1, K+1
				next = curr + dx[i];
				
				// 범위 밖일 경우 continue
				if (next < 0 || next > 100000)
					continue;
				
				// 방문하지 않았다면
				if(visited[next] == -1) {
					q.add(next);
					visited[next] = time + 1;
				}
			}
		}
		
		return -1;
	}

}
