package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14891 {
	private static int [][] gear;
	private static int [] order= {0,1,2,3};
	private static int [][] pointers= {
			{6,0,2},{6,0,2},{6,0,2},{6,0,2}
	};	
	private static Rotation[] rotate;
	private static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		gear=new int[4][8];
		for(int i=0;i<4;i++) {
			String[] line=br.readLine().split("");
			for(int j=0;j<line.length;j++) {
				gear[i][j]=Integer.parseInt(line[j]);
			}
		}
		int rotateNum=Integer.parseInt(br.readLine());
		rotate=new Rotation[rotateNum];
		for(int i=0;i<rotateNum;i++) {
			String[] line=br.readLine().split(" ");
			rotate[i]=new Rotation(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
		}

		rotate();
		calcRes();
		System.out.println(res);
	}
	public static void rotate() {
		Queue<Rotation> queue=new LinkedList<Rotation>();
		for(int i=0;i<rotate.length;i++) {
			boolean[] visited=new boolean[order.length];
			queue.add(new Rotation(rotate[i].gearNumber-1, rotate[i].direction));
			visited[rotate[i].gearNumber-1]=true;
			while(queue.isEmpty()==false) {
				Rotation now=queue.remove();
				int nextDirection=-1;
				if(now.direction==-1) {
					nextDirection=1;
				}
				
				int rightPos=now.gearNumber+1;
				int leftPos=now.gearNumber-1;
				if(check(now.gearNumber, rightPos, 1, visited)) {
					queue.add(new Rotation(rightPos, nextDirection));
					//오른쪽 기어 회전
					visited[rightPos]=true;
				}
				if(check(now.gearNumber, leftPos, 0, visited)) {
					queue.add(new Rotation(leftPos, nextDirection));
					//왼쪽 기어 회전
					visited[leftPos]=true;
				}
				//현재 기어 회전
				pointers[now.gearNumber]=rotateGears(pointers[now.gearNumber], now.direction);
			}

		}
	}
	public static boolean check(int gearPos, int nextGearPos, int direction, boolean[] visited) {
		if(nextGearPos==-1 || nextGearPos==4)
			return false;
		if(visited[nextGearPos]==true)
			return false;
		if(direction==0) {//왼쪽
			if(gear[gearPos][pointers[gearPos][0]]!=gear[nextGearPos][pointers[nextGearPos][2]]) {
				return true;
			}else
				return false;
		}else {//오른쪽
			if(gear[gearPos][pointers[gearPos][2]]!=gear[nextGearPos][pointers[nextGearPos][0]]) {
				return true;
			}else
				return false;
		}
	}
	public static int[] rotateGears(int[] pos, int direction) {
		if(direction==-1) {//반시계방향 회전
			int[] newPos=new int[pos.length];
			for(int i=0;i<pos.length;i++) {
				if(pos[i]==7) {
					newPos[i]=0;
				}else {
					newPos[i]=pos[i]+1;
				}
			}
			return newPos;
		}else {
			int[] newPos=new int[pos.length];
			for(int i=0;i<pos.length;i++) {
				if(pos[i]==0) {
					newPos[i]=7;
				}else {
					newPos[i]=pos[i]-1;
				}
			}
			return newPos;
		}

	}
	public static void calcRes() {
		if(gear[0][pointers[0][1]]==1)
			res+=1;
		if(gear[1][pointers[1][1]]==1)
			res+=2;
		if(gear[2][pointers[2][1]]==1)
			res+=4;
		if(gear[3][pointers[3][1]]==1)
			res+=8;
	}

}
class Rotation{
	int gearNumber;
	int direction;
	public Rotation(int gearNumber, int direction) {
		this.direction=direction;
		this.gearNumber=gearNumber;
	}
}
