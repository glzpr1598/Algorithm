package algorithm.q13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 13458 시험 감독
// https://www.acmicpc.net/problem/13458
// 단순 조건. 부감독관 특이 케이스만 조심.
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 시험장 수
		int[] a = new int[n];	// 응시자 수
		int b, c;				// 감시가능한 응시자 수
		long count = 0;			// 감독관 수, long으로 해야함!
		
		// 응시자 수 입력
		String[] str = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		// B, C 입력
		str = br.readLine().split(" ");
		b = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		
		for (int i=0; i<n; i++) {
			// 총 감독관
			a[i] -= b;
			count++;
			// 부 감독관
			if (a[i] > 0) {
				count += a[i] / c;
				if (a[i] % c != 0)	// 인원이 딱 나누어떨어지지 않으면 한명 더 필요
					count++;
			}
		}
		
		System.out.println(count);
	}
}
