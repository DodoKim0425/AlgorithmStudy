package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


public class Main1941 {
    private static long test;
    private static int res;//경우의 수 저장
    private static ArrayList<Student> students;//전체 학생 저장
    private static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};//4방 확인에 사용
    private static int size=5;//학생 자리 5*5
    private static Student[] members;
    private static Stack<Student> stack;
    private static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=1;
        students=new ArrayList<Student>();//전체 학생들

        stack=new Stack<Student>();//인접 확인에 사용함
        visited=new boolean[7];//인접 확인에 사용함

        members=new Student[7];//7공주파 가입멤버

	    try {
	        for(int i=0;i<size;i++) {
	            char[] line=br.readLine().toCharArray();
	            for(int j=0;j<size;j++) {
	                Student student=new Student(line[j],new int[] {i,j}, num);
	                students.add(student);
	                num++;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    combination(0, 0, 0);
	    System.out.println(res);
	}
	
	public static void combination(int start,int memberNum, int sNum) {
	    
	    if(memberNum==7 && sNum>=4) {//모집 멤버가 7명이면 재귀호출 종료된다.
	        
	        
	        if(check()==true) {
	            res++;
	        }
	        
	        return;
	    }else if (memberNum==4 && sNum<1){//4명 모집, S파 하나도 없으면 제외
	        return;
	    }else if (memberNum==5 && sNum<2){
	        return;
	    }else if (memberNum==6 && sNum<3){
	        return;
	    }else if(memberNum<7){
	        for(int i=start;i<size*size;i++) {
	            //멤버 한명 추가 
	            Student newMember=students.get(i);
	            members[memberNum]=newMember;
	            if(newMember.team=='S') {
	                combination(i+1, memberNum+1, sNum+1);
	            }else {
	                combination(i+1, memberNum+1 ,sNum);
	            }    
	        }
	    }
	}
	public static boolean check() {
		int count=1;
		
		visited=new boolean[7];
        visited[0]=true;
        stack.push(members[0]);
		
	    while(stack.size()!=0) {
	    	Student student=stack.pop();
	    	for(int i=1;i<7;i++) {
	    		if(visited[i]==false) {
	    			for(int j=0;j<4;j++) {
	    				int nextRow=student.seat[0]+move[j][0];
	    				int nextCol=student.seat[1]+move[j][1];
	    				if(nextRow==members[i].seat[0] && nextCol==members[i].seat[1]) {
	    					stack.push(members[i]);
	    					visited[i]=true;
	    					count++;
	    				}
	    			}
	    		}
	    	}
	    }
	    if(count==7)
	    	return true;
	    else
	    	return false;
	}
}

class Student{
    char team;//어느 파인지
    int[] seat;//자리
    int number;//번호
    public Student(char team, int[] seat, int number) {
        this.team=team;
        this.seat=seat;
        this.number=number;
    }

}