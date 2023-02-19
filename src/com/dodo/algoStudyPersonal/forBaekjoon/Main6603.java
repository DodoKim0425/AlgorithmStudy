package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
	private static int lottoNum=6;
	private static int k;
	private static StringBuilder sb=new StringBuilder();
	private static String [] caseNumbers;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line=br.readLine();
			if(line.equals("0")) {
				break;
			}
			String[] testCase=line.split(" ");
			k=Integer.parseInt(testCase[0]);
			caseNumbers=new String[k];
			for(int i=0;i<k;i++) {
				caseNumbers[i]=testCase[i+1];
			}
			String[] numbers=new String[k];
			getNumbers(0, 0,numbers);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void getNumbers(int depth, int start, String[] numbers) {
		if(depth==lottoNum) {
			for(int i=0;i<depth;i++) {
				sb.append(numbers[i]);
				sb.append(" ");
			}
				
			sb.append("\n");
			return;
		}else {
			for(int i=start;i<k;i++) {
				numbers[depth]=caseNumbers[i];
				getNumbers(depth+1, i+1, numbers);
				
			}
		}
	}
}
