package algorithm.bfs.q14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 14226 이모티콘
 * https://www.acmicpc.net/problem/14226
 */
public class Main {
	
	static int s;  // 목표 이모티콘 수
	static Queue<Emo> q = new LinkedList<>();
	static boolean[][] visited;  // 방문 여부

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
		
		visited = new boolean[20000][20000];

		Emo emo = new Emo(1, 0, 0);
		int result = bfs(emo);
		System.out.println(result);
	}
	
	public static int bfs(Emo emo) {
		q.add(emo);
		visited[emo.screen][emo.clip] = true;
		while(!q.isEmpty()) {
			Emo here = q.remove();
			Emo there;
			
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			if (!visited[here.screen][here.screen] && here.screen != here.clip) {
				visited[here.screen][here.screen] = true;
				there = new Emo(here.screen, here.screen, here.time + 1);
				q.add(there);
			}
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			if (!visited[here.screen + here.clip][here.clip] && here.clip > 0) {
				visited[here.screen + here.clip][here.clip] = true;
				there = new Emo(here.screen + here.clip, here.clip, here.time + 1);
				q.add(there);
				if (there.screen == s) return there.time;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if (!visited[here.screen - 1][here.clip] && here.screen - 1 > 0) {
				visited[here.screen - 1][here.clip] = true;
				there = new Emo(here.screen - 1, here.clip, here.time + 1);
				q.add(there);
				if (there.screen == s) return there.time;
			}
		}
		
		return -1;
	}

}

class Emo {
	int screen;
	int clip;
	int time;
	
	public Emo() {}
	
	public Emo(int screen, int clip, int time) {
		super();
		this.screen = screen;
		this.clip = clip;
		this.time = time;
	}
}
