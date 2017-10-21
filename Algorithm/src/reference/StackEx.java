package reference;

import java.util.Stack;

public class StackEx {
	
	public static void main(String[] args) {
		// Integer형 스택
		Stack<Integer> stack = new Stack<>();
		
		// 객체 추가
		stack.push(1);
		stack.add(3);
		stack.add(2);
		
		// 스택이 빌 때까지 pop
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
