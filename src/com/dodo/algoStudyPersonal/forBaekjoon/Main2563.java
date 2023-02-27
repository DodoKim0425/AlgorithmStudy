package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperNum=Integer.parseInt(br.readLine());
		int [][]map=new int [100][100];
		int res=0;
		for(int i=0;i<paperNum;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int col=Integer.parseInt(st.nextToken())-1;
			int row=Integer.parseInt(st.nextToken())-1;
			for(int j=row;j<10+row;j++) {
				for(int k=col;k<10+col;k++) {
					map[j][k]=1;
				}
			}
		}
		for(int i=99;i>=0;i--) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==1)
					res++;
			}
		}
		System.out.println(res);
	}

}
