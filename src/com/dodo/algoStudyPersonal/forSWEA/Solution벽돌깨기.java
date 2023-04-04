package com.dodo.algoStudyPersonal.forSWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution벽돌깨기 {
	private static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};
	private static int n;//구슬 숫자
	private static int w;//가로길이
	private static int h;//세로길이
	private static int[][] map;//벽돌들
	private static int brickCount;//벽돌수
	private static int maxBrokeBrick;//최대로 깬 벽돌
	private static Queue<Brick> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int caseNumber=Integer.parseInt(br.readLine());
		for(int testCase=1;testCase<=caseNumber;testCase++) {
			String[] firstLine=br.readLine().split(" ");
			n=Integer.parseInt(firstLine[0]);
			w=Integer.parseInt(firstLine[1]);
			h=Integer.parseInt(firstLine[2]);
			brickCount=0;
			maxBrokeBrick=0;
			map=new int[h][w];

			queue=new LinkedList<Brick>();
			
			for(int i=0;i<h;i++) {
				String[] line=br.readLine().split(" ");
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(line[j]);
					if(map[i][j]!=0) {
						brickCount++;
					}
				}
			}
			
			getRes(0, new int[n]);
			System.out.println("#"+testCase+" "+(brickCount-maxBrokeBrick));
		}
	}
	
	public static void getRes(int count, int[] picked) {//중복순열로하여 구슬을 떨어뜨리는 위치의 순서를 정함
		if(count==n) {
			bfs(picked);//순서에 맞게 구슬을 떨어뜨린다
		}else {
			for(int i=0;i<w;i++) {
				picked[count]=i;
				getRes(count+1, picked);
			}
		}
	}
	public static void bfs(int[] picked) {//뽑은순서에 맞게 구슬을 떨어뜨림
		int count=0;
		int[][] copyMap=new int[h][w];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<picked.length;i++) {
			int nowCol=picked[i];
			int nowRow=0;
			for(int j=0;j<h;j++) {//해당 col에서 가장 위에 있는 블록을 찾는다
				if(copyMap[j][nowCol]!=0) {
					nowRow=j;
					break;
				}
			}
			
			if(check(nowRow, nowCol, copyMap)) {
				queue.add(new Brick(nowRow, nowCol, copyMap[nowRow][nowCol]));
				copyMap[nowRow][nowCol]=0;
				count++;
			}

			
			while(queue.isEmpty()==false) {
				Brick now=queue.remove();
				int val=now.val;
				for(int m=0;m<move.length;m++) {//4방향을 살핀다
					for(int e=1;e<=val-1;e++) {//블록에 적혀있는 숫자에서 -1 한 만큼 사방을 본다
						int nextRow=now.row+(move[m][0]*e);
						int nextCol=now.col+(move[m][1]*e);
						if(check(nextRow, nextCol, copyMap)) {
							queue.add(new Brick(nextRow, nextCol, copyMap[nextRow][nextCol]));
							copyMap[nextRow][nextCol]=0;
							count++;
						}
					}
				}
			}
			
			copyMap=reshapeMap(copyMap);//현재 순서에서 깨져야되는 블록은 다 깨졌으므로 맵을 새로고침
			if(count==brickCount) {//돌던 도중 모든 블록이 깨졌을때 종료
				maxBrokeBrick=count;
				return;
			}
				
		}
		if(count>maxBrokeBrick) {
			maxBrokeBrick=count;
		}
	}
	public static boolean check(int row, int col, int[][] copyMap) {
		if(row>=h||col>=w||row<0||col<0)
			return false;
		if(copyMap[row][col]==0)
			return false;
		return true;
	}
	public static int[][] reshapeMap(int[][] map){//깨지지 않은 블록이 아래로 내려오도록함
		int[][] reshapedMap=new int[h][w];
		
		for(int i=0;i<w;i++) {
			int bottom=h-1;
			for(int j=h-1;j>=0;j--) {
				if(map[j][i]!=0) {
					reshapedMap[bottom][i]=map[j][i];
					bottom--;
				}
			}
		}

		return reshapedMap;
	}
}
class Brick{
	int row;
	int col;
	int val;
	public Brick(int row, int col, int val) {
		this.row=row;
		this.col=col;
		this.val=val;
	}
}