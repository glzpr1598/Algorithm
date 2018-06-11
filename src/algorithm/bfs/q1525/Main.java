package algorithm.bfs.q1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* 1525 퍼즐
 * https://www.acmicpc.net/problem/1525
 */
public class Main {
	
	static Queue<String> q = new LinkedList<>();
	static HashMap<String, Integer> visited = new HashMap<>();  // 방문 문자열, 이동 횟수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = new String();  // 입력값
		
		// 문자열 입력
		for (int i = 0; i < 3; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				input += str[j];
			}
		}
		
		// BFS
		int result = bfs(input);
		
		// 결과 출력
		System.out.println(result);
	}

	private static int bfs(String input) {
		q.add(input);
		visited.put(input, 0);
		
		while(!q.isEmpty()) {
			String here = q.remove();
			String there = new String();
			int count = visited.get(here);  // 방문 횟수
			
			int index0 = here.indexOf('0');  // 0의 위치
			
			// 정답과 일치하면 결과 리턴
			if (here.equals("123456780")) {
				return count;
			}
			
			// 위로 이동
			if (index0 - 3 >= 0 ) {
				char temp = here.charAt(index0 - 3);
				there = here.replace('0', temp);
				there = there.replaceFirst(String.valueOf(temp), "0");
				
				if(!visited.containsKey(there)) {
					q.add(there);
					visited.put(there, count + 1);
				}
			}
			
			// 아래로 이동
			if (index0 + 3 < 9) {
				char temp = here.charAt(index0 + 3);
				there = here.replace(temp, '0');
				there = there.replaceFirst("0", String.valueOf(temp));
				
				if(!visited.containsKey(there)) {
					q.add(there);
					visited.put(there, count + 1);
				}
			}
			
			// 왼쪽으로 이동
			if (index0 % 3 != 0) {
				char temp = here.charAt(index0 - 1);
				there = here.replace('0', temp);
				there = there.replaceFirst(String.valueOf(temp), "0");
				
				if(!visited.containsKey(there)) {
					q.add(there);
					visited.put(there, count + 1);
				}
			}
			
			// 오른쪽으로 이동
			if (index0 % 3 != 2) {
				char temp = here.charAt(index0 + 1);
				there = here.replace(temp, '0');
				there = there.replaceFirst("0", String.valueOf(temp));
				
				if(!visited.containsKey(there)) {
					q.add(there);
					visited.put(there, count + 1);
				}
			}
		}
		
		return -1;
		
	}

}
