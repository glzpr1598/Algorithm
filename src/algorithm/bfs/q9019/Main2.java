package algorithm.bfs.q9019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 
 * 9019 DSLR
 * https://www.acmicpc.net/problem/9019
 */
public class Main2 {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	private static int A, B;
	
	private static Queue<Integer> q;
	private static String[] path; // 연산자 경로
	private static boolean[] visited; // 방문 여부
	
	public static void main(String[] args) throws Exception {
		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			inputData();
			String result  = bfs();
			System.out.println(result);
		}
	}

	private static void inputData() throws Exception {
		String[] tokens = br.readLine().split(" ");
		A = Integer.parseInt(tokens[0]);
		B = Integer.parseInt(tokens[1]);
		// 큐, 배열 초기화
		q = new LinkedList<>();
		path = new String[10000];
		visited = new boolean[10000];
	}
	
	private static String bfs() {
		q.add(A);
		visited[A] = true;
		path[A] = "";
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			String currPath = path[curr];
			int next;
			
			// 결과 체크
			if (curr == B) {
				return currPath;
			}
			
			// D
			next = operD(curr);
			if (!visited[next]) {
				q.add(next);
				visited[next] = true;
				path[next] = currPath + "D";
			}
			
			// S
			next = operS(curr);
			if (!visited[next]) {
				q.add(next);
				visited[next] = true;
				path[next] = currPath + "S";
			}
			
			// L
			next = operL(curr);
			if (!visited[next]) {
				q.add(next);
				visited[next] = true;
				path[next] = currPath + "L";
			}
			
			// R
			next = operR(curr);
			if (!visited[next]) {
				q.add(next);
				visited[next] = true;
				path[next] = currPath + "R";
			}
		}
		
		return null;
	}

	private static int operD(int curr) {
		return (curr * 2) % 10000;
	}
	
	private static int operS(int curr) {
		int next = curr - 1;
		if (next < 0) {
			next = 9999;
		}
		return next;
	}
	
	private static int operL(int curr) {
		if (curr == 0)
			return 0;
		else
			return (curr * 10 % 10000) + (curr / 1000);
	}
	
	private static int operR(int curr) {
		if (curr == 0)
			return 0;
		else
			return (curr / 10) + (curr % 10 * 1000);
	}
	
}
