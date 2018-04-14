package algorithm.dfs.q1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Main {
	
	static int n, m, v; // 정점 개수, 간선 개수, 시작 번호
	static boolean[][] edge; // 간선 연결 행렬
	static boolean[] visited; // 방문 여부
	static StringBuilder result; // 방문 경로
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n, m, v 입력
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		
		// 행렬 크기 할당
		edge = new boolean[n + 1][n + 1];
		
		// 간선 행렬 입력
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			edge[a][b] = true;
			edge[b][a] = true;
		}
		
		// DFS
		visited = new boolean[n + 1];
		result = new StringBuilder();
		dfs(v);
		System.out.println(result);
		
		// BFS
		visited = new boolean[n + 1];
		result = new StringBuilder();
		bfs(v);
		System.out.println(result);
		
	}
	
	public static void dfs(int v) {
		visited[v] = true; // 방문 표시
		result.append(v + " "); // 경로 추가
		for (int i = 1; i <= n; i++) {
			// 연결되어있고, 방문하지 않은 경우
			if (edge[v][i] == true && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v); // 시작값 추가
		visited[v] = true; // 방문 표시
		result.append(v + " "); // 경로 추가
		
		while (!q.isEmpty()) {
			int here = q.remove(); // 헤드 제거
			int there;
			
			for (there = 1; there <= n; there++) {
				// 연결되어있고, 방문하지 않은 경우
				if (edge[here][there] == true && visited[there] == false) {
					q.add(there); // 큐에 추가
					visited[there] = true; // 방문 표시
					result.append(there + " "); // 경로 추가
				}
			}
		}
	}

}
