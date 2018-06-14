package algorithm.bfs.q2251;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2251 물통
 * https://www.acmicpc.net/problem/2251
 */
public class Main {
	
	static Queue<Info> q = new LinkedList<>();
	static boolean[][] visited = new boolean[201][201];  // 방문 여부
	static int maxA, maxB, maxC;  // 각 물통의 최대 용량
	static boolean[] answer;  // 답. 가능한 용량에 true 대입

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a, b, c;  // 초기 물통의 용량
		
		// 최대 용량 입력
		maxA = sc.nextInt();
		maxB = sc.nextInt();
		maxC = sc.nextInt();
		
		// C의 최대용량만큼 배열크기 할당
		answer = new boolean[maxC+1];  
		
		// 초기 용량
		a = 0;
		b = 0;
		c = maxC;
		
		bfs(a, b, c);
		
		for(int i = 0; i <= maxC; i++) {
			if(answer[i]) {
				System.out.print(i + " ");
			}
		}
		
	}

	private static void bfs(int a, int b, int c) {
		Info info = new Info(a, b, c);
		q.add(info);
		visited[a][b] = true;
		answer[c] = true;
		
		while(!q.isEmpty()) {
			Info curr = q.remove();  // 현재 상태
			Info next;  // 다음 상태
			
			// A -> B
			if(curr.a != 0 && curr.b != maxB) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.a <= maxB - curr.b) {  // 모두 부을 수 있는 상태
					next.b += curr.a;
					next.a = 0;
				} else {  // 모두 부을 수 없는 상태
					next.a -= maxB - curr.b;  
					next.b = maxB;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
			// A -> C
			if(curr.a != 0 && curr.c != maxC) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.a <= maxC - curr.c) {  // 모두 부을 수 있는 상태
					next.c += curr.a;
					next.a = 0;
				} else {  // 모두 부을 수 없는 상태
					next.a -= maxC - curr.c;  
					next.c = maxC;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
			// B -> A
			if(curr.b != 0 && curr.a != maxA) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.b <= maxA - curr.a) {  // 모두 부을 수 있는 상태
					next.a += curr.b;
					next.b = 0;
				} else {  // 모두 부을 수 없는 상태
					next.b -= maxA - curr.a;  
					next.a = maxA;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
			// B -> C
			if(curr.b != 0 && curr.c != maxC) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.b <= maxC - curr.c) {  // 모두 부을 수 있는 상태
					next.c += curr.b;
					next.b = 0;
				} else {  // 모두 부을 수 없는 상태
					next.b -= maxC - curr.c;  
					next.c = maxC;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
			// C -> A
			if(curr.c != 0 && curr.a != maxA) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.c <= maxA - curr.a) {  // 모두 부을 수 있는 상태
					next.a += curr.c;
					next.c = 0;
				} else {  // 모두 부을 수 없는 상태
					next.c -= maxA - curr.a;  
					next.a = maxA;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
			// C -> B
			if(curr.c != 0 && curr.b != maxB) {
				next = new Info(curr.a, curr.b, curr.c);
				// 물 붓기
				if(curr.c <= maxB - curr.b) {  // 모두 부을 수 있는 상태
					next.b += curr.c;
					next.c = 0;
				} else {  // 모두 부을 수 없는 상태
					next.c -= maxB - curr.b;  
					next.b = maxB;
				}
				// 방문 여부 확인 후 큐에 추가
				pushData(next);
			}
			
		}
		
	}

	private static void pushData(Info next) {
		if(!visited[next.a][next.b]) {  // 방문하지 않은 경우
			q.add(next);
			visited[next.a][next.b] = true;
			if(next.a == 0) {  // 첫 번째 물통이 비어있을 때만 정답 인정
				answer[next.c] = true;
			}
		}
	}
	
}

class Info {
	int a, b, c;

	public Info(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}
