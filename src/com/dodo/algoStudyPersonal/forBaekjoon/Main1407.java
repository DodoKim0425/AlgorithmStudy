package com.dodo.algoStudyPersonal.forBaekjoon;

import java.util.Scanner;

public class Main1407 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long start=sc.nextLong();
		long end=sc.nextLong();
		long res=(getRes(end)-getRes(start-1));
		System.out.println(res);
	}
	public static long getRes(long num) {
		long targetNum=num;
		long addedRes=0;
		long divideNum=1;
		while(targetNum!=0) {
			if(targetNum%2!=0) {
				addedRes+=(targetNum/2+1)*divideNum;
			}else {
				addedRes+=(targetNum/2)*divideNum;
			}
			divideNum*=2;
			targetNum/=2;
		}
		return addedRes;
	}
}