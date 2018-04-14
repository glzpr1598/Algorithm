package algorithm.bfs.q1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1697 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 * BFS
 */
public class Main {
	
	static int N; // 수빈이의 위치
	static int K; // 동생의 위치
	static Queue<Integer> q = new LinkedList<>();
	static int[] sec = new int[100001]; // 몇 초 후에 만나는지
	static boolean[] visited = new boolean[100001]; // 방문 여부
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N, K 입력
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		// BFS 수행
		bfs(N, K);
		
		// 결과 출력
		System.out.println(sec[K]);
		
	}
	
	public static void bfs(int N, int K) {
		q.add(N); // 큐에 첫지점 추가
		visited[N] = true; // 방문 표시
		while(!q.isEmpty()) {
			int here = q.remove(); // 헤드 제거
			int there; // 다음지점
			
			// -1 이동
			there = here - 1;
			if (there >= 0 && visited[there] == false) { // 범위를 벗어나지 않고 방문하지 않은 경우
				q.add(there);
				visited[there] = true;
				sec[there] = sec[here] + 1; // there 까지 가는 데 걸린 시간은 이전 시간 + 1
				// 동생의 위치가 되면 종료
				if (there == K) {
					return;
				}
			}
			// +1 이동
			there = here + 1;
			if (there <= 100000 && visited[there] == false) {
				q.add(there);
				visited[there] = true;
				sec[there] = sec[here] + 1;
				if (there == K) {
					return;
				}
			}
			// *2 이동
			there = here * 2;
			if (there <= 100000 && visited[there] == false) {
				q.add(there);
				visited[there] = true;
				sec[there] = sec[here] + 1;
				if (here-1 == K) {
					return;
				}
			}
		}
	}

}
