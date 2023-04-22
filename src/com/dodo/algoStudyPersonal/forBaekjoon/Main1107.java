package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//각 숫자에서 가장 가까운 버튼을 클릭하고 +, - 버튼으로 이동시킨다 
//이 경우 타겟이 400 이고 4, 1이 고장난 경우 
//3, 2, 2 를 선택한다 차이는 78 하지만 3, 9, 9 를 선택하면 단 한번의 + 만 누르면 된다 .. 
//public class Main1107 {
//	private static int minCount;
//	private static int target;
//	private static int[] targetList;
//	private static int count;
//	private static int [] buttons;
//	private static boolean [] btnState; //true면 사용 불가, false사용가능
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//		minCount=Integer.MAX_VALUE;
//		String targetLine=br.readLine();
//		target=Integer.parseInt(targetLine);
//		String[] targetLineSplited=targetLine.split("");
//		targetList=new int[targetLineSplited.length];
//		for(int i=0;i<targetLineSplited.length;i++) {
//			targetList[i]=Integer.parseInt(targetLineSplited[i]);
//		}
//		
//		count=Integer.parseInt(br.readLine());
//		buttons=new int [count];
//		btnState=new boolean[10];
//		
//		if(count!=0) {
//			String[] line=br.readLine().split(" ");
//			for(int i=0;i<count;i++) {
//				buttons[i]=Integer.parseInt(line[i]);
//				btnState[buttons[i]]=true;
//			}
//		}
//		
//		if(target!=100)
//			getRes();
//		else
//			minCount=0;
//		System.out.println(minCount);
//	}
//	public static void getRes() {
//		minCount=Math.abs(100-target);//단순히 +, - 만 해서 채널을 이동하는 경우
//		String minDiffString="";
//		for(int i=0;i<targetList.length;i++) {
//			minDiffString+=getMinDiff(targetList[i]);
//		}
//		int minDiffChannel=Integer.parseInt(minDiffString);
//		if(minCount>Math.abs(minDiffChannel-target)+targetList.length) {
//			minCount=Math.abs(minDiffChannel-target)+targetList.length;
//		}
//	}
//	public static String getMinDiff(int number) {
//		int min=Integer.MAX_VALUE;
//		int minChannel=0;
//		for(int i=0;i<10;i++) {
//			if(btnState[i]==false) {
//				int diff=Math.abs(number-i);
//				if(diff<min) {
//					min=diff;
//					minChannel=i;
//				}
//			}
//		}
//		return Integer.toString(minChannel);
//	}
//}

//따라서 위의 방법대로 하지 않고 아래처럼 모든 가능한 경우의 수에서 target까지의 +, - 누르는 횟수를 센다..
class Main1107{
		private static int minCount;
		private static int target;
		private static int[] targetList;
		private static int count;
		private static int [] buttons;
		private static boolean [] btnState; //true면 사용 불가, false사용가능
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			minCount=Integer.MAX_VALUE;
			String targetLine=br.readLine();
			target=Integer.parseInt(targetLine);
			String[] targetLineSplited=targetLine.split("");
			targetList=new int[targetLineSplited.length];
			for(int i=0;i<targetLineSplited.length;i++) {
				targetList[i]=Integer.parseInt(targetLineSplited[i]);
			}
			count=Integer.parseInt(br.readLine());
			buttons=new int [count];
			btnState=new boolean[10];
			
			if(count!=0) {
				String[] line=br.readLine().split(" ");
				for(int i=0;i<count;i++) {
					buttons[i]=Integer.parseInt(line[i]);
					btnState[buttons[i]]=true;
				}
			}
			
			if(target!=100)
				getRes();
			else
				minCount=0;
			System.out.println(minCount);
		}
		public static void getRes() {
			minCount=Math.abs(target-100);
			
			for(int i=0;i<999999;i++) {//모든 버튼을 누르는 경우를 고려한다
				String str=String.valueOf(i);//i를 string으로
				boolean isBreak=false;
				
				for(int j=0;j<str.length();j++) {//누른 버튼들 중에서 고장난것이 있는지 확인
					int val=Character.getNumericValue(str.charAt(j));
					if(btnState[val]==true) {
						isBreak=true;
						break;
					}
				}
				if(isBreak==false) {//누른 버튼 중 고장난 것이 없는 경우만 고려
					int clickedCount=Math.abs(target-i)+str.length();
					if(clickedCount<minCount)
						minCount=clickedCount;
				}
				
			}
			
		}
}
