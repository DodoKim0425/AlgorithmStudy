package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15686 {
	private static int[][] chickenStore;
	private static int[][] home;
	private static String[][] map;
	private static int chickenStoreCount;
	private static int homeCount; 
	private static int minChickenLen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		
		int n=Integer.parseInt(firstLine[0]);
		int m=Integer.parseInt(firstLine[1]);
		
		chickenStoreCount=0;
		homeCount=0;
		minChickenLen=-1;
		
		home=new int[2*n][2];
		chickenStore=new int[13][2];
		map=new String[n][n];
		
		int[][] pickedPos=new int [m][2];
		for(int i=0;i<n;i++) {
			map[i]=br.readLine().split(" ");
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j].equals("1")) {
					home[homeCount][0]=i;
					home[homeCount][1]=j;
					homeCount++;
				}else if(map[i][j].equals("2")) {
					chickenStore[chickenStoreCount][0]=i;
					chickenStore[chickenStoreCount][1]=j;
					chickenStoreCount++;
				}
			}
		}
		
		pickChickenStore(m, 0, 0, pickedPos);
		System.out.println(minChickenLen);
	}
	public static void pickChickenStore(int m, int count, int start, int[][] pickedPos) {//조합으로 치킨집 선택
		if(m==count) {
			int chickenLen=getChickenLen(pickedPos);
			if(minChickenLen==-1||minChickenLen>chickenLen)
				minChickenLen=chickenLen;
				
		}else {
			for(int i=start;i<chickenStoreCount;i++) {
				pickedPos[count][0]=chickenStore[i][0];
				pickedPos[count][1]=chickenStore[i][1];
				pickChickenStore(m, count+1, i+1, pickedPos);
			}
		}
	}
	public static int getChickenLen(int[][] pickedPos) {
		int res=0;
		for(int i=0;i<homeCount;i++) {//모든 치킨집과 모든 집간 거리를 구해서 가장 작은것 선택
			int minLen=Math.abs(home[i][0]-pickedPos[0][0])+Math.abs(home[i][1]-pickedPos[0][1]);
			for(int j=1;j<pickedPos.length;j++) {
				int len=Math.abs(home[i][0]-pickedPos[j][0])+Math.abs(home[i][1]-pickedPos[j][1]);
				if(len<minLen)
					minLen=len;
			}
			res+=minLen;
		}
		return res;
	}

}