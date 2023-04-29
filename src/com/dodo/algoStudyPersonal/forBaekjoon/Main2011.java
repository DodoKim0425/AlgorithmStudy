package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://assb.tistory.com/entry/%EB%B0%B1%EC%A4%80-2011%EB%B2%88-%EC%95%94%ED%98%B8%EC%BD%94%EB%93%9C
//https://velog.io/@youhyeoneee/%EB%B0%B1%EC%A4%80-2011%EB%B2%88-%EC%95%94%ED%98%B8%EC%BD%94%EB%93%9C
public class Main2011{
	private static String[] list;//숫자 리스트
	private static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		list=br.readLine().split("");
		dp=new int[list.length+1];
		
		dp[0]=1;
		dp[1]=1;
		if(list[0].equals("0")) {
			System.out.println(0);
		}else {
			getTable();
			
			System.out.println(dp[list.length]);
			
		}
		
	}
	
	public static void getTable() {
		for(int i=2;i<dp.length;i++) {
			int checked=check(i-1);
			switch(checked) {
			case 0: 
				dp[i]=0;
				break;
			case 2:
				dp[i]=dp[i-2];
				break;
			case 1:
				dp[i]=dp[i-1]%1000000;
				break;
			case 3:
				dp[i]=dp[i-1]%1000000+dp[i-2]%1000000;
			}
		}
	}
	public static int check(int i) {
		//두자리 한자리 모두 가능하기 위해서는
		//1. i보다 앞 숫자가 1, 2 이어야 함
		//2. i-1, i 를 연결했을때 1이상 26이하여야 한다
		String front = list[i-1];
		String end = list[i];
		
		if(end.equals("0")) {//현재 숫자가 0인 경우 무조건 두자리만 되거나(10, 20), 무조건 한자리만 되거나
			if((front+end).equals("10")||(front+end).equals("20")) {//무조건 두자리
				return 2;
			}else {//무조건 한자리인데 0 
				return 0;
			}
		}
		int concat = Integer.parseInt(front+end);
		if(concat>26 || front.equals("0")) {//무조건 한자리만
			return 1;
		}else {//한자리 두자리 모두 가능
			return 3;
		}
	}
}
