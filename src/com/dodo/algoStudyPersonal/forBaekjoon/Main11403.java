package com.dodo.algoStudyPersonal.forBaekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//문제를 잘못 이해하고 풀었음
//자기 자신으로 가는경우는 무조건 1이 아니고 자기자신->어떤노드->자기자신 이런식으로 되돌아올때만 1로 표기해야 한다
//단순 연결되어있다고 1표기가 아니고 해당 노드로 갈수있어야 1로 표기, 다른노드를 거쳐 가도 1
public class Main11403 {
	private static int n;
	private static int[][] map;
	private static int[][] res;
	private static boolean[] checked;
	private static Node11403[] nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		res=new int[n][n];
		
		nodes=new Node11403[n];
		for(int i=0;i<n;i++)
			nodes[i]=new Node11403(i);
		
		for(int i=0;i<n;i++) {
			String[] line=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					nodes[i].childs.add(nodes[j]);
				}
			}
		}

		for(int i=0;i<n;i++)//각 정점에서 출발하여 그 정점에서 어디까지 갈수있는지 확인한다
			getRes(i);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void getRes(int start) {
		checked=new boolean[n];
		Stack<Node11403> stack=new Stack<Node11403>();
		stack.add(nodes[start]);
		checked[start]=true;
		while(stack.isEmpty()==false) {
			Node11403 element=stack.pop();
			ArrayList<Node11403> list=element.childs;
			for(int i=0;i<list.size();i++) {
				res[start][list.get(i).num]=1;//start에서 해당 자식으로 갈수있으므로 1표시
				//위 61번 라인을 아래 if문 안에 넣으면 자기자신->다른노드->자기자신으로 돌아가는 경우를 판별할수없게된다
				if(checked[list.get(i).num]==false) {//자식노드의 자식들을 볼 필요가 있는지 확인함
					//true인 경우엔 이미 이 자식노드의 자식들을 다 살펴 보았다는 의미이다
					stack.add(list.get(i));
					checked[list.get(i).num]=true;
				}
			}
		}
	}
}
class Node11403{
	int num;
	ArrayList<Node11403> childs;
	public Node11403(int num) {
		super();
		this.num = num;
		this.childs=new ArrayList<Node11403>();
	}
}
