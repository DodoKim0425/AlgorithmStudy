package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//문제 이해가 어려웠음
//한 노드에서 다른 노드를 방문하는데 중복없이 5개 노드를 방문할 수 있는지 확인하라는 문제이다
//양방향 엣지를 둬야 함
public class Main13023 {
	private static Node13023[] persons;
	private static boolean[] visited;
	private static int n;
	private static int m;
	private static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine=br.readLine().split(" ");
		n=Integer.parseInt(firstLine[0]);
		m=Integer.parseInt(firstLine[1]);
		persons=new Node13023[n];
		for(int i=0;i<n;i++) {
			persons[i]=new Node13023(i);
		}
		for(int i=0;i<m;i++) {
			String[] line=br.readLine().split(" ");
			int person1 = Integer.parseInt(line[0]);
			int person2 = Integer.parseInt(line[1]);
			persons[person1].friends.add(persons[person2]);
			persons[person2].friends.add(persons[person1]);
		}
		for(int i=0; i<n; i++) {//각노드를 차례대로 어디까지 노드 방문이 가능한지 체크
			visited=new boolean[n];
			getRes(i, 0);
			if(res==1) {//이미 연속 방문 가능한 노드 5 이상인것을 찾았으면 반복 종료 
				break;
			}
		}
		System.out.println(res);
	}
	
	public static void getRes(int startNode ,int depth) {
		if(res!=1) {//이미 중복없이 방문한 노드 5인것을 찾았으면 볼 필요 없음
			if(depth==5) {//중복없이 방문한 노드 5이상일때 res+1
				res=1;
			}else {
				ArrayList<Node13023> list = persons[startNode].friends;
				for(Node13023 element:list) {
					if(visited[element.number]==false) {
						visited[element.number]=true;
						getRes(element.number, depth+1);
						visited[element.number]=false;
					}
				}
			}
		}

	}
}

class Node13023{
	int number;
	ArrayList<Node13023> friends;
	Node13023(int number){
		this.number=number;
		friends=new ArrayList<Node13023>();
	}
}
