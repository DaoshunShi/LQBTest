//题五：
//问题描述
//有N个人要渡河，但是只有一艘船，船上每次最多只能载两个人，渡河的速度由两个人中较慢的那个决定，小船来回载人直到所有人都渡河，求最短的渡河时间。
//输入要求
//输入两行，第一行为需要渡河的人数N（0<N<=100），第二行为每个人的渡河所需时间t1…tN。（每个人的渡河时间不超过100，且为整数）
//输出要求
//输出最少渡河时间T。
//样例输入
//4
//1   2    5    10
//样例输出
//17


//方法二 递归解决
package exam.exam_505;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static int [][] li ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		li = new int[n][2];
		List<Integer> arli = new ArrayList<Integer> ();
		for (int i = 0; i < n; i++) {
			arli.add(sc.nextInt());
		}
		arli.sort(null);
		for (int i = 0; i < n; i++) {
			li[i][0] = arli.get(i);
			li[i][1] = 0;
		}
		
		if (n == 1) {
			li[0][1] = 1;
		}
		else if (n == 2) {
			li[1][1] = 1;
		}
		else {
			if (n % 2 == 1) {
				passNext1(n, n);
			}
			else {
				passNext2(n, n);
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(li[i][0] + " " + li[i][1]);
//		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += li[i][0] * li[i][1];
		}
		System.out.println(sum);
		
	}
	
	private static void passNext1(int n, int t) {
		if (t > 3) {
			li[1][1]++;
			li[0][1]++;
			li[t - 1][1]++;
			li[1][1]++;
			passNext1(n, t - 2);
		}
		else {
			li[2][1]++;
			li[0][1]++;
			li[1][1]++;
		}
	}
	
	private static void passNext2(int n, int t) {
		if (t > 2) {
			li[1][1]++;
			li[0][1]++;
			li[t - 1][1]++;
			li[1][1]++;
			passNext2(n, t - 2);
		}
		else {
			li[1][0]++;
		}
	}
}

//方法一 数学计算
//package exam.exam_505;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner (System.in);
//		int n = sc.nextInt();
//		int[][] li = new int[n][2];
//		List<Integer> arli = new ArrayList<Integer> ();
//		for (int i = 0; i < n; i++) {
////			li[i][0] = sc.nextInt();
//			arli.add(sc.nextInt());
//		}
//		
//		arli.sort(null);
//		for (int i = 0; i < n; i++) {
//			li[i][0] = arli.get(i);
//		}
////		Arrays.sort(li);
//		
//		if (n % 2 == 0) {
//			for (int i = 0; i < n; i++) {
//				if (i % 2 == 0) {
//					li[i][1] = 0;
//				}
//				else {
//					li[i][1] = 1;
//				}
//			}
//		}
//		else {
//			for (int i = 0; i < n; i++) {
//				if (i % 2 == 0) {
//					li[i][1] = 1;
//				}
//				else {
//					li[i][1] = 0;
//				}
//			}
//		}
//		li[0][1] = (n - 2 + 1) / 2 ;
//		li[1][1] = (n - 2) / 2 + n / 2;
//		
//		
////		for (int i = 0 ; i < n; i++) {
////			System.out.println(li[i][0] + " " + li[i][1]);
////		}
//		
//		int sum = 0;
//		for (int i = 0 ; i < n; i++) {
//			sum += li[i][1] * li[i][0];
//		}
//		
//		System.out.println(sum);
//	}
//
//}
