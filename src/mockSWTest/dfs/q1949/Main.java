package mockSWTest.dfs.q1949;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* SW Expert Academy
 * 1949 등산로 조성
 * https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
 * DFS
 */
public class Main {
	
	static int T; // 테스트케이스
	static int N, K; // 지도 크기, 최대 공사 깊이
	static int[][] map; // 산 높이 지도
	static int top; // 산 최대 높이
	// row, column 이동값(시계방향)
	static int[] pr = {-1, 0, 1, 0};
	static int[] pc = {0, 1, 0, -1};
	static int result; // 결과

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 입력
		T = Integer.parseInt(br.readLine());
		
		// 테스트케이스별
		for (int testcase = 1; testcase <= T; testcase++) {
			// N, K 입력
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			
			map = new int[N][N];
			
			// map 입력
			top = 0; // 산 최대 높이
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					// 최대 높이 찾기
					top = map[i][j] > top ? map[i][j] : top;  
				}
			}
			
			result = 0;
			
			// 산을 깎지 않았을 때 최대값 구하기
			solve();
			
			// 최대 K만큼 하나를 깎는 경우
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 1; d <= K; d++) {
						map[i][j] -=  d; // d만큼 깎음
						solve();
						map[i][j] += d; // 다시 원상태로
					}
				}
			}
			
			System.out.println("#" + testcase + " " + result);
			
		}

	}
	
	// 최대 높이에서 dfs 수행
	public static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == top) {
					int cur = dfs(i, j);
					result = cur > result ? cur : result; 
				}
			}
		}
	}
	
	// DFS
	public static int dfs(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + pr[i];
			int nc = c + pc[i];
			// 지도를 벗어나지 않는 경우
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				// 이동하려는 곳이 더 낮은 경우
				if (map[nr][nc] < map[r][c]) {
					int cur = dfs(nr, nc);
					// 최대 길이를 찾음
					count = cur > count ? cur : count;
				}
			}
		}
		// 최대 길이에 +1 하여 반환
		return count + 1;
	}

}
