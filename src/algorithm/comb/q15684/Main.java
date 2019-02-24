package algorithm.comb.q15684;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 15684 사다리 조작
 * https://www.acmicpc.net/problem/15684
 */
public class Main {
	
	static int N, M, H; // 세로선 개수, 가로선 개수, 가로선 가능 개수
	static boolean[][] map; // 가로선 좌표(왼쪽 기준)
	static boolean isSolved = false; // 결과값을 찾았는지 여부
	static int result = -1;
	
	// 조합
	static Pos[] nData; // 가능한 가로선 좌표 배열
	static int combN = 0;
	static int combR;
	static Pos[] combData; // 조합 결과 좌표 배열

	public static void main(String[] args) throws Exception {
		
		// 데이터 입력
		inputData();
		// 가능한 가로선 좌표 찾기
		findNData();
		// 조합
		for (int i = 0; i <= 3; i++) {
			combination(combN, i, i);
		}
		// 결과 출력
		System.out.println(result);
	}

	private static void inputData() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		N = Integer.parseInt(tokens[0]);
		M = Integer.parseInt(tokens[1]);
		H = Integer.parseInt(tokens[2]);
		map = new boolean[H+1][N+1];
		nData = new Pos[N*H];
		combData = new Pos[3]; // 가로선 최대 개수 3개
		
		for (int i = 0; i < M; i++) {
			tokens = br.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			map[a][b] = true;
		}
	}
	
	// 가능한 가로선 구하기
	private static void findNData() {
		for (int i = 1; i <= H; i++) { // 가로선
			for (int j = 1; j < N; j++) { // 세로선
				if (map[i][j-1]) // 왼쪽에 선이 있는지
					continue;
				if (map[i][j+1]) // 오른쪽에 선이 있는지
					continue;
				if (map[i][j]) // 현재위치에 선이 있는지
					continue;
				
				// 모두 없으면 가능
				nData[combN++] = new Pos(i, j);
			}
		}
	}

	private static void combination(int n, int r, int num) { // num: 그린 가로선 개수
		// 결과를 이미 구했으면 더이상 진행할 필요 없음
		if (isSolved) {
			return;
		}
		
		if (r == 0) {
			process(num);
			return;
		} else if (n < r) {
			return;
		} else {
			combData[r-1] = nData[n-1];
			combination(n-1, r-1, num);
			combination(n-1, r, num);
		}
	}

	// 조합 결과
	private static void process(int num) {
		// 임시 map 생성
		boolean[][] tempMap = new boolean[H+1][N+1];
		for (int i=0; i<=H; i++) {
			for (int j=0; j<=N; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		// 조합 결과의 가로선 추가
		for (int i=0; i<num; i++) {
			Pos pos = combData[i];
			tempMap[pos.x][pos.y] = true;
		}
		
		// 결과가 모두 일치하는 경우
		if (checkResult(tempMap)) {
			result = num;
			isSolved = true;
		}
	}
	
	// i번의 결과가 i번인지 체크
	private static boolean checkResult(boolean[][] inputMap) {
		for (int i=1; i<=N; i++) {
			int curr = i; // 현재 세로선 위치
			for (int j=1; j<=H; j++) {
				// 왼쪽에 가로선이 있는 경우
				if (curr > 1 && inputMap[j][curr-1]) {
					// 왼쪽으로 이동
					curr--;
				}
				// 오른쪽에 가로선이 있는 경우
				else if (curr < N && inputMap[j][curr]) {
					// 오른쪽으로 이동
					curr++;
				}
			}
			// 하나라도 결과가 일치하지 않으면 false 반환
			if (curr != i)
				return false;
		}
		// 모두 일치
		return true;
	}

}

class Pos {
	int x, y;
	
	Pos (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
