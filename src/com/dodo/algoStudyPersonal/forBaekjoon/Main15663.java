package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//2:58~3:20 시간초과->이미 출력 결과에 넣은 문자열들을 보관하는 arraylist를 만들고 순회했더니 시간초과됨
//swea의 수식 끼워넣기와 비슷하게 풀면 될듯함
//~3:51
public class Main15663 {
	private static int n;
	private static int m;
	private static ArrayList<Integer> numbers;
	private static StringBuffer sb;
	private static HashMap<Integer, Integer> map;
	private static int[] numberNonDup;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		String[] secondLine=br.readLine().split(" ");
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		numbers=new ArrayList<Integer>();
		sb=new StringBuffer();
		
		for(int i=0;i<secondLine.length;i++) {
			numbers.add(Integer.parseInt(secondLine[i]));
		}
		
		Collections.sort(numbers);
		
		map=new HashMap<Integer, Integer>();//각 숫자가 몇개인지 표시
		
		for(int i=0;i<numbers.size();i++) {
			if(map.containsKey(numbers.get(i))) {
				map.put(numbers.get(i), map.get(numbers.get(i))+1);
			}else {
				map.put(numbers.get(i), 1);
			}
		}
		
		numberNonDup=new int[map.size()];
		int top=0;
		for(Integer i:map.keySet()) {//숫자 종류를 순서대로 담은 배열
			numberNonDup[top]=i;
			top++;
		}
		
		getRes(0, new int[m]);
		System.out.println(sb);
	}
	
	public static void getRes(int count, int[] picked) {
		if(count==m) {
			for(int i=0;i<picked.length;i++) {
				sb.append(picked[i]+" ");
			}
			sb.append("\n");
			
		}else {
			for(int i=0; i<numberNonDup.length;i++) {
				int left=map.get(numberNonDup[i]);
				if(left>0) {
					picked[count]=numberNonDup[i];
					map.put(numberNonDup[i], left-1);
					getRes(count+1, picked);
					map.put(numberNonDup[i], left);
				}
			}
		}
	}

}
