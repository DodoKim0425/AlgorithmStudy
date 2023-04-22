package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Math.pow 라이브러리 사용하면 오답   
//참고한 블로그: https://st-lab.tistory.com/237
public class Main1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		int a=Integer.parseInt(line[0]);
		int b=Integer.parseInt(line[1]);
		int c=Integer.parseInt(line[2]);
		System.out.println(getRes(a, b, c));
	}
	public static long getRes(int a, int b, int c) {
		if(b==0)
			return 1;
		
		long half=getRes(a,b/2,c);
		
		if(b%2==0) {//b가 짝수인 경우
			return half*half%c;
		}else {
			//return half*half*a%c;//이 경우 half도 2,147,483,647이고 a도 2,147,483,647이면 long범위 넘어가서 오답
			return ((half*half)%c*a%c)%c;
			
		}
	}
}