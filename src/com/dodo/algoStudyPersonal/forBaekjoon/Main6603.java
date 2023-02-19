package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
	private static int lottoNum=6;//골라야 하는 숫자의 개수
	private static int k;//주어지는 숫자 개수
	private static StringBuilder sb=new StringBuilder();//결과 담기는 스트링 빌더
	private static String [] caseNumbers;//주어지는 숫자들
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line=br.readLine();
			if(line.equals("0")) {//0이면 테스트 케이스 없으므로 종료
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
		if(depth==lottoNum) {//재귀 호출 종료
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
