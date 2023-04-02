package com.dodo.algoStudyPersonal.forBaekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main15657{
	private static ArrayList<Integer> list;
	private static int n;
	private static int m;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		list=new ArrayList<Integer>();
		sb=new StringBuilder();
		String[] firstLine=br.readLine().split(" ");
		String[] secondLine=br.readLine().split(" ");
		
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(secondLine[i]));
		}
		Collections.sort(list);
		int[] res=new int[m];
		getRes(0, 0, res);
		System.out.println(sb);
	}
	public static void getRes(int start, int count, int[] picked) {
		if(count==m) {
			for(int i=0;i<picked.length;i++) {
				sb.append(picked[i]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=start; i<n; i++) {
				picked[count]=list.get(i);
				getRes(i, count+1, picked);
			}
		}
	}
}
