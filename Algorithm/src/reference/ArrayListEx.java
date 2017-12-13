package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("one");
		al.add("two");
		al.add("three");
		
		for(int i=0; i<al.size(); i++){
		    String val = al.get(i);
		    System.out.println(val);
		}
        
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
