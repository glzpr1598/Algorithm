package reference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputOutput {
	
//	10824 네 수
//	네 자연수 A B C D가 주어지면 AB + CD 구하기
	public static void main(String[] args) throws Exception {	// throw 필요
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");    // " " 를 기준으로 문자열을 나누어서 line에 저장
		String a = line[0] + line[1];
		String b = line[2] + line[3];
		long ans = Long.valueOf(a) + Long.valueOf(b);    // 스트링을 long으로 
		System.out.println(ans);
	}
	
//	11023
//	수 N개가 주어졌을 때, 합 구하기(공백으로 구분, 몇 개인지 안정해짐)
//	(주석은 콤마로 구분)
	public static void main2(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();    // 한줄을 읽음
		StringTokenizer st = new StringTokenizer(line);    // 공백을 기준으로 나눔
		// StringTokenizer st = new StringTokenizer(line, ",");    // 콤마를 기준으로 나눔
		int sum = 0;
		while (st.hasMoreTokens())
		{
		    sum += Integer.valueOf(st.nextToken());
		}
		System.out.println(sum);
	}
	
//	2741 N찍기
//	1부터 N까지 한 줄에 하나씩 출력
	public static void main3(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		/*
		for (int i=1; i<=n; i++)
		{
		    System.out.println(i);	// 880ms
		}
		*/
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=n; i++)
		{
		    sb.append(i+"\n");    // 스트링빌더에 출력값 append
		}
		System.out.print(sb);    // 156ms
		
		sc.close();
	}
}
