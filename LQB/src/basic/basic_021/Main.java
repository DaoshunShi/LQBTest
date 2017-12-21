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


package basic.basic_021;

import java.util.Scanner;

public class Main {
	
	private static StringBuilder[] anlist = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		anlist = new StringBuilder[n]; 
		
		anlist[0] = new StringBuilder("sin(1)");
		for (int i = 1; i < n; i++) {
			anlist[i] = getAn(i + 1);	//计算并存储An数组
//			System.out.println(anlist[i]);
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(getSn(i + 1));
//		}
		
		System.out.println(getSn(n));
	}
	
	/**
	 * 获取An
	 * @param n
	 * @return
	 */
	public static StringBuilder getAn(int n) {
		StringBuilder an = new StringBuilder();
		
		StringBuilder anbef = anlist[n - 2];	//前一个An的值
		
		an.append(anbef.substring(0, anbef.length() - n + 1) + ((n % 2 == 0)?"-":"+") + "sin(" + n) ; 
		for (int i = 0; i < n; i++) {
			an.append(")");
		}
		
		return an;
	}

	/**
	 * 获取Sn
	 * @param n
	 * @return
	 */
	public static StringBuilder getSn(int n) {
		StringBuilder sn = new StringBuilder();
		
//		StringBuilder an = anlist[n - 1];	//An的值
		for (int i = 0; i < n - 1; i++) {
			sn.append("(");
		}
		for (int i = 0; i < n; i++) {
			StringBuilder ai = anlist[i];
			sn.append(ai + "+" + (n-i) + ")");
		}
		
		sn.deleteCharAt(sn.length() - 1);
		
		return sn;
	}
	
}
