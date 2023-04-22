package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단순 dfs로만 풀었다가 찾아보니 시간 초과가 나온다고해서 dp를 함께 사용
//내리막길로 가야하므로 현재 위치보다 크거나 같은곳으로는 가면 안되는데 같은 곳을 제외하지 않는 실수를해서 시간이 더 소모됨

public class Main1520 {
	public static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};
	public static int count;
	public static int m;//세로크기
	public static int n;//가로크기
	public static int[][] map;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		m=Integer.parseInt(firstLine[0]);
		n=Integer.parseInt(firstLine[1]);
		map=new int[m][n];
		dp= new int [m][n];
		
		for(int i=0;i<m;i++) {
			String[] line=br.readLine().split(" ");
			for(int j=0;j<line.length;j++) {
				map[i][j]=Integer.parseInt(line[j]);
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]=-1;
			}
		}
		
		System.out.println(getRes(0,0));
	}
	
	public static int getRes(int row, int col) {
		if(row==m-1 && col==n-1) {
			return 1; //도착지 발견했으므로 +1을 위해 return 1
		}
		if(dp[row][col]!=-1) {
			return dp[row][col];//이미 도착지 까지 경로 수를 센 경우 
		}
		dp[row][col]=0;//현재 위치에서 도착지까지의 경로수를 0으로 초기화
		
		for(int i=0;i<move.length;i++) {
			int nextRow=row+move[i][0];
			int nextCol=col+move[i][1];
			if(check(nextRow, nextCol, map[row][col])) {
				dp[row][col]+=getRes(nextRow, nextCol);
			}
		}
		return dp[row][col];
	}
	
	public static boolean check(int row, int col, int val) {
		if(row>=m || col>=n || col<0 || row<0)
			return false;
		if(map[row][col]>=val)
			return false;
		return true;
	}

}
