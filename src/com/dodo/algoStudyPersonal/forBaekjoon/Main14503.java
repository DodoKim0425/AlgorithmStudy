package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14503{
    private static int[][] goBack={{1,0},{0,-1},{-1,0},{0,1}};//각 방향을 바라보고있는 상태에서 뒤로간 위치
    private static int[][] around={{-1,0},{0,1},{1,0},{0,-1}};//번호순으로 각 방향에서 앞으로 가는 위치
    private static int n;//세로길이 
    private static int m;//가로길이
    private static int startRow;
    private static int startCol;
    private static int direction;
    private static int[][] map;
    private static boolean[][] visited;
    private static int res;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine=br.readLine().split(" ");
        String[] secondLine=br.readLine().split(" ");
        n=Integer.parseInt(firstLine[0]);
        m=Integer.parseInt(firstLine[1]);
        startRow=Integer.parseInt(secondLine[0]);
        startCol=Integer.parseInt(secondLine[1]);
        direction=Integer.parseInt(secondLine[2]);
        map=new int[n][m];
        visited = new boolean[n][m];
        res=0;
        
        for(int i=0;i<n;i++){
            String[] line=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(line[j]);
            }
        }
        clean(startRow, startCol, direction);
        System.out.println(res);
	}
	public static void clean(int startRow, int startCol, int startDirection) {
		int nowRow=startRow;
		int nowCol=startCol;
		int nowDirection=startDirection;
		while(true) {
			if(visited[nowRow][nowCol]==false) {
				visited[nowRow][nowCol]=true;
				res++;
			}
			boolean isDirty=false;
			int dirtyRow=0;
			int dirtyCol=0;
			int dirtyDirection=nowDirection;
			while(true) {//반시계방향으로 주위 살핌
				dirtyDirection=rotate(dirtyDirection);
				dirtyRow=nowRow+around[dirtyDirection][0];
				dirtyCol=nowCol+around[dirtyDirection][1];
				if(visited[dirtyRow][dirtyCol]==false && map[dirtyRow][dirtyCol]!=1) {
					isDirty=true;
					break;
				}
				if(dirtyDirection==nowDirection)
					break;
			}
			if(isDirty==false) {//주변이 모두 청소된 상태일때
				int backRow=nowRow+goBack[nowDirection][0];
				int backCol=nowCol+goBack[nowDirection][1];
				if(map[backRow][backCol]==1) {
					break;
				}else {
					nowRow=backRow;
					nowCol=backCol;
				}
			}else {//주변에 청소하지 않은 부분이 있다면
				nowDirection=dirtyDirection;
				nowRow=dirtyRow;
				nowCol=dirtyCol;
			}
		}

	}
    public static int rotate(int direction){
        int newDirection=direction-1;
        if(newDirection==-1){
            newDirection=3;
        }
        return newDirection;
    }

}