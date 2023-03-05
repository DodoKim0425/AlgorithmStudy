package com.dodo.algoStudyPersonal.forBaekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095 {
	private static int res;//경우의 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int testCase=0;testCase<T;testCase++) {
			int goal=Integer.parseInt(br.readLine());
			getSum(0, goal);
			System.out.println(res);
			res=0;
		}

	}
	public static void getSum(int sum, int goal) {
		for(int i=1;i<=3;i++) {
			int nextSum=sum+i;
			if(nextSum==goal)
				res++;
			else if(nextSum<goal)
				getSum(nextSum, goal);
		}	
	}
}
