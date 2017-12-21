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
//1 <= N <= 106。


package algo.algo_002;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal n = sc.nextBigDecimal();
		BigDecimal result = new BigDecimal(0);
		
//		System.out.println(n.divide(new BigDecimal(2)));
		//BigDeciaml取余
		//b.divideAndRemainder(a)[1]
		if (n.divideAndRemainder(new BigDecimal(2))[1].compareTo(new BigDecimal(0)) == 0) {	//n为偶数
			if (n.divideAndRemainder(new BigDecimal(3))[1].compareTo(new BigDecimal(0)) == 0) {	//n为3的倍数
				result = n.subtract(new BigDecimal(1)).multiply(n.subtract(new BigDecimal(2))).multiply(n.subtract(new BigDecimal(3)));
			}
			else 
			{
				result = n.multiply(n.subtract(new BigDecimal(1))).multiply(n.subtract(new BigDecimal(3)));
			}
		}
		else {	//n为奇数
			result = n.multiply(n.subtract(new BigDecimal(1))).multiply(n.subtract(new BigDecimal(2)));
		}
		
		System.out.println(result);
	}

}
