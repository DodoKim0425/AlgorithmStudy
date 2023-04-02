package com.dodo.algoStudyPersonal.forBaekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main1325 {
	private static int max;
	private static int n;//컴퓨터 수
	private static int m;//엣지 수
	private static Node1325[] computers;
	private static boolean[] visited;
	private static StringBuilder maxComps;
	private static int[] countList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		n=Integer.parseInt(line[0]);
		m=Integer.parseInt(line[1]);
		computers=new Node1325[n+1];
		maxComps=new StringBuilder();
		countList=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			computers[i]=new Node1325();
			computers[i].num=i;
		}
			
		for(int i=0;i<m;i++) {
			String[] str=br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			computers[b].trust.add(computers[a]);
		}
		for(int i=1;i<=n;i++) {
			getRes(i);
		}
		for(int i=1;i<=n;i++) {
			max=Math.max(max, countList[i]);
		}
		for(int i=1;i<=n;i++) {
			if(max==countList[i]) {
				maxComps.append(i+" ");
			}
		}
		System.out.println(maxComps);
	}
	public static void getRes(int start) {
		int count=0;
		visited=new boolean[n+1];
		Stack<Node1325> stack=new Stack<Node1325>();
		stack.add(computers[start]);
		visited[start]=true;
		while(stack.isEmpty()==false) {
			Node1325 node=stack.pop();
			ArrayList<Node1325> list=node.trust;
			for(int i=0;i<list.size();i++) {
				if(visited[list.get(i).num]==false) {
					visited[list.get(i).num]=true;
					count++;
					stack.push(list.get(i));
				}
			}
		}
		countList[start]=count;
	}
}

class Node1325{
	int num;
	ArrayList<Node1325> trust;//이 컴퓨터를 신뢰하는 컴퓨터들
	public Node1325() {
		this.num=-1;
		this.trust=new ArrayList<Node1325>();
	}
}