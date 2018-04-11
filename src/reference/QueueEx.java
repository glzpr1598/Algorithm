package reference;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {
		// Integer형 큐
		Queue<Integer> q = new LinkedList<>();
		
		// 객체 추가
		q.add(1);
		q.add(3);
		q.add(2);
		
		// 큐가 빌 때까지 제거하면서 출력
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
	
}
