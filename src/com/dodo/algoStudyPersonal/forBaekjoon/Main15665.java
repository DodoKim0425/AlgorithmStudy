package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main15665 {

	private static StringBuilder str=new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = 0, m=0;
		Set<Integer> set= new HashSet<Integer>();
		ArrayList<Integer> numberList=new ArrayList<Integer>();
		try {
			String firstLine=br.readLine();
			String secondLine=br.readLine();
			StringTokenizer st=new StringTokenizer(firstLine);
			StringTokenizer st2=new StringTokenizer(secondLine);
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			while(st2.hasMoreElements()) {
				set.add(Integer.parseInt(st2.nextToken()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext())
			numberList.add(iter.next());
		
		Collections.sort(numberList);
		int[] numbers=new int[m];
		
		dfs(n, m, 0, numbers, numberList);
		System.out.println(str);
	}
	public static void dfs(int n, int m, int now, int[] numbers, ArrayList numberList) {
		if(now==m) {
			for(int i=0;i<numbers.length;i++) {
				str.append(numbers[i]).append(" ");
			}
			str.append("\n");
			return;
		}
		for(int i=1;i<=numberList.size();i++) {
			numbers[now]=(int) numberList.get(i-1);
			dfs(n, m, now+1, numbers, numberList);
		}
	}

}
