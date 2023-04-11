package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//런타임 에러 (ArrayIndexOutOfBounds) 발생, 아래 코드와 무엇이 다른지 모르겠다
//public class Main11726 {
//	private static int n;
//	private static int[] dp;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		n=Integer.parseInt(br.readLine());
//		dp=new int[n+1];
//		
//		makeTable();
//		System.out.println(dp[n]);
//	}
//	public static void makeTable() {
//		dp[1]=1;
//		dp[2]=2;
//		for(int i=3;i<=n;i++) {
//			dp[i]=(dp[i-1]+dp[i-2])%10007;
//		}
//	}
//
//}

public class Main11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.println(dp[n]);

    }
}
