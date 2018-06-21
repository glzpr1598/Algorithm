package algorithm.bfs.q12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 12851 숨바꼭질2
 * https://www.acmicpc.net/problem/12851
 * 풀이)
 * 목표점까지 걸리는 시간(resultTime)을 -1로 초기화 한 후에
 * 목표점에 도달하면 걸리는 시간(resultTime)을 업데이트 한다.
 * 업데이트한 시간보다 현재 시간이 더 오래걸리는 경우 탐색을 종료한다.
 * 주의)
 * 방법의 수를 찾는 문제이므로 방문한 지점을 또 방문할 수도 있다.
 * 1 -> 3의 경우 +1 -> +1과, *2 -> +1의 2가지 경우가 있다.
 * 따라서 방문 여부를 큐에 넣을 때 하는 것이 아니라, 큐를 방문한 후에 해야한다.
 */
public class Main {
	
	static int n, k;  // 수빈이, 동생 위치
	static Queue<Node> q = new LinkedList<>();
	static boolean[] visited = new boolean[100001];  // 방문 여부
	static int resultTime = -1;  // 가장 빠른 시간
	static int resultWay = 0;  // 가장 빠른 시간의 방법 수
	
	public static void main(String[] args) throws IOException {
		
		// 위치 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		
		bfs();
		
		System.out.println(resultTime);
		System.out.println(resultWay);
		
	}

	private static void bfs() {
		
		Node node = new Node(n, 0);
		q.add(node);
		
		while(!q.isEmpty()) {
			Node curr = q.remove();  // 현재 위치
			Node next;  // 다음 위치
			visited[curr.x] = true;  // 방문 표시(위치 주의!!)
			
			// 최소 시간을 이미 구했고, 걸리는 시간이 최소 시간보다 큰 경우
			if(resultTime != -1 && curr.time > resultTime) {
				break;  // 탐색 종료
			}
			
			// 동생 위치에 다다른 경우
			if(curr.x == k) {
				resultTime = curr.time;
				resultWay++;
				continue;
			}
			
			// X - 1
			next = new Node(curr.x - 1, curr.time + 1);
			if(next.x >= 0 && !visited[next.x]) {
				q.add(next);
			}
			
			// X + 1
			next = new Node(curr.x + 1, curr.time + 1);
			if(next.x <= 100000 && !visited[next.x]) {
				q.add(next);
			}
			
			// X * 2
			next = new Node(curr.x * 2, curr.time + 1);
			if(next.x <= 100000 && !visited[next.x]) {
				q.add(next);
			}
		}
		
	}

}

class Node {
	int x;  // 위치
	int time;  // 걸리는 시간
	
	public Node() {}
	public Node(int x, int time) {
		this.x = x;
		this.time = time;
	}
}
