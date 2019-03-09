package algorithm.bfs.q13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 숨바꼭질 4
 * https://www.acmicpc.net/problem/13913
 */
public class Main2 {
	
	static int N, K;
	static int result; // 최단 시간
	static Queue<Integer> q = new LinkedList<>();
	static Queue<Integer> time = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	static int[] parent = new int[100001]; // 어디에서 왔는지(경로를 구하기 위해)

	public static void main(String[] args) throws IOException {

		inputData();
		bfs();
		
		// 최단 시간 출력
		System.out.println(result);
		
		// 경로 출력
		List<Integer> path = new ArrayList<>();
		int i = K;
		while (i != -1) {
			path.add(i);
			i = parent[i];
		}
		for (int j=path.size()-1; j >= 0; j--) {
			System.out.print(path.get(j) + " ");
		}
	}

	private static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		N = Integer.parseInt(tokens[0]);
		K = Integer.parseInt(tokens[1]);
	}

	private static void bfs() {
		q.add(N);
		time.add(0);
		visited[N] = true;
		parent[N] = -1; // 시작점은 이전경로 -1로 정의
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			int currTime = time.remove();
			int next;
			int nextTime = currTime + 1;
			
			// -1
			next = curr - 1;
			if (next >= 0 && !visited[next]) {
				q.add(next);
				time.add(nextTime);
				visited[next] = true;
				parent[next] = curr;
				if (isEnd(next)) {
					result = nextTime;
					return;
				}
			}
			
			// +1
			next = curr + 1;
			if (next <= 100000 && !visited[next]) {
				q.add(next);
				time.add(nextTime);
				visited[next] = true;
				parent[next] = curr;
				if (isEnd(next)) {
					result = nextTime;
					return;
				}

			}
			
			// *2
			next = curr * 2;
			if (next <= 100000 && !visited[next]) {
				q.add(next);
				time.add(nextTime);
				visited[next] = true;
				parent[next] = curr;
				if (isEnd(next)) {
					result = nextTime;
					return;
				}

			}
		}
	}
	
	private static boolean isEnd(int next) {
		if (next == K)
			return true;
		else 
			return false;
	}
}
