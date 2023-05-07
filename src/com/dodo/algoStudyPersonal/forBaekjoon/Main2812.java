package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
//https://steady-coding.tistory.com/54
public class Main2812 {
	private static int n;
	private static int k;
	private static int[] numbers;
	private static Deque<Integer> dq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1=br.readLine().split(" ");
		String[] line2=br.readLine().split("");
		n=Integer.parseInt(line1[0]);
		k=Integer.parseInt(line1[1]);
		dq=new ArrayDeque();
		numbers = new int[n];
				
		for(int i=0;i<n;i++) {
			numbers[i]=Integer.parseInt(line2[i]);
		}
		getRes();
		int size=dq.size();
		for(int i=0;i<size-k;i++) {
			System.out.print(dq.getFirst());
			dq.removeFirst();
		}
	}
	private static void getRes() {
		for(int i=0;i<numbers.length;i++) {
			while(k>0 && dq.isEmpty()==false) {
				if(dq.getLast()<numbers[i]) {
					k--;
					dq.removeLast();
				}else {
					break;
				}
			}
			dq.add(numbers[i]);
		}
	}

}
