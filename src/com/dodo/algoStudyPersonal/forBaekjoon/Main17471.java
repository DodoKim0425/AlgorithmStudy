package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//10:49~1:1 중간에 40분 정도 쉬어서 실제 풀이시간은 1시간 40분?
public class Main17471 {
	private static int minDiff;
	private static int count;
	private static Main17471Node[] nodes;
	private static int[] aArea;
	private static int[] bArea;
	private static boolean[] areaVistied;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		minDiff=-1;
		count=Integer.parseInt(br.readLine());
		nodes=new Main17471Node[count+1];
		String[] peopleCounts=br.readLine().split(" ");
		
		for(int i=1;i<=count;i++) {
			nodes[i]=new Main17471Node();
			nodes[i].setNumber(i);
			nodes[i].setPeopleCount(Integer.parseInt(peopleCounts[i-1]));
		}
		for(int i=1;i<=count;i++) {
			String[] line=br.readLine().split(" ");
			int nearCityCount=Integer.parseInt(line[0]);
			int[] nearCityList=new int[nearCityCount];
			for(int j=0;j<nearCityCount;j++) {
				nearCityList[j]=Integer.parseInt(line[j+1]);
			}
			nodes[i].setNearCity(nearCityList);
			nodes[i].setNearCityCount(nearCityCount);
		}
		for(int i=1;i<count;i++) {
			areaVistied=new boolean[count+1];
			aArea=new int[i];
			bArea=new int[count-i];
			getMinDiff(i, 0, 1);
		}
		System.out.println(minDiff);
	}
	public static void getMinDiff(int until, int depth, int start) {
		if(until==depth) {
			int top=0;
			for(int i=1;i<=count;i++) {
				if(areaVistied[i]==false) {
					bArea[top]=i;
					top++;
				}
			}
			if(isConnected(aArea) && isConnected(bArea))
				calcDiff();
		}else {
			for(int i=start;i<=count;i++) {
				if(areaVistied[i]==false) {
					
					areaVistied[i]=true;
					aArea[depth]=i;
					getMinDiff(until, depth+1, i+1);
					areaVistied[i]=false;
					
				}
			}
		}
	}
	public static boolean isConnected(int[] area) {
		int count=1;
		boolean[] areaVisited=new boolean[area.length];
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(area[0]);
		areaVisited[0]=true;
		while(stack.isEmpty()==false) {
			int element=stack.pop();
			Main17471Node node=nodes[element];
			int[] childs=node.getNearCity();
			for(int i=0;i<childs.length;i++) {
				for(int j=0;j<area.length;j++) {
					if(childs[i]==area[j]&&areaVisited[j]==false) {
						areaVisited[j]=true;
						stack.push(area[j]);
						count++;
					}
				}
			}
		}
		if(count==area.length)
			return true;
		else
			return false;
	}
	public static void calcDiff() {
		int aPeople=0;
		int bPeople=0;
		for(int i=0;i<aArea.length;i++) {
			aPeople+=nodes[aArea[i]].getPeopleCount();
		}
		for(int i=0;i<bArea.length;i++) {
			bPeople+=nodes[bArea[i]].getPeopleCount();
		}
		
		if(Math.abs(aPeople-bPeople)<minDiff || minDiff==-1) {
			minDiff=Math.abs(aPeople-bPeople);
		}
	}
}
class Main17471Node{
	private int number;
	private int peopleCount;
	private int nearCityCount;
	private int[] nearCity;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public int getNearCityCount() {
		return nearCityCount;
	}
	public void setNearCityCount(int nearCityCount) {
		this.nearCityCount = nearCityCount;
	}
	public int[] getNearCity() {
		return nearCity;
	}
	public void setNearCity(int[] nearCity) {
		this.nearCity = nearCity;
	}
	
}
