package com.dodo.algoStudyPersonal.forProgrammers;

public class Solution네트워크 {

	public static void main(String[] args) {
		Solution43162 s= new Solution43162();
		int res=s.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
		System.out.println(res);

	}

}

class Solution43162 {
    private int[] visited;//방문했다면1 아니라면0
    int answer=0;
    public int solution(int n, int[][] computers) {
        visited=new int [n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                answer++;
                visit(i,computers);
            }
        }
        
        return answer;
    }
    public void visit(int com,int[][]computers){
        visited[com]=1;
        for(int i=0;i<computers.length;i++){
            if(visited[i]==0&&computers[com][i]==1){
                visit(i,computers);
            }
        }
        
    }
}