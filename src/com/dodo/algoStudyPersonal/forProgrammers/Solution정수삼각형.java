package com.dodo.algoStudyPersonal.forProgrammers;

public class Solution정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = {
				{7},
				{3,8},
				{8,1,0},
				{2,7,4,4},
				{4,5,2,6,5}
		};
		Solution43105 sol = new Solution43105();
		System.out.println(sol.solution(triangle));
	}

}

class Solution43105 {
    public int[][] dp;
    
    public int solution(int[][] triangle) {
        int tableHeight=triangle.length;
        int tableWidth=triangle[triangle.length-1].length;
        
        dp = new int[tableHeight][tableWidth];
        
        dp[0][0]=triangle[0][0];
        for(int i=1;i<tableHeight;i++){//삼각형의 양 맨 끝에 있는값들은 하나의 값밖에 내려받을 수 없다
            dp[i][0]=dp[i-1][0]+triangle[i][0];
            dp[i][i]=dp[i-1][i-1]+triangle[i][i];
        }
        
        for(int i=2;i<tableHeight;i++){//그 외의 값들을 테이블에 넣는다
            for(int j=1;j<i;j++){
            	//dp[i][j]의 바로 위 양옆으로 있는 값 중 큰것을 골라서 triangle[i][j]에 있는 값과 더하면 그 위치에서 내려 받아 가질 수 있는 가장 큰 값이 된다 
                dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
            }
        }
        
        int max = dp[tableHeight-1][0];
        
        for(int i=1;i<tableWidth;i++){//삼각형 가장 아래에 있는 값들 중 가장 큰 값을 찾는다
            if(max<dp[tableHeight-1][i]){
                max=dp[tableHeight-1][i];
            }
        }
        
        
        return max;
    }
}