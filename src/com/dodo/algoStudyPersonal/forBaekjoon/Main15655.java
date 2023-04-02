package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//1:35~1:56
public class Main15655{
	private static int until;
	private static StringBuffer sb;
	private static boolean[] visited;
	private static int count;
	private static ArrayList<Integer> numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuffer();
		numbers=new ArrayList<Integer>();
		String[] firstLine=br.readLine().split(" ");
		String[]secondLine=br.readLine().split(" ");
		count=Integer.parseInt(firstLine[0]);
		until=Integer.parseInt(firstLine[1]);
		
		for(int i=0;i<count;i++) {
			numbers.add(Integer.parseInt(secondLine[i]));
		}
		Collections.sort(numbers);
		
		visited=new boolean[count];
		int[] res=new int[until];
		getRes(0, res, 0);
		System.out.println(sb);
	}
	public static void getRes(int num, int[] res, int start) {
		if(num==until) {
			for(int i=0;i<res.length;i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=start;i<count;i++) {
				if(visited[i]==false) {
					res[num]=numbers.get(i);
					visited[i]=true;
					getRes(num+1, res, i+1);
					visited[i]=false;
				}
			}
		}
	}
}