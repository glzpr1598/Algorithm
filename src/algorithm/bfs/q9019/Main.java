package algorithm.bfs.q9019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 9019 DSLR
 * https://www.acmicpc.net/problem/9019
 * BFS
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t; // 테스트케이스
		int[] a, b; // 시작값, 최종값
		
		t = Integer.parseInt(br.readLine());
		a = new int[t];
		b = new int[t];
		
		// 시작값, 최종값 입력
		for (int i = 0; i < t; i++) {
			String[] str = br.readLine().split(" ");
			a[i] = Integer.parseInt(str[0]);
			b[i] = Integer.parseInt(str[1]);
		}
		
		// 알고리즘 수행
		for (int i = 0; i < t; i++) {
			/* BFS */
			Queue<Integer> q = new LinkedList<>(); // BFS 큐
			String[] oper = new String[10000]; // 연산자 경로 저장
			boolean[] visited = new boolean[10000];
			
			q.add(a[i]); // BFS 큐에 추가
			visited[a[i]] = true; // 방문 표시
			oper[a[i]] = ""; // 연산자 경로
			while(!q.isEmpty()) {
				int here = q.remove();
				int there;
				
				// D
				there = (here * 2) % 10000;
				if (visited[there] == false) {
					q.add(there);
					visited[there] = true;
					oper[there] = oper[here] + "D"; // D 추가
					// 목표 도달 시 while 종료
					if (there == b[i]) {
						break;
					}
				}
				
				// S
				there = here - 1;
				if (there < 0) there = 9999;
				if (visited[there] == false) {
					q.add(there);
					visited[there] = true;
					oper[there] = oper[here] + "S"; // S 추가
					// 목표 도달 시 while 종료
					if (there == b[i]) {
						break;
					}
				}
				
				// L
				there = (here % 1000) * 10 + (here / 1000);
				if (visited[there] == false) {
					q.add(there);
					visited[there] = true;
					oper[there] = oper[here] + "L"; // L 추가
					// 목표 도달 시 while 종료
					if (there == b[i]) {
						break;
					}
				}
				
				// R
				there = (here % 10) * 1000 + (here / 10);
				if (visited[there] == false) {
					q.add(there);
					visited[there] = true;
					oper[there] = oper[here] + "R"; // R 추가
					// 목표 도달 시 while 종료
					if (there == b[i]) {
						break;
					}
				}
			}
			/* BFS 종료 */
			
			System.out.println(oper[b[i]]);
		}
		
	}
	
}
