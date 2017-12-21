//问题描述
//　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
//输入格式
//　　输入的第一行为一个整数n，表示棋盘的大小。
//　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
//输出格式
//　　输出一个整数，表示总共有多少种放法。
//样例输入
//4
//1 1 1 1
//1 1 1 1
//1 1 1 1
//1 1 1 1
//样例输出
//2
//样例输入
//4
//1 0 1 1
//1 1 1 1
//1 1 1 1
//1 1 1 1
//样例输出
//0


package basic.basic_027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int n;
	private static int count;	//记录放法数
	private static int[][] matrix;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		count = 0;
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str[] = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		put(0, 2);
		System.out.println(count);
	}
	
	/**
	 * 放入第row行的 queen皇后
	 * @param row
	 * @param queen	2代表黑皇后，3代表白皇后
	 */
	public static void put(int row, int queen) {
		if (row == n) {	//摆放结束
			if (queen == 2) {	
				put (0, 3);
			}
			else
			{
				count++;
			}
			return;
		}
		for (int j = 0; j < n; j++) {
			if (matrix[row][j] == 1) {
				if (check(row, j, queen)) {
					matrix[row][j] = queen;
					put(row+1, queen);
					matrix[row][j] = 1;	//回溯
				}
			}
		}
	}
	
	/**
	 * 判断第row行 col列 是否能放入queen皇后
	 * @param row
	 * @param col
	 * @param queen
	 * @return
	 */
	public static boolean check(int row, int col, int queen) {
		for (int i = 0; i < row; i++) {
			if (matrix[i][col] == queen) {	//检查同列
				return false;
			}
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j>= 0; i--, j--) {	//检查对角线
			if (matrix[i][j] == queen) {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {	//检查对角线
			if (matrix[i][j] == queen) {
				return false;
			}
		}
		return true;
	}

}
