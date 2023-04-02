package com.dodo.algoStudyPersonal.ect;

public class CountingSortTest {
	private static int[] countArray;
	private static int[] sortedData;
	private static int max;
	public static void main(String[] args) {
		int[] inputData= {5, 4, 5, 2, 1, 3, 5, 1, 2};
		for(int i=0;i<inputData.length;i++) {//인풋에서 가장 큰 값 구하기
			if(max<inputData[i])
				max=inputData[i];
		}
		countArray=new int[max+1];
		sortedData=new int[inputData.length];
		
		for(int i=0;i<inputData.length;i++) {//카운팅
			countArray[inputData[i]]++;
		}
		for(int i=1;i<=max;i++) {//누적합 만들기
			countArray[i]+=countArray[i-1];
		}
		for(int i=inputData.length-1; i>=0; i--) {//결과 배열 만들기
			int value=inputData[i];
			countArray[value]--;
			sortedData[countArray[value]]=value;
		}
		
		for(int i=0;i<sortedData.length;i++)
			System.out.print(sortedData[i]+" ");
		
	}

}
