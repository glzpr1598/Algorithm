package algorithm.bfs.q1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 1261 알고스팟
 * https://www.acmicpc.net/problem/1261
 * 풀이)
 * BFS로 4방향을 탐색하면서 해당 지점의 벽을 부순 (기존)횟수보다 현재 횟수가 작으면 그 값으로 변경
 * 다익스트라 알고리즘(우선순위 큐)를 활요하면 더 간단하게 풀 수 있다고 함.
 */
public class Main {
	
	static int m, n;  // 가로, 세로 크기
	static int[][] map;  // 입력 지도
	static int[][] result;  // 벽을 부순 횟수 지도
	static Queue<MyNode> q = new LinkedList<>();  // 좌표 큐

	public static void main(String[] args) throws IOException {
		
		// 지도 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		map = new int[m][n];
		result = new int[m][n];
		for(int i = 0; i < n; i++) {  // 세로
			str = br.readLine().split("");
			for(int j = 0; j < m; j++) {  // 가로
				map[j][i] = Integer.parseInt(str[j]);
			}
		}
		
		// 카운트 최댓값으로 초기화
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		// 마지막 지점 횟수 출력
		System.out.println(result[m-1][n-1]);
		
	}

	private static void bfs() {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		// 초기위치 큐에 추가
		MyNode node = new MyNode(0, 0);
		q.add(node);
		result[0][0] = 0;  // 벽 부순 횟수
		
		while(!q.isEmpty()) {
			MyNode curr = q.remove();
			MyNode next;
			
			for(int i = 0; i < 4; i++) {
				// 다음 좌표, 벽 부순 횟수
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				int cnt = result[curr.x][curr.y];
				
				// 범위 검사
				if(x < 0 || x > m-1 || y < 0 || y > n-1)
					continue;
				
				if(cnt < result[x][y]) {  // 다음 지점의 횟수보다 현재 횟수가 작으면 탐색
					// 다음 지점이 벽이면 cnt++
					if(map[x][y] == 1) {
						cnt++;
					}
					
					// 큐에 추가
					next = new MyNode(x, y);
					q.add(next);
					result[x][y] = cnt;  // 벽 부순 횟수
				}
			}
		}
	}
	
}

class MyNode {
	
	int x, y;

	public MyNode() {}
	
	public MyNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}