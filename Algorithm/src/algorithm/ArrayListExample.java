package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
	
	public static void main(String[] args) {
		// Integer형 list 생성
		List<Integer> list = new ArrayList<>();
		
		// list에 값 추가
		list.add(2);
		list.add(1);
		list.add(3);
		
		// list 정렬
		Collections.sort(list);		// 오름차순
		// Collections.sort(list, Collections.reverseOrder());	// 내림차순
		
		// list 사이즈, 인자 출력
		System.out.println("size : " + list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}

}
