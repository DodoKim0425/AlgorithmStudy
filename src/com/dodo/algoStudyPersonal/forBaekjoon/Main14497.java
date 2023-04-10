package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//문제 자체가 이해 안가서 힌트 잠깐 봄
public class Main14497 {
	private static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌
	private static int n;// 세로
	private static int m;// 가로
	private static int[] juPos;// 주난이 위치
	private static int[][] map;
	private static int[] chocoPos;// 초코바의 위치
	private static int res;// 몇번 점프

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		String[] secondLine = br.readLine().split(" ");
		n = Integer.parseInt(firstLine[0]);
		m = Integer.parseInt(firstLine[1]);
		juPos = new int[] { Integer.parseInt(secondLine[0]) - 1, Integer.parseInt(secondLine[1]) - 1 };
		chocoPos = new int[] { Integer.parseInt(secondLine[2]) - 1, Integer.parseInt(secondLine[3]) - 1 };
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (line[j].equals("#") || line[j].equals("*")) {
					line[j] = "1";
				}
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		getRes();
		System.out.println(res);

	}

	public static void getRes() {
		boolean find = false;
		while (true) {
			boolean[][] visited = new boolean[n][m];
			res++;
			Queue<Node14497> queue = new LinkedList<Node14497>();
			queue.add(new Node14497(juPos[0], juPos[1]));
			visited[juPos[0]][juPos[1]] = true;
			while (queue.isEmpty() == false) {
				Node14497 element = queue.remove();
				for (int i = 0; i < move.length; i++) {
					int nextRow = element.row + move[i][0];
					int nextCol = element.col + move[i][1];
					if (nextRow == chocoPos[0] && nextCol == chocoPos[1]) {
						find = true;
						break;
					}
					if (check(nextRow, nextCol, visited) == 1) {
						visited[nextRow][nextCol] = true;
						map[nextRow][nextCol] = 0;
					} else if (check(nextRow, nextCol, visited) == 0) {
						visited[nextRow][nextCol] = true;
						queue.add(new Node14497(nextRow, nextCol));
					}
				}
				if (find)
					break;
			}

			if (find)
				break;
		}

	}

	public static int check(int row, int col, boolean[][] visited) {
		if (row >= n || col >= m || row < 0 || col < 0)
			return -1;
		if (visited[row][col] == true)
			return -1;
		if (map[row][col] == 1)
			return 1;
		return 0;
	}
}

class Node14497 {
	int row;
	int col;

	public Node14497(int row, int col) {
		this.row = row;
		this.col = col;
	}
}