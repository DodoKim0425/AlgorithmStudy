package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main15656 {
	private static int n;
	private static int m;
	private static ArrayList<Integer> numbers;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		String[] secondLine=br.readLine().split(" ");
		sb=new StringBuilder();
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		numbers=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			numbers.add(Integer.parseInt(secondLine[i]));
		}
		Collections.sort(numbers);
		getRes(0, new int[m]);
		System.out.println(sb);
	}
	public static void getRes(int count, int[] picked) {
		if(count==m) {
			for(int i=0;i<picked.length;i++) {
				sb.append(picked[i]);
				sb.append(" ");
			}
			sb.append("\n");
		}else {
			for(int i=0;i<numbers.size();i++) {
				picked[count]=numbers.get(i);
				getRes(count+1, picked);
			}
		}
	}
}
