package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//5:28~5:42
public class Main1924 {
	private static String[] day= {"SUN","MON","TUE","WED", "THU", "FRI", "SAT"};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		int dateDiff=Integer.parseInt(line[1]);
		switch(line[0]) {
			case "12":
				dateDiff+=30;
			case "11":
				dateDiff+=31;
			case "10":
				dateDiff+=30;
			case "9":
				dateDiff+=31;
			case "8":
				dateDiff+=31;
			case "7":
				dateDiff+=30;
			case "6":
				dateDiff+=31;
			case "5":
				dateDiff+=30;
			case "4":
				dateDiff+=31;
			case "3":
				dateDiff+=28;
			case "2":
				dateDiff+=31;
		}
		System.out.println(day[dateDiff%7]);
	}

}
