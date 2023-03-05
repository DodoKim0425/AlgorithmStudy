package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//5:43~6:24~6:32 힌트봄(루트가 무조건 0번째 아닐수있다)
//~6:55 힌트봄(이진트리 아닐수있음)
public class Main1068 {
	private static Main1068Node[] nodes;
	private static int res;
	private static int root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int nodeNumber=Integer.parseInt(br.readLine());
		String[] line=br.readLine().split(" ");
		int delete=Integer.parseInt(br.readLine());
		
		nodes=new Main1068Node[nodeNumber];
		for(int i=0;i<nodeNumber;i++)
			nodes[i]=new Main1068Node();
		for(int i=0;i<nodeNumber;i++) {
			int parent=Integer.parseInt(line[i]);
			if(parent!=-1) {
				nodes[i].setParent(parent);
				nodes[parent].getChilds().add(i);
			}else {
				root=i;
			}
		}
		deleteNode(delete);
		getLeafCount(root);
		System.out.println(res);
	}
	public static void deleteNode(int delete) {
		int deleteParent=nodes[delete].getParent();
		if(deleteParent==-1) {
			nodes[delete]=null;
			return;
		}
		for(int i=0;i<nodes[deleteParent].getChilds().size();i++) {
			if(nodes[deleteParent].getChilds().get(i)==delete) {
				nodes[deleteParent].getChilds().remove(i);
			}
		}
	}
	public static void getLeafCount(int node) {
		if(nodes[node]==null)
			return;
		ArrayList<Integer> childs=nodes[node].getChilds();
		if(childs.size()==0)
			res++;
		else {
			for(int i=0;i<childs.size();i++) {
				getLeafCount(childs.get(i));
			}
		}
	}
}
class Main1068Node{
	private int parent;
	private ArrayList<Integer> childs;
	
	
	public Main1068Node() {
		super();
		this.parent = -1;
		this.childs = new ArrayList<Integer>();
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public ArrayList<Integer> getChilds() {
		return childs;
	}
	public void setChilds(ArrayList<Integer> childs) {
		this.childs = childs;
	}
	
	
}