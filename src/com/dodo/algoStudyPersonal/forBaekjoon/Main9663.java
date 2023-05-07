package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//처음에 check함수에서 i를 넣어야 하는데 실수로 count-1을 넣고있어서 시간을 낭비
//메모리 초과가 나서 queen배열을 int[n][2] 에서 int[n]으로 바꿨더니 통과
public class Main9663 {
	private static int n;
	private static int[] queen;
	private static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queen = new int[n];
		getRes(0);
		System.out.println(res);
	}
	public static void getRes(int count) {
		if(count == n) {
			res++;
		}else {
			for(int nextCol=0; nextCol<n; nextCol++) {
				if(check(count, nextCol, count)) {
					queen[count]=nextCol;
					getRes(count+1);
				}
			}
		}
	}
	public static boolean check(int nextRow, int nextCol, int count) {
		for(int i=0;  i<count; i++) {
			int row= i;
			int col= queen[i];
			if(row==nextRow || col==nextCol) {
				return false;
			}
			if(Math.abs(row-nextRow)==Math.abs(col-nextCol)) {
				return false;
			}
		}
		return true;
	}
}
