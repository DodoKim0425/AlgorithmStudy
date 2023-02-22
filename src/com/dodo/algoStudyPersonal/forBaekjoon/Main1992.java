package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1992{
	private static String res;
	private static String[][]image;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		image=new String[n][n];
		for(int i=0;i<n;i++) {
			String[] line=sc.nextLine().split("");
			for(int j=0;j<line.length;j++)
				image[i][j]=line[j];
		}
		
		System.out.println(quadTree(n, 0, 0));
		
	}
	public static String quadTree(int n, int startCol, int startRow) {
		String quad="";
		int half=n/2;
		if(n==1)
			return image[0][0];
		if(n==2) {//가장 작은 사각형
			//1사분면
			quad+=image[startRow][startCol];
			//2사분면
			quad+=image[startRow][startCol+half];
			//3사분면
			quad+=image[startRow+half][startCol];
			//4사분면
			quad+=image[startRow+half][startCol+half];
		}else {
			//1사분면으로
			quad+=quadTree(half, startCol, startRow);
			//2사분면으로
			quad+=quadTree(half, startCol+half, startRow);
			//3사분면으로
			quad+=quadTree(half, startCol, startRow+half);
			//4사분면으로
			quad+=quadTree(half, startCol+half, startRow+half);
		}
		
		if(quad.equals("0000")) {
			return "0";
		}else if(quad.equals("1111")) {
			return "1";
		}else {
			return "("+quad+")";
		}
		
	}
	
}
