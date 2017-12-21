//问题描述
//已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
//
//输入格式
//输入一个正整数N。
//
//输出格式
//输出一个整数，表示你找到的最小公倍数。
//样例输入
//9
//样例输出
//504
//数据规模与约定
//1 <= N <= 10^6。


//wa
package practice.practice_009;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int max = 0;
//		if (n % 2 == 0) {
//			max = Math.max(n * (n - 1) * (n - 3), (n - 1) * (n - 2) * (n - 3));
//		}
//		else {
//			max = n * (n - 1) * (n - 2);
//		}
//		
//		System.out.println(max);
		Scanner sc = new Scanner (System.in);
		BigDecimal n = sc.nextBigDecimal();
		
		BigDecimal max;
		if (n.divideAndRemainder(new BigDecimal(2))[1].compareTo(new BigDecimal(0)) == 0) {
			if (n.divideAndRemainder(new BigDecimal(3))[1].compareTo(new BigDecimal(0)) == 0) {
				max = n.subtract(new BigDecimal(1)).multiply(n.subtract(new BigDecimal(2))).multiply(n.subtract(new BigDecimal(3)));
			}
			else {
				max = n.multiply(n.subtract(new BigDecimal(1))).multiply(n.subtract(new BigDecimal(3)));
			}
		}
		else {
			max = n.multiply(n.subtract(new BigDecimal(1))).multiply(n.subtract(new BigDecimal(2)));
		}
		
		System.out.println(max.toString());
	}

}
