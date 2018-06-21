package algorithm.bfs.q2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 2206 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 * 풀이)
 * 큐에 (x좌표, y좌표, 거리, 벽 부쉈는지 여부)를 담아서 BFS 탐색한다.
 * 벽을 부수지 않았으면 벽으로도 이동할 수 있고,
 * 벽을 부쉈으면 벽으로는 이동할 수 없도록 한다.
 * 주의)
 * visited를 벽을 부수지 않고 방문했는지, 부수고 방문했는지로 나눠야 한다. -> 3차원 배열 사용
 */
public class Main {

	static int n, m;  // 지도 크기
	static int[][] map;  // 입력받을 지도
	static boolean[][][] visited;  // 벽을 부수지 않고 방문했는지(0), 벽을 부수고 방문했는지(1) 
	static Queue<Info> q = new LinkedList<>();
	static int result = -1;  // 최단 거리(결과)
	
	// 12시부터 시계방향
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		// n, m 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		n = Integer.parseInt(strArr[0]);
		m = Integer.parseInt(strArr[1]);
		
		// 배열 할당
		map = new int[n][m];
		visited = new boolean[n][m][2];
		
		// 지도 입력
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		
		System.out.println(result);
		
	}

	private static void bfs() {
		
		Info info = new Info(0, 0, 1, 0);
		q.add(info);
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Info curr = q.remove();
			Info next;
			
			// 도착 여부 검사
			if(curr.r == n-1 && curr.c == m-1) {
				result = curr.d;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextR = curr.r + dr[i];
				int nextC = curr.c + dc[i];
				int nextD = curr.d + 1;
				
				// 범위 검사
				if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)
					continue;
				
				next = new Info(nextR, nextC, nextD, curr.crashed);
				
				// 벽이 아닌 경우 && 방문하지 않은 경우
				if(map[nextR][nextC] == 0 && !visited[nextR][nextC][curr.crashed]) {
					q.add(next);
					visited[nextR][nextC][curr.crashed] = true;
				} else {  // 벽인 경우
					// 벽을 부순적이 없는 경우(벽은 한번만 부술 수 있으므로 방문여부 체크할 필요 없음)
					if(curr.crashed == 0) {
						next.crashed = 1;
						q.add(next);
						visited[nextR][nextC][next.crashed] = true;
					}
				}
				
			}
		}
		
	}

}

class Info {
	int r, c, d;  // 위치, 최단거리
	int crashed;  // 벽을 안부쉈는지(0), 부쉈는지(1)

	public Info(int r, int c, int d, int crashed) {
		this.r = r;
		this.c = c;
		this.d = d;
		this.crashed = crashed;
	}
}
