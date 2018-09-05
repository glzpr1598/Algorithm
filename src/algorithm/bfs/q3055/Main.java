package algorithm.bfs.q3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 3055 탈출
 * https://www.acmicpc.net/problem/3055
 * 풀이)
 * 물이 차서 지도가 변하기 때문에 현재 상태의 지도도 큐에 담는다.
 * 물이 찰 예정인 곳은 고슴도치가 갈 수 없기 때문에 물이 차는 것을 먼저 수행한다.
 */
public class Main {

	static int r, c;  // 지도 크기
	static int startR, startC;  // 고슴도치 위치(시작)
	static int endR, endC;  // 굴 위치(끝)
	static char[][] map;  // 지도
	static int[][] time;  // 방문하는데 걸린 시간
	static Queue<Info> q = new LinkedList<>();  // 큐
	
	// 방향
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);  // 행
		c = Integer.parseInt(str[1]);  // 열
		map = new char[r][c];  // 지도 할당
		for(int i = 0; i < r; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				map[i][j] = ch[j];  // 지도 입력
				// 고슴도치 위치 입력
				if(ch[j] == 'S') {  
					startR = i;
					startC = j;
				}
				// 굴 위치 입력
				if(ch[j] == 'D') {
					endR = i;
					endC = j;
				}
			}
		}
		
		// 시간 -1로 초기화
		time = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				time[i][j] = -1;
			}
		}
		
		int result = bfs();
		
		if(result == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
		
		
	}

	private static int bfs() {
		Info info = new Info(startR, startC, map);
		q.add(info);
		time[info.infoR][info.infoC] = 0;
		
		while(!q.isEmpty()) {
			Info curr = q.remove();
			Info next;
			char[][] copyMap = new char[r][c];  // 복사할 지도
			
			// 물이 찰 예정인 위치 표시
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					// 물이면
					if(curr.infoMap[i][j] == '*') {
						// 4방향
						for(int k = 0; k < 4; k++) {
							int currR = i + dr[k];
							int currC = j + dc[k];
							
							// 범위 검사
							if(currR < 0 || currR >= r || currC < 0 || currC >= c) {
								continue;
							}
							
							// 비어있는 곳이면 - 대입(물이 찰 예정인 위치)
							if(curr.infoMap[i][j] == '.') {
								curr.infoMap[i][j] = '-';
							}
						}
					}
					
				}
			}
			
			
			// 물이 찰 예정인 위치에 물로 채움
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					// 물 채움
					if(curr.infoMap[i][j] == '-') {
						curr.infoMap[i][j] = '*';
					}
					
					// 지도 복사
					copyMap[i][j] = curr.infoMap[i][j];
				}
			}
			
			// 고슴도치 이동
			for(int i = 0; i < 4; i++) {
				next = new Info(curr.infoR + dr[i], curr.infoC + dc[i], copyMap);
			}
			
		}
		
		return -1;
	}

}

class Info {
	
	int infoR, infoC;
	char[][] infoMap;
	
	public Info(int infoR, int infoC, char[][] infoMap) {
		super();
		this.infoR = infoR;
		this.infoC = infoC;
		this.infoMap = infoMap;
	}
	
}
