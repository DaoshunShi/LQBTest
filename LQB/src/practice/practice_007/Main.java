//问题描述
//　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
//　　不妨设
//　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
//　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
//　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
//输入格式
//　　仅有一个数：N<201。
//输出格式
//　　请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
//样例输入
//3
//样例输出
//((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1


//ac
package practice.practice_007;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		System.out.println(getAn(1));
//		System.out.println(getSn(3));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getSn(n));
	}
	
	private static String getAn(int n) {
		String res = "";
		for (int i = 1; i <= n; i++) {
//			res = res + (i%2 == 1) != null?"+":"-" + "sin(" + i; 
			String str = (i % 2 == 1)? "+" : "-";
			res = res + str + "sin(" + i; 
		}
		res = res.substring(1, res.length());
		for (int i = 1; i <= n; i++) {
			res = res + ")";
		}
		return res;
	}
	
	private static String getSn(int n) {
		String res = "";
		
		for (int i = 1; i <= n; i++) {
			res = res + ")" + getAn(i) + "+" + (n + 1 - i);
		}
		res = res.substring(1, res.length());
		for (int i = 1; i < n; i++) {
			res = "(" + res;
		}
		
		return res;
	}

}
