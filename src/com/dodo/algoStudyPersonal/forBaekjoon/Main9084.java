package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//예전에 수업시간에 봤던 문제 그때는 이해가 잘 안갔음
//지난주에 풀었던 암호코드 처럼 뒤에서 어디까지는 고정이고 그 앞의것은 먼저 구한 dp테이블에서 경우의 수를 가져온다고 생각하니 풀렸다

public class Main9084 {
	private static int coinNumber;
	private static int[] coins;
	private static int target;
	private static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNumber = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=caseNumber; testCase++) {
			coinNumber = Integer.parseInt(br.readLine());
			coins = new int[coinNumber];
			String[] line = br.readLine().split(" ");
			for(int i=0;i<coinNumber;i++) {
				coins[i] = Integer.parseInt(line[i]);
			}
			target=Integer.parseInt(br.readLine());
			dp = new int[target+1];
			for(int i=0;i<dp.length;i++) {
				if(i%coins[0]==0) {
					dp[i]=1;
				}
			}
			getTable();
			System.out.println(dp[target]);
		}

	}
	public static void getTable() {
		for(int i=1;i<coins.length;i++) {
			int coinVal=coins[i];
			for(int j=coinVal;j<dp.length;j++) {
				dp[j]=dp[j]+dp[j-coinVal];
			}
		}
	}

}
