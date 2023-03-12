package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//5:21~5:41~5:46
//힌트봄: 사전순 정렬.. 처음에 했을때 String이 있는 ArrayList로 해서 11,9 이렇게 있다고 가정하면 11->9 이 순서로 정렬됨 9->11 이렇게 되어야 맞다
public class Main15654 {
	private static ArrayList<Integer> numbers;
	private static int until;
	private static StringBuilder sb;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		sb=new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		until=Integer.parseInt(firstLine[1]);
		visited=new boolean[Integer.parseInt(firstLine[0])];
		
		String[] secondLine=br.readLine().split(" ");
		numbers=new ArrayList<Integer>();
		for(int i=0;i<secondLine.length;i++) {
			numbers.add(Integer.parseInt(secondLine[i]));
		}
		Collections.sort(numbers);
		int[] pickedNumber=new int[Integer.parseInt(firstLine[1])];
		getRes(0, pickedNumber);
		System.out.println(sb);
	}

	public static void getRes(int count, int[] pickedNumber) {
		if(count==until) {
			for(int i=0;i<pickedNumber.length;i++) {
				sb.append(pickedNumber[i]);
				sb.append(" ");
			}
			sb.append("\n");
		}else {
			for(int i=0;i<numbers.size();i++) {
				if(visited[i]==false) {
					visited[i]=true;
					pickedNumber[count]=numbers.get(i);
					getRes(count+1, pickedNumber);
					visited[i]=false;
				}

			}
		}
	}
}
