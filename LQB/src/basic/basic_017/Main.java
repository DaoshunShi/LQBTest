//问题描述
//　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
//　　例如：
//　　A =
//　　1 2
//　　3 4
//　　A的2次幂
//　　7 10
//　　15 22
//输入格式
//　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
//　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
//输出格式
//　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
//样例输入
//2 2
//1 2
//3 4
//样例输出
//7 10
//15 22


package basic.basic_017;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		long[][] jz = new long[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				jz[i][j] = sc.nextInt();
			}
		}
		
		jz = getRes(jz, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(jz[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static long[][] getRes(long[][] value, int t) {
		long[][] jz1 = value, jz2 = value;
		long[][] res = value;
		if (t == 0) {	//t=0
			for (int i = 0; i < value.length; i++) {
				for (int j = 0; j < value.length; j++) {
					res[i][j] = 0;
				}
				res[i][i] = 1;
			}
		}
		else if (t == 1) {	//t=1
			res = value;
		}
		else if (t == 2) {	//t=2时，t1=1，t2=1
			res = getJiecheng(jz1, jz2);
		}
		else {	//t>2
			if (t % 2 == 0) {	//如果t为偶数，则结果为两个t/2之积
				jz1 = getRes(value, t / 2);
				jz2 = jz1;
				res = getJiecheng(jz1, jz2);
			}
			else {	//如果t为奇数
				int t1 = t / 2;
				int t2 = t - t1;	//t1一定小于t2
				jz1 = getRes(value, t1);
				jz2 = getRes(value, t2);
				res = getJiecheng(jz1, jz2);
			}
			
		}
		
		return res;
	}
	
	public static long[][] getJiecheng(long[][] value1, long[][] value2) {
		long[][] result = new long[value1.length][value1.length];
		for (int i = 0; i < value1.length; i++) {
			for (int j = 0; j < value1.length; j++) {
				for (int k = 0; k < value1.length; k++) {
					result[i][j] += value1[i][k] * value2[k][j];
				}
			}
		}
		return result;
	}

}
