package com.dodo.algoStudyPersonal.forBaekjoon;

import java.util.Scanner;

public class Main1074 {
	int number;
	public static void main(String[] args) {
		Main1074 obj=new Main1074();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		obj.getNum(n, r, c);
		System.out.println(obj.number);
	}
	public void getNum(int n, int r, int c) {
		if(n==0) {
			return;
		}
		
		int half=((int)Math.pow(2, n))/2;//한변 길이의 반
		
		if(c<half && r<half) {//1사분면
			getNum(n-1,r,c);
		}else if(c>=half && r<half) {//2사분면
			number+=half*half;
			getNum(n-1,r,c-half);
		}else if(c<half && r>=half) {//3사분면
			number+=half*half*2;
			getNum(n-1,r-half,c);
		}else {//4사분면
			number+=half*half*3;
			getNum(n-1,r-half,c-half);
		}
	}

}
