//问题描述
//杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
//
//　　
//它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
//
//　　
//下面给出了杨辉三角形的前4行：
//
//　　
//   1
//
//　　
//  1 1
//
//　　
// 1 2 1
//
//　　
//1 3 3 1
//
//　　
//给出n，输出它的前n行。
//
//输入格式
//输入包含一个数n。
//
//输出格式
//输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
//样例输入
//4
//样例输出
//1
//1 1
//1 2 1
//1 3 3 1
//数据规模与约定
//1 <= n <= 34。


package basic.basic_006;


//方法一(ac)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long [][] li = new long[n][n];
		
		for (int i = 0; i < n; i++) {	//给左侧的1赋值
			li[i][0] = 1;
		}
		for (int i = 1; i < n; i++) {	//给右侧的1赋值
			li [i][i] = 1;
		}
		for (int i = 1; i < n ; i++) {	//给中间元素赋值
			for (int j = 1; j < n - 1; j++) {
				li[i][j] = li[i - 1][j] + li[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(li[i][j] + " ");
			}
			System.out.println();
		}
	}

}


//方法二（wa）
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print(getC(i, j) + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	public static long getC(int x, int y) {
//		return getA(x, y) / getY(y);
//	}
//	
//	public static long getA(int x, int y) {
//		long num = 1;
//		for (int i = 0; i < y; i++) {
//			num = num * (x - i);
//		}
//		return num;
//	}
//	
//	public static long getY(int y) {
//		int num = 1;
//		for (int i = 1; i <= y; i++) {
//			num = num * i;
//		}
//		return num;
//	}
//}
