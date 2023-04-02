package com.dodo.algoStudyPersonal.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxHeapTreeTest {
	//참고블로그: go-coding.tistory.com/25 
	//참고블로그: velog.io/@redgem92/자료구조-힙-트리Heap-Tree 
	public static void main(String[] args) throws IOException {
		MaxHeapTree tree=new MaxHeapTree(2);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line=br.readLine().split(" ");
		for(int i=0;i<line.length;i++) {
			tree.insert(Integer.parseInt(line[i]));
		}
		int count=tree.pushPos;
		int[] list=tree.nodes;
		for(int i=0;i<list.length;i++)
			System.out.print(list[i]+" ");
		System.out.println("\n--------");
		for(int i=0;i<count-1;i++) {
			System.out.print(tree.pop()+" ");
		}
	}
	
}
class MaxHeapTree{
	int[] nodes;
	int pushPos;
	public MaxHeapTree(int size) {
		nodes=new int[size];
		this.pushPos=1;
	}
	public int getParent(int idx) {//자식인덱스로 부모 인덱스 반환
		return idx/2;
	}
	public int getLeftChild(int idx) {//부모 인덱스로 왼쪽 자식 인덱스 반환
		return idx*2;
	}
	public int getRightChild(int idx) {//부모 인덱스로 오른쪽 자식 인덱스 반환
		return idx*2+1;
	}
	private void resize() {
		int[] newNodes=new int[nodes.length*2];
		for(int i=0;i<nodes.length;i++) {
			newNodes[i]=nodes[i];
		}
		this.nodes=null;
		this.nodes=newNodes;
	}
	public void insert(int x) {
		if(pushPos>=nodes.length) {//배열 공간이 모자란 경우 공간을 늘린다
			resize();
		}
		nodes[pushPos]=x;
		int nowIdx=pushPos;
		while(true) {
			int parentIdx=getParent(nowIdx);
			if(parentIdx==0)
				break;
			if(nodes[nowIdx]>nodes[parentIdx]) {
				int temp=nodes[nowIdx];
				nodes[nowIdx]=nodes[parentIdx];
				nodes[parentIdx]=temp;
				nowIdx=parentIdx;
			}else {
				break;
			}
		}
		pushPos++;
	}
	public int pop(){
		if(pushPos==1)
			return -1;
		int root=nodes[1];//힙트리의 삭제는 루트에서 한다
		nodes[1]=nodes[pushPos-1];//가장 마지막 노드를 루트로 올린다.
		pushPos--;
		
		int nowIdx=1;
		while(true) {
			if(nowIdx*2>=pushPos) {//현재 인덱스의 자식이 없는 경우
				break;
			}else {
				int leftChild=getLeftChild(nowIdx);
				int rightChild=getRightChild(nowIdx);
				int maxChild=nodes[leftChild];
				int maxPos=leftChild;
				if(rightChild < pushPos && nodes[rightChild]>maxChild) {//오른쪽 자식 존재하고 왼쪽 자식보다 오른쪽이 더 클때
					maxChild=nodes[rightChild];
					maxPos=rightChild;
				}
				if(nodes[nowIdx]>maxChild) {//부모가 더 크므로 교환 종료
					break;
				}else {
					int temp=nodes[nowIdx];
					nodes[nowIdx]=maxChild;
					nodes[maxPos]=temp;
					nowIdx=maxPos;
				}
			}
		}
		return root;
	}
}