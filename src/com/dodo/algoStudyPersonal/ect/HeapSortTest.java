package com.dodo.algoStudyPersonal.ect;

//참고블로그:https://zoosso.tistory.com/705
public class HeapSortTest {
	public static void main(String[] args) {
		int[] array = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
		heapSort(array, array.length);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void heapSort(int[] array, int n) {
		for(int i=(n/2)-1 ; i>=0; i--) {
			//n/2-1 부터 시작하는 이유는 이 위치가 자식을 가지는 마지막 노드이기 때문임
			//가장 작은 서브트리부터 시작해서 값을 비교해 서브트리들을 맥스힙으로 만들어주면서 점차적으로 올라가는 형태이므로 
			//자식을 가지는 마지막 노드부터 맥스힙으로 변경을 시작하는것
			heapify(array, n, i);
		}
		// Root에 위치한 최대값을 마지막 노드와 바꿔가며 Heap 재구성
	    // Heap의 크기를 줄여가며 값이 큰 원소를 차례로 가져옵니다.
	    for (int i = n - 1; i > 0; i--) {
	    	int temp= array[0];
	    	array[0]=array[i];
	    	array[i]=temp;
	        heapify(array, i, 0);
	    }
	}
	public static void heapify(int array[], int n, int i) {
		//i번 인덱스 밑으로 존재하는 트리를 맥스힙으로 만든다
		int parentIdx=i;
		while(true) {
			if(parentIdx*2+1>=n) {//현재 인덱스 자식 없는 경우
				break;
			}
			int leftChildNode = parentIdx * 2 + 1;
		    int rightChildNode = parentIdx * 2 + 2;
		    int maxChild=array[leftChildNode];
		    int maxPos=leftChildNode;
		    if(rightChildNode<n && array[rightChildNode]>maxChild) {
		    	//오른쪽 자식이 존재하고 오른쪽이 왼쪽보다 클때
				maxChild=array[rightChildNode];//더 큰 자식을 선택한다
				maxPos=rightChildNode;
		    }
		    	
		    if(array[parentIdx]>=maxChild) {//큰 자식보다 부모가 크면 변경 종료
		    	break;
		    }else {//큰 자식과 부모를 바꾸고 아래로 내려간다
				int temp=array[parentIdx];
				array[parentIdx]=maxChild;
				array[maxPos]=temp;
				parentIdx=maxPos;
		    }
		}
	}
	
}
