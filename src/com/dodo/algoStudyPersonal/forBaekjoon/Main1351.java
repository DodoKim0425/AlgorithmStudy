package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1351 {
	private static long n;
	private static long p;
	private static long q;
	private static Map<Long, Long> dp;
	private static long res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		n=Long.parseLong(line[0]);
		p=Long.parseLong(line[1]);
		q=Long.parseLong(line[2]);
		
		dp=new HashMap<Long, Long>();
		
		dp.put(0L, 1L);

		System.out.println(getRes(n));
		
	}
	public static long getRes(long num) {
		long res=0;
		long right=0;
		long left=0;
		if(num==0) {
			return 1;
		}else {
			if(dp.containsKey(num/p)==false) {
				right=getRes(num/p);
				dp.put(num/p, right);
			}else {
				right=dp.get(num/p);
			}
			
			if(dp.containsKey(num/q)==false) {
				left=getRes(num/q);
				dp.put(num/q, left);
			}else {
				left=dp.get(num/q);
			}
		}
		return right+left;
	}

}
