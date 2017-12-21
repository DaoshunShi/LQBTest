//问题描述
//　　求出区间[a,b]中所有整数的质因数分解。
//输入格式
//　　输入两个整数a，b。
//输出格式
//　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
//样例输入
//3 10
//样例输出
//3=3
//4=2*2
//5=5
//6=2*3
//7=7
//8=2*2*2
//9=3*3
//10=2*5
//提示
//　　先筛出所有素数，然后再分解。
//数据规模和约定
//　　2<=a<=b<=10000


package practice.practice_003;

import java.util.Scanner;

public class Main {

	private static boolean [] zsb = new boolean[10003]; 
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
//		getZsb(b);
//		for (int i = a; i <= b; i++) {
//			if (!zsb[i]) {
//				System.out.println(printI(i));
//			}
//			else {
//				System.out.println(i + "=" + i);
//			}
//		}
		
		for (int i = a; i <= b; i++) {
			System.out.println(printI(i));
		}		
		
//		for (int i = a; i <= b; i++) {
//			System.out.println(zsb[i]);
//		}
	}
	
	private static void getZsb(int n) {
		if (n < 6) {
			for (int i = 0; i < 6; i++) {
				zsb[i] = false;
			}
//			zsb[2] = true;
//			zsb[3] = true;
//			zsb[5] = true;
		}
		else {
			for (int i = 0; i <= n; i++) {
				if (i % 6 == 1 || i % 6 == 5) {
					zsb[i] = true;
				}
				else {
					zsb[i] = false;
				}
			}
		}
		zsb[2] = true;
		zsb[3] = true;
		zsb[5] = true;
	}
	
	private static String printI (int i) {
		String result = "";
//		System.out.print(i + "=");
		result = i + "=" ;
		int res = i, j = 2;
		while (res != 1) {
			if (res % j == 0) {
				res = res / j;
				result = result + j + "*";
			}
			else {
				j++;
			}
		}
		
		return result.substring(0, result.length() - 1);
	}

}
