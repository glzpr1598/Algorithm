package algorithm.dp.q2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2667 단지번호붙이기
// https://www.acmicpc.net/problem/2667
// DFS 이용
public class Main {
	static int[][] house;	// 집
	static boolean[][] visited;	// dfs 방문여부
	static int house_count;	// 단지내 집의 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		house = new int[n+2][n+2];
		visited = new boolean[n+2][n+2];
		List<Integer> count_list = new ArrayList<>();	// 집의 수들을 받아서 정렬하기 위해
		int dan_count = 0;	// 단지 수(첫째 줄에 출력해야함)
		
		// 한줄씩 읽으면서 house 정보 입력
		for (int i=1; i<=n; i++) {
			String str = br.readLine();
			for (int j=1; j<=n; j++) {
				house[i][j] = Integer.parseInt( str.charAt(j-1) + "" );
			}
		}
		
		// 집이 있고 방문하지 않은 곳을 찾으면 dfs 시작
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (house[i][j] == 1 && visited[i][j] == false) {
					house_count = 0;
					dfs(i, j);		// dfs 실행
					dan_count++;	// 단지수 증가
					count_list.add(house_count);	// 리스트에 단지내 집 수 추가
				}
			}
		}
		
		Collections.sort(count_list);	// 집 수들을 정렬
		
		System.out.println(dan_count);	// 단지 수 출력
		for (int i=0; i<count_list.size(); i++) {
			System.out.println(count_list.get(i));	// 집 수 출력
		}
			
		
	}
	
	// 붙어있는 집이 있는 count 반환
	public static void dfs(int a, int b) {
		visited[a][b] = true;
		house_count++;
		
		// 북, 동, 남, 서 방향순으로 dfs 실행
		if (house[a-1][b] == 1 && visited[a-1][b] == false)
			dfs(a-1, b);
		if (house[a][b+1] == 1 && visited[a][b+1] == false)
			dfs(a, b+1);
		if (house[a+1][b] == 1 && visited[a+1][b] == false)
			dfs(a+1, b);
		if (house[a][b-1] == 1 && visited[a][b-1] == false)
			dfs(a, b-1);
	}

}
