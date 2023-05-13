package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
//전에 풀었던 벽돌깨기 문제와 유사
//단 map을 돌면서 하나의 군집이 터질때 마다 count+1 이 아니라 한 라운드 마다 +1 해야함!
//터질 수 있는 군집이 만약 현재 map에 2개라면 2개가 동시에 터지므로 count+1만된다 +2가 아님
public class Main11559 {
	private static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};
	private static int count;
	private static String[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		map=new String[12][6];
		for(int i=11;i>=0;i--) {
			map[i]=br.readLine().split("");
		}
		while(true) {
			int puyoCount=0;//현재 map에서 몇개의 군집이 터졌는지 확인
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j].equals(".")==false) {
						if(puyo(i, j, map[i][j]))//현재 탐색한 군집이 터진 경우 puyoCount+1
							puyoCount++;
					}
				}
			}
			if(puyoCount>0) {//한번이라도 지금 map에서 터진 뿌요가 있다면 map을 새로 세팅하고 count++한다
				count++;
				setMap();
			}else {//한번도 터진 뿌요가 없다면 앞으로 map에 변화가 없을예정이므로 바로 빠져나온다
				break;
			}
				
		}
		

		System.out.println(count);
	}
	private static boolean puyo(int row, int col, String color) {
		boolean state = false;
		boolean[][] visited=new boolean[12][6];
		ArrayList<int[]> list = new ArrayList<int[]>();//군집의 개체를 넣는 리스트
		Stack<int[]> stack = new Stack<int[]>();
		stack.add(new int[] {row, col});
		visited[row][col]=true;
		list.add(new int[] {row,col});
		
		while(stack.isEmpty()==false) {//군집을 찾는다
			int[] element = stack.pop();
			for(int i=0;i<4;i++) {
				int nextRow=element[0]+move[i][0];
				int nextCol=element[1]+move[i][1];
				if(check(nextRow, nextCol, color, visited)) {
					visited[nextRow][nextCol]=true;
					int[] newElement = new int[] {nextRow, nextCol};
					stack.add(newElement);
					list.add(newElement);
				}
			}
		}
		if(list.size()>=4) {//군집 개체수가 4 이상인 경우에
			state=true;
			for(int[] element:list) {
				map[element[0]][element[1]]=".";
			}
		}
		return state;
	}
	
	private static void setMap() {//중력에 의해 뿌요들이 아래로 내려가도록 함
		for(int i=0;i<6;i++) {
			Stack<String> stack =new Stack<String>();
			for(int j=0; j<12; j++) {
				if(map[j][i].equals(".")==false) {
					stack.add(map[j][i]);
				}
			}
			for(int j=stack.size();j<12;j++) {
				map[j][i]=".";
			}
			while(stack.isEmpty()==false) {
				map[stack.size()-1][i]=stack.pop();
			}
		}
	}
	
	private static boolean check(int nextRow, int nextCol, String color, boolean[][]visited) {
		if(nextRow>=12 || nextCol>=6 || nextRow<0 || nextCol<0) {
			return false;
		}
		if(visited[nextRow][nextCol]==true) {
			return false;
		}
		if(map[nextRow][nextCol].equals(color)==false)
			return false;
		
		return true;
	}
}
