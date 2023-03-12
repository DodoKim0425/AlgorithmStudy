package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

////6:2~9:00 다른사람의 풀이를 참고함
public class Main2447{
	private static int n;
	private static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				getRes(i, j, n);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void getRes(int i, int j, int len) {
		if(((i/len)%3)==1 && ((j/len)%3)==1) {
			sb.append(" ");
		}else {
			if(len==1) {
				sb.append("*");
			}else {
				getRes(i, j, len/3);
			}
		}
	}
}

//public class Main2447 {
//	private static int n;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		n=Integer.parseInt(br.readLine());
//		System.out.println(getStr(getRes(n)));
//	}
//
//	public static String[][] getRes(int len) {
//		String[][] returnString = new String[len][len];
//		for (int i = 0; i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				if (i>=len/3 && i<len/3+len/3 && j>=len/3 && j<len/3+len/3) {
//					returnString [i][j]= " ";
//				} else {
//					if(len==3) {
//						returnString[i][j]="*";
//					}else {
//						returnString [i][j]= getStr(getRes(len / 3));
//					}
//				}
//			}
//		}
//
//		return returnString;
//	}
//	public static String getStr(String[][] strArray) {
//		String res="";
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				res+=strArray[i][j];
//			}
//			res+="\n";
//		}
//		return res;
//	}
//	public static String getSpace(int len) {
//		String spaceString="";
//		if(len==1)
//			return "o";
//		for(int i=0;i<len/3;i++) {
//			for(int j=0;j<len/3;j++) {
//				spaceString+="o";
//			}
//			spaceString+="\n";
//		}
//		return spaceString;
//	}
//}
