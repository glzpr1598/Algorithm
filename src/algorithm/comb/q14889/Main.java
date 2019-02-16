package algorithm.comb.q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 14889 치킨 배달
 * https://www.acmicpc.net/problem/14889
 */
public class Main {
	
	static int N; // 사람 수
	static int[][] S; // 능력치 표
	static int result = Integer.MAX_VALUE;
	
	// 조합
	static int combN;
	static int combR;
	static int[] dataArr; // 사람 리스트
	static int[] startTeam;
	static int[] linkTeam;
	
	public static void main(String[] args) throws IOException {
		
		inputData();
		comb(combN, combR);
		System.out.println(result);
		
	}
	
	// 데이터 입력
	static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		dataArr = new int[N];
		combN = N;
		combR = combN / 2;
		startTeam = new int[combR + 1];
		linkTeam = new int[combR + 1];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(str[j]);
			}
			
			dataArr[i] = i;
		}
	}
	
	// 사람 조합
	static void comb(int n, int r) {
		if (r == 0) {
			process();
			return;
		} else if (n < r) {
			return;
		} else {
			startTeam[r-1] = dataArr[n-1];
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}
	
	static void process() {
		// 링크팀 구하기
		int s = 0;
		int l = 0;
		for (int i = 0; i < N; i++) {
			if (startTeam[s] != i) {
				linkTeam[l++] = i;
			} else {
				s++;
			}
		}
		
		// 각 팀의 점수 계산
		int startScore = 0;
		int linkScore = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				startScore += S[startTeam[i]][startTeam[j]];
				linkScore += S[linkTeam[i]][linkTeam[j]];
			}
		}
		int diff = Math.abs(startScore - linkScore);
		
		// 최솟값이면 결과 변경
		result = result < diff ? result : diff;
	}
	
}