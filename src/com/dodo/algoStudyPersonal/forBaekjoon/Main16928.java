package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//bfs를 돌면서 이미 방문한곳을 다시 방문해야된다고 생각해서 visited처리를 하지 않았는데 
//그렇게 하면 무한 반복이 발생해서 메모리 초과가 생긴다
//visited처리가 필요하다.. 문제에서 구하는것은 최소 주사위 던짐 횟수인데
//만약 해당 칸을 이전에 이미 방문했던 적 있던 칸이라면 지금보다 더 적은 주사위 던짐 횟수인 상황에서 
//그 칸을 방문한것이므로 굳이 따질 필요도 없을 뿐더러 이렇게 해야 무한반복(사이클인 경우)을 피한다
//그리고 뱀과 사다리 게임을 잘못 이해했다 만약에 주사위 3이 나왔고 중간에 뱀이 있다 해도 딱 그 뱀 칸에 들어가야
//뱀을 타고 올라간다 사다리도 마찬가지. 딱 그칸에 들어가는 주사위가 아니라면 타지 않음
public class Main16928 {
	private static int n;//사다리 수
	private static int m;//뱀의 수
	private static int[] map;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] lineOne=br.readLine().split(" ");
		n=Integer.parseInt(lineOne[0]);
		m=Integer.parseInt(lineOne[1]);
		
		map = new int[100];
		visited = new boolean[100];
		
		for(int i=0;i<100;i++) {
			map[i]=-1;
		}
		
		for(int i=0; i<n+m; i++) {
			String[] line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);
			map[start-1]=end-1;
		}
		
		System.out.println(getRes());
		
	}
	
	public static int getRes() {
		Queue<int[]> q = new LinkedList<int[]>();//현재 노드 번호와 주사위를 던진 횟수저장
		q.add(new int[] {0, 0});
		int minCount=0;
		
		while(q.isEmpty()==false) {
			int[] nowNode=q.remove();
			int now = nowNode[0];//현재 노드 번호
			if(now==99) {//현재 노드 번호가 99 즉 마지막 칸일때
				minCount=nowNode[1];//현재 노드번호까지 가는데 걸린 주사위 수
				break;
			}
			
			for(int i=1;i<=6;i++) {//1~6 주사위 던져서 칸 이동하는 경우
				int nextNode = getNextNumber(now, i);//이동 후 칸 번호 
				if(nextNode != -1 && visited[nextNode]==false) {//이동 가능한 곳일때
					q.add(new int[] {nextNode, nowNode[1]+1});
					visited[nextNode]=true;
				}
			}
		}
		
		return minCount;
	}

	public static int getNextNumber(int now, int dice) {//해당 dice만큼 이동한 칸의 번호를 반환, 마지막칸을 넘어서면 -1 반환
		if(now+dice>99) {//마지막 칸을 벗어나는 경우
			return -1;
		}else {
			int state=map[now+dice];
			if(state==-1) {//map에 -1이 되어있는 경우 사다리, 뱀이 없는 경우임
				return now+dice;
			}else {//사다리, 뱀이 있는 경우 해당 칸으로 이동
				return state;
			}
		}
	}
}


