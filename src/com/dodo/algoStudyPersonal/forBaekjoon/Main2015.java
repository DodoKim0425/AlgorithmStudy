package com.dodo.algoStudyPersonal.forBaekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//https://ongveloper.tistory.com/215
//https://january-diary.tistory.com/entry/BOJ-2015-%EC%88%98%EB%93%A4%EC%9D%98-%ED%95%A9-4-JAVA
public class Main2015 {
	private static int n;
	private static int k;
	private static int[] numbers;
	private static int[] sumTable;//누적합 테이블
	private static long res;
	private static HashMap<Integer, Long> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine= br.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		k = Integer.parseInt(firstLine[1]);
		numbers=new int[n];
		sumTable=new int[n];
		map = new HashMap<Integer, Long>();
		String[] secondLine=br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			numbers[i]=Integer.parseInt(secondLine[i]);
		}
		
		int sum=0;
		for(int i=0;i<numbers.length;i++) {//누적합 테이블을 만든다
			sumTable[i]=sum+numbers[i];
			sum=sumTable[i];
			if(sum==k)//누적합 그 자체가 k인 경우를 포함
				res++;
		}
		getRes();
		System.out.println(res);
	}
	
	public static void getRes() {
		//sumTable[i]-sumTable[j] = k의 수를 구해야 되는데 이를 이항하면
		//sumTable[i]-k=sumTable[j]가 되고 이를 만족하는것의 개수를구하는것과 마찬가지다
		//이때 j<i인점을 이용한다
		//sumTable[i]-k를 만족하는 sumTable[j]가 이전에 있었는지를 확인한다 있다면 조건이 만족된것이므로 res++한다
		//없다면 현재 sumTable[i]를 sumTable[j]로써 맵에 추가한다
		
		for(int i=0;i<sumTable.length;i++) {
			res += map.getOrDefault(sumTable[i]-k, (long) 0);
			map.put(sumTable[i], map.getOrDefault(sumTable[i], (long) 0)+1);
		}
	}

}
