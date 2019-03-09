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
	private static String result;
	
	private static Queue<Integer> q;
	private static String[] path;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			inputData();
			bfs();
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
	
	private static void bfs() {
		q.add(A);
		visited[A] = true;
		path[A] = "";
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			String currPath = path[curr];
			int next;
			String nextPath;
			
			// D
			next = operD(curr);
			
			// S
			next = operS(curr);
			
			// L
			next = operL(curr);
			
			// R
			next = operR(curr);
		}
	}

	private static int operD(int curr) {
		int next = curr * 2;
		if (next > 9999) {
			next = next % 10000;
		}
		return next;
	}
	
	private static int operS(int curr) {
		int next = curr - 1;
		if (next < 0) {
			next = 9999;
		}
		return next;
	}
	
	private static int operL(int curr) {
		String currString = intToString(curr);
	}
	
	private static int operR(int curr) {
		
	}
	
	private static String intToString(int num) {
		if (num < 10) {
			return "000" + num;
		} else if (num < 100) {
			return "00" + num;
		} else if (num < 1000) {
			return "0" + num;
		} else {
			return Integer.toString(num);
		}
	}

}
