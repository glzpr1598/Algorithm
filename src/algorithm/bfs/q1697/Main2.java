package algorithm.bfs.q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * 1697 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */
public class Main2 {
	
	static int N, K;
	static int result;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[100001];
	static int[] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		inputData();
		bfs();
		System.out.println(result);
	}

	private static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		N = Integer.parseInt(tokens[0]);
		K = Integer.parseInt(tokens[1]);
	}
	
	private static void bfs() {
		q.add(N);
		visited[N] = true;
		
		while (!q.isEmpty()) {
			int curr = q.remove();
			int next;
			
			if (curr == K) {
				result = time[curr];
				return;
			}
			
			// -1
			next = curr - 1;
			if (next >= 0 && !visited[next]) {
				q.add(next);
				time[next] = time[curr] + 1;
				visited[next] = true;
			}
			
			// +1
			next = curr + 1;
			if (next <= 100000 && !visited[next]) {
				q.add(next);
				time[next] = time[curr] + 1;
				visited[next] = true;
			}
			
			// *2
			next = curr * 2;
			if (next <= 100000 && !visited[next]) {
				q.add(next);
				time[next] = time[curr] + 1;
				visited[next] = true;
			}
		}
	}

}
