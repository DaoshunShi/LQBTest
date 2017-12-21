//题三：
//问题描述
//两个质数的和是S，它们的积最大是多少？
//输入
//一个不大于10000的正整数S，为两个质数的和。
//输出
//一个整数，为两个质数的最大乘积。数据保证有解。
//样例输入
//50
//样例输出
//589


package exam.exam_503;

import java.util.Scanner;

public class Main {

	private static boolean[] zsb;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		zsb = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			zsb[i] = true;
		}
		getZsb(n);
		
		int max = 0;
		for (int i = 1; i < n ; i++) {
			if (zsb[i] && zsb[n - i]) {
				int s = i * (n - i) ;
				if (s > max) {
					max = s;
//					System.out.println(i + " " + (n-i));
				}
			}
		}
		

		System.out.println(max);
		
	}

	private static void getZsb(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					zsb[i] = false;
				}
			}
		}
		zsb[0] = true;
		zsb[1] = true;
	}
	
	
}
