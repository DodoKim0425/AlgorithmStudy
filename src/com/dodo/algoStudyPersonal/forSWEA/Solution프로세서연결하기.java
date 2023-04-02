package com.dodo.algoStudyPersonal.forSWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
class Solution프로세서연결하기
{
    private static int[][] move= {{-1,0},{0,1},{1,0},{0,-1}};
    private static int[][] map;
    private static ArrayList<int[]> cores;//전선 연결을 할 코어들
    private static int maxCoreNumber;//최대한 많은 코어를 연결한 수
    private static int minLen;//최소 전선 길이
    private static int n;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         int caseNumber=Integer.parseInt(br.readLine());
         for(int testCase=1;testCase<=caseNumber;testCase++) {
             n=Integer.parseInt(br.readLine());
             map=new int[n][n];
             cores=new ArrayList<int[]>();
             minLen=Integer.MAX_VALUE;
             maxCoreNumber=0;
             for(int i=0;i<n;i++) {
                 String[] line=br.readLine().split(" ");
                 for(int j=0;j<n;j++) {
                     map[i][j]=Integer.parseInt(line[j]);
                     if(map[i][j]==1 && i!=0 && i!=n-1 && j!=0 && j!=n-1) {//벽에 붙은 코어는 생각하지 않는다
                         cores.add(new int[] {i, j});
                     }
                 }
             }
             getRes(0, 0, 0);
             System.out.println("#"+testCase+" "+minLen);
              
         }
    }
    public static void getRes(int count, int len, int connectedCore) {
        //count= 연결 가능한지 아닌지 확인한 코어의 수 
        if(count==cores.size()) {
            if(connectedCore>maxCoreNumber) {
                maxCoreNumber=connectedCore;
                minLen=len;
            }
            else if(connectedCore==maxCoreNumber) {
                if(len<minLen) {
                    minLen=len;
                }
            }
        }else {
        	//cores.size() = 총 코어의 수, count= 연결할지 안할지 이미고려된 코어의 수, connectedCore=전선을 연결한 코어수
        	//cores.size()-count=앞으로 연결 가능성 있는 코어들, connectedCore=이미 연결한 코어
        	//연결가능성 있는 코어+이미연결한 코어 가 maxCoreNumber보다 작으면 어차피 가능성 있는 코어를 다 연결해도 최대보다 작으므로 할 필요없음, 이 부분에서 시간 절약이 많이 됩니다
            if(cores.size()-count+connectedCore<maxCoreNumber)
                return;
            int row = cores.get(count)[0];// 연결할 코어
            int col = cores.get(count)[1];
            for (int j = 0; j < move.length; j++) {//4방향 체크
                if (check(row, col, j)) {//해당 방향으로 선을 그을수 있는 경우
                    ArrayList<int[]> line = getLine(row, col, j);
                    drawLine(line);
                    getRes(count + 1, len + line.size(), connectedCore+1);
                    eraseLine(line);
                }else {
                    getRes(count+1, len, connectedCore);
                }
            }
             
        }
    }
    public static boolean check(int row, int col, int direction) {//해당 방향으로 선을 그을수있는지 확인
        while(true) {
            row+=move[direction][0];
            col+=move[direction][1];
            if(row>=n || row<0 || col>=n || col<0)
                break;
            if(map[row][col]==1)//1이 있다는것은 전선이 있거나 코어가 있다는뜻
                return false;
        }
        return true;
    }
    public static ArrayList<int[]> getLine(int row, int col, int direction) {//방향에 따라 선을 긋는 부분을 반환
        ArrayList<int[]> line=new ArrayList<int[]>();
        while(true) {
            row+=move[direction][0];
            col+=move[direction][1];
            if(row>=n || row<0 || col>=n || col<0)
                break;
            line.add(new int[] {row, col});
        }
        return line;
    }
    public static void drawLine(ArrayList<int[]> line) {//1로 map에 선을 긋는다
        for(int i=0;i<line.size();i++) {
            map[line.get(i)[0]][line.get(i)[1]]=1;
        }
    }
    public static void eraseLine(ArrayList<int[]> line) {//그은 선을 지운다
        for(int i=0;i<line.size();i++) {
            map[line.get(i)[0]][line.get(i)[1]]=0;
        }
    }
}