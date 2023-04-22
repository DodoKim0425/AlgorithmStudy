package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1806 {
	private static int n;
	private static int s;
	private static int[] nums;
	private static int minLen;
	private static int startPos;
	private static int endPos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		String[] secondLine=br.readLine().split(" ");
		n=Integer.parseInt(firstLine[0]);
		s=Integer.parseInt(firstLine[1]);
		nums=new int[n];
		minLen=Integer.MAX_VALUE;
		
		for(int i=0 ;i<n ;i++) {
			nums[i]=Integer.parseInt(secondLine[i]);
		}
		getRes();
		System.out.println(minLen);
	}
	public static void getRes() {
		int sum=0;
		int len=0;
		while(true) {
			if(sum>=s) {
				minLen=Math.min(len, minLen);
				sum-=nums[startPos];
				startPos++;
				len--;
			}else if(endPos==n) {//더이상 볼 수 있는 값이 없음
				break;
			}else {
				sum+=nums[endPos];
				endPos++;
				len++;
			}
		}
		
		if(minLen==Integer.MAX_VALUE) {//minLen이 그대로이면 s보다 큰 부분합이 없다는 의미
			minLen=0;
		}
	}

}
