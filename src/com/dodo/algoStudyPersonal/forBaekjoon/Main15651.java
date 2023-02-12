package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//public class Main15651 { //->시간초과
//
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int m=sc.nextInt();
//		
//		dfs(n, m, 0, "");
//	}
//	public static void dfs(int n, int m, int now, String str) {
//		if(now==m) {
//			System.out.println(str);
//			return;
//		}
//		for(int i=1;i<=n;i++) {
//			str+=i+" ";
//			dfs(n, m, now+1, str);
//			str=str.substring(0, str.length()-2);
//		}
//	}
//}

public class Main15651 { //Scanner->BufferdReader, 문자열 출력 한번에, 출력값 String->StringBuilder 
	private static StringBuilder str=new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = 0, m=0;
		try {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}

		int[] numbers=new int[m];
		
		dfs(n, m, 0, numbers);
		System.out.println(str);
	}
	public static void dfs(int n, int m, int now, int[] numbers) {
		if(now==m) {
			for(int i=0;i<numbers.length;i++) {
				str.append(numbers[i]).append(" ");
			}
			str.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			numbers[now]=i;
			dfs(n, m, now+1, numbers);
		}
	}
}

