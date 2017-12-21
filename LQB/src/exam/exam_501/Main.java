//题一：
//问题描述
//给定两个正整数，求它们的最大公约数。
//输入数据
//输入一行，包含两个正整数（<1000000000）。
//输出要求
//输出一个正整数，即这两个正整数的最大公约数。
//样例输入
//6 9
//样例输出
//3


package exam.exam_501;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int m = sc.nextInt(), n = sc.nextInt();
		
		int a = Math.max(m, n), b = Math.min(m, n);
		int c = 1;
		
		while (a % b != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		
		System.out.println(b);
		
//		for (int i = 1; i <= b; i++) {
//			if (a % i == 0 && b % i == 0) {
//				if (i > c)
//					c = i;
//			}
//		}
		
//		System.out.println(c);
		
	}
	
	

}
