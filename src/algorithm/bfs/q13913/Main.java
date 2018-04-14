package algorithm.bfs.q13913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 13913 숨바꼭질4
 * https://www.acmicpc.net/problem/13913
 * BFS
 */
public class Main {
	
	static int N; // 수빈이의 위치
	static int K; // 동생의 위치
	static Queue<Integer> q = new LinkedList<>();
	static int[] sec = new int[100001]; // 몇 초 후에 만나는지
	static boolean[] visited = new boolean[100001]; // 방문 여부
	static int[] parent = new int[100001]; // 어디에서 왔는지(방문 경로를 위해)
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N, K 입력
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		// BFS 수행
		bfs(N, K);
		
		// 시간 출력
		System.out.println(sec[K]);
		
		// 경로 출력
		ArrayList<Integer> list = new ArrayList<>();
		int temp = K;
		while(temp != -1) {			
			list.add(temp);	
			temp = parent[temp];
		}
		
		for (int i = list.size() - 1 ; i > 0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print(list.get(0)); // 마지막에는 " " 출력 안하기 위해
		
	}
	
	public static void bfs(int N, int K) {
		q.add(N); // 큐에 첫지점 추가
		parent[N] = -1; // 부모가 없음을 표시
		visited[N] = true; // 방문 표시
		while(!q.isEmpty()) {
			int here = q.remove(); // 헤드 제거
			int there; // 다음지점
			
			// -1 이동
			there = here - 1;
			if (there >= 0 && visited[there] == false) { // 범위를 벗어나지 않고 방문하지 않은 경우
				q.add(there);
				parent[there] = here; // 어디에서 왔는지
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
				parent[there] = here; // 어디에서 왔는지
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
				parent[there] = here; // 어디에서 왔는지
				visited[there] = true;
				sec[there] = sec[here] + 1;
				if (here-1 == K) {
					return;
				}
			}
		}
	}

}
