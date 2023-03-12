package com.dodo.algoStudyPersonal.forSWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//4:38~6:00 , 10:26~10:37
public class Solve탈주범검거 {
    private static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};//상, 우, 하, 좌
    private static Queue<BreakElement> queue;
    private static boolean[][] visited;
    private static int res;
    private static int n;
    private static int m;
    private static int r;
    private static int c;
    private static int l;
    private static int[][] map;
    private static int[][] tunnel=new int[][] {
        {1,1,0,0,1,1,0  ,1,0,1,0,0,1,1  ,1,1,0,1,0,0,1,   1,0,1,1,1,0,0},
        {1,1,0,0,1,1,0  ,0,0,0,0,0,0,0  ,1,1,0,1,0,0,1,   0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0  ,1,0,1,0,0,1,1  ,0,0,0,0,0,0,0,   1,0,1,1,1,0,0},
        {1,1,0,0,1,1,0  ,1,0,1,0,0,1,1  ,0,0,0,0,0,0,0,   0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0  ,1,0,1,0,0,1,1  ,1,1,0,1,0,0,1,   0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0  ,0,0,0,0,0,0,0  ,1,1,0,1,0,0,1,   1,0,1,1,1,0,0},
        {1,1,0,0,1,1,0  ,0,0,0,0,0,0,0  ,0,0,0,0,0,0,0,   1,0,1,1,1,0,0}
    };//1~7번 터널 이동가능한 다른 타입 터널 map, 상우하좌 순으로 가능하면1, 아니면0
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int testCase=1;testCase<=T;testCase++) {
            queue=new LinkedList<BreakElement>();
            res=0;
            String[] firstLine=br.readLine().split(" ");
            n=Integer.parseInt(firstLine[0]);
            m=Integer.parseInt(firstLine[1]);
            r=Integer.parseInt(firstLine[2]);
            c=Integer.parseInt(firstLine[3]);
            l=Integer.parseInt(firstLine[4]);
            map=new int[n][m];
            visited=new boolean[n][m];
            for(int i=0;i<n;i++) {
                String[] line=br.readLine().split(" ");
                for(int j=0;j<m;j++) {
                    map[i][j]=Integer.parseInt(line[j]);
                }
            }
            getRes();
            System.out.println("#"+testCase+" "+res);
        }
    }
    public static void getRes() {
        res++;
        queue.add(new BreakElement(r,c,1));
        visited[r][c]=true;
        while(queue.isEmpty()==false) {
            BreakElement element=queue.remove();
            if(element.time==l) continue;
            for(int i=0;i<4;i++) {
                int nextRow=element.row+move[i][0];
                int nextCol=element.col+move[i][1];
                if(check(element.row, element.col, nextRow, nextCol, i)) {
                    queue.add(new BreakElement(nextRow,nextCol,element.time+1));
                    res++;
                    visited[nextRow][nextCol]=true;
                }
            }
        }
    }
    public static boolean check(int row, int col, int nextRow, int nextCol, int direction) {
        if(nextRow<0||nextCol<0||nextRow>=n||nextCol>=m)
            return false;
        if(visited[nextRow][nextCol]==true)
            return false;
        int nowTunnel=map[row][col]-1;
        int nextTunnel=map[nextRow][nextCol]-1;
        if(nextTunnel==-1)
            return false;
        int val=direction*7+nextTunnel;
        if(tunnel[nowTunnel][val]==1)
            return true;
        else
            return false;
    }
}
class BreakElement{
    int row;
    int col;
    int time;
    public BreakElement(int row, int col, int time) {
        super();
        this.row = row;
        this.col = col;
        this.time = time;
    }

}

