package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//s가 0인 경우 모든 숫자를 안 선택한 경우는 제외해야한다
public class Main1182 {
	private static int n;// 정수의 개수
	private static int s;// 이 값이 되어야함
	private static int[] numbers;
	private static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		String[] secondLine = br.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		s = Integer.parseInt(firstLine[1]);
		numbers = new int[n];
		res = 0;

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(secondLine[i]);
		}
		getRes(0, 0);
		if (s == 0)
			res--;
		System.out.println(res);
	}

	public static void getRes(int count, int sum) {
		if (count == n) {
			if (s == sum) {
				res++;
			}

		} else {

			getRes(count + 1, sum + numbers[count]);
			getRes(count + 1, sum);

		}
	}
}
