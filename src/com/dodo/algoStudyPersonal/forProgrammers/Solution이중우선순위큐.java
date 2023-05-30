package com.dodo.algoStudyPersonal.forProgrammers;
import java.util.*;
import java.io.*;

public class Solution이중우선순위큐 {
	public static void main(String[] args) {
		String[] op = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		Solution42628 sol = new Solution42628();
		int[] res = sol.solution(op);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}
}

class Solution42628{
    private ArrayList<Integer> list;//오름차순 정렬된 리스트
    
    public int[] solution(String[] operations) {
        int[] ans = {0,0};
        list = new ArrayList<Integer>();
        
        for(int i=0;i<operations.length;i++){
            doOperations(operations[i]);
        }
        
         if(list.size()!=0){
             ans[0]= list.get(list.size()-1);
             ans[1]= list.get(0);
        }
        return ans;
    }
    
    public void doOperations(String op){
        String[] operationList = op.split(" ");
        
        if(operationList[0].equals("D")&& operationList[1].equals("-1") && list.size()>0){
        	//operation이 D -1 인 경우, 가장 작은 값 빼기위해서 size검사도 해야된다
            list.remove(0);//정렬되어있으므로 0번째 값 빼면된다
            
        }else if(operationList[0].equals("D")&& operationList[1].equals("1") && list.size()>0){
        	//operation이 D 1 인 경우, 가장 큰 값 빼기위해서 size검사도 해야된다
            int size = list.size()-1;
            list.remove(size);//정렬되어 있으므로 가장 마지막에 있는 값 빼면된다
            
        }else if(operationList[0].equals("I")){
        	//operation이 I 인 경우
            int val= Integer.parseInt(operationList[1]);
            insertValue(val);
        }
    }
    
    public void insertValue(int val){//list에 값을 삽입하는 함수
        int size=list.size();
        if(size==0){//list가 빈 경우 그냥 값을 넣는다
            list.add(val);
        }else{
            for(int i=0;i<size;i++){
                if(list.get(i)>val){//넣을 값 보다 큰 값을 찾으면 그 값 앞에 값을 삽입한다
                    list.add(i, val);
                    break;//삽입했으므로 바로 빠져나온다
                }
                if(i==size-1){//i가 size-1이 될때까지 위의 break를 하지 못한것은 val이 가장 큰 경우이다
                    list.add(val);
                }
            } 
        }
   
    }
    
    
}