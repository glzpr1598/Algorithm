package algorithm.comb.q15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 15686 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */
public class Main {
	
	static int n, m;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	
	// 조합
	static Pos[] chickenArr; // 모든 치킨집 좌표
	static int chickenNum = 0;
	static int combN, combR;
	static Pos[] combArr; // 치킨집 조합 결과 좌표

	public static void main(String[] args) throws IOException {
		
		// 데이터 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n][n];
		chickenArr = new Pos[n*n];
		combArr = new Pos[m];
		for (int i = 0; i < n; i++) {
			String[] str2 = br.readLine().split(" ");
			for (int j = 0 ; j < n; j++) {
				map[i][j] = Integer.parseInt(str2[j]);
				if (Integer.parseInt(str2[j]) == 2) {
					chickenArr[chickenNum++] = new Pos(i, j);
				}
			}
		}
		
		// 치킨집 m개 조합
		comb(chickenNum, m);
		
		// 결과 출력
		System.out.println(result);
	}
	
	public static void comb(int n, int r) {
		if (r == 0) {
			process();
			return;
		} else if (n < r) {
			return;
		} else {
			combArr[r - 1] = chickenArr[n - 1];
			comb(n - 1, r - 1);
			comb(n - 1, r);
		}
	}
	
	public static void process() {
		// 치킨 거리
		int dist = 0;
		// map 전체 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 집인 경우
				if (map[i][j] == 1) {
					// 한 집의 치킨집까지 최소 거리
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < combArr.length; k++) {
						int diffX = Math.abs(i - combArr[k].x);
						int diffY = Math.abs(j - combArr[k].y);
						min = min < diffX + diffY ? min : diffX + diffY;
					}
					dist += min;
				}
			}
		}
		
		result = result < dist ? result : dist;
	}
}

// 치킨집 좌표
class Pos {
	public int x, y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
