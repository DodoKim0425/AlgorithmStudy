package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2630 {

	private static String[][]paper;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int[] paperCount=new int[2];
		int n=Integer.parseInt(br.readLine());
		paper=new String[n][n];
		for(int i=0;i<n;i++) {
			paper[i]=br.readLine().split(" ");
		}
		String paperColor=cutPaper(n, 0, 0);
		paperCount=countPaper(paperColor);
		System.out.println(paperCount[0]);
		System.out.println(paperCount[1]);
		

	}
	public static String cutPaper(int n, int startRow, int startCol) {
		//String[] paperColor=new String[4];
		String paperColor="";
		int half=n/2;
		
		if(n==2) {//가장 작은 사각형일때
			//1사분면
			paperColor+=paper[startRow][startCol];
			//2사분면
			paperColor+=paper[startRow][startCol+half];
			//3사분면
			paperColor+=paper[startRow+half][startCol];
			//4사분면
			paperColor+=paper[startRow+half][startCol+half];
		}else {
			//1사분면으로
			paperColor+=cutPaper(half, startRow, startCol);
			//2사분면으로 
			paperColor+=cutPaper(half, startRow, startCol+half);
			//3사분면으로
			paperColor+=cutPaper(half, startRow+half, startCol);
			//4사분면으로
			paperColor+=cutPaper(half, startRow+half, startCol+half);
		}
		if(paperColor.equals("0000")) {
			return "0";
		}else if(paperColor.equals("1111")) {
			return "1";
		}else {
			return paperColor;
		}
	}
	public static int[] countPaper(String paperColor){
		int whiteNum=0;
		int blueNum=0;
		String[] paperColorList=paperColor.split("");
		for(int i=0;i<paperColorList.length;i++) {
			if(paperColorList[i].equals("0"))
				whiteNum++;
			else
				blueNum++;
		}
		return new int[] {whiteNum, blueNum};
	}

}
