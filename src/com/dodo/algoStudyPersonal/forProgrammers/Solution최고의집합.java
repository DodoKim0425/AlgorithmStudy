package com.dodo.algoStudyPersonal.forProgrammers;

public class Solution최고의집합 {

	public static void main(String[] args) {
		Solution12938 s = new Solution12938();
		int[] list = s.solution(4, 9);
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
	}

}
//곱이 최대가 되는 집합을 구하기 위해 합이 s인 집합을 모두 구할 필요는 없음
//s/n 하고 나머지를 1씩 분배한다
//최고의 집합이 존재하지 않는 경우는 숫자 s를 n개로 나눌 수 없는 경우이다
class Solution12938 {
 public int[] solution(int n, int s) {
     int[] answer = new int[n];
     
     if(s/n<1){
         return new int[] {-1};
     }
     
     int left = s%n;
     
     for(int i=0;i<n;i++){
         answer[i]=s/n;
     }
     
     for(int i=answer.length-1;i>1;i--){
         if(left>0){
             answer[i]++;
             left--;
         }
     }
     
     
     return answer;
 }
}