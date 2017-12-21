package exam.exam_404;

import java.util.Scanner;

public class Main {

	private static int[][] value;
	private static int[][] res;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		value = new int[n + 1][n + 2];
		res = new int[n + 1][n + 2];
		
		//初始化value res
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j <= n+1; j++) {
				value[i][j] = 0;
				res[i][j] = 0;
			}
		}
		
		//获取value
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i + 1; j++ ) {
				value[i][j] = sc.nextInt();
			}
		}
		
		getRes(n);
		
		System.out.println(res[n][1]);
		
//		for (int i = n; i >= 0; i--) {
//			for (int j = 0; j <= n + 1; j++ ) {
//				System.out.print(value[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		for (int i = n; i >= 0; i--) {
//			for (int j = 1; j <= n ; j++ ) {
//				System.out.print(res[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		for (int i = n; i >= 1; i--) {
//			for (int j = 1; j <= n - i + 1; j++ ) {
//				System.out.print(res[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//	for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n - i + 1; j++) {
//				
//			}
//		}	
		
		
	}
	
	
	private static void getRes(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
//			for (int j = 1; j <= n; j++) {
				getNextRes(i, j);
			}
		}
	}
	
	private static void getNextRes(int i, int j) {
		
		res[i][j] = value[i][j] + Math.max(res[i-1][j-1], Math.max(res[i-1][j], res[i-1][j+1]));
		
//		if (i == 0) {
//			res[i][j] = value[i][j];
//		}
//		else {
//			
//		}
	}

}
