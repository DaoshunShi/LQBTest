//问题描述
//　　对于n个数，从中取出m个数，如何取使得这m个数的乘积最大呢？
//输入格式
//　　第一行一个数表示数据组数
//　　每组输入数据共2行：
//　　第1行给出总共的数字的个数n和要取的数的个数m，1<=n<=m<=15，
//　　第2行依次给出这n个数，其中每个数字的范围满足:a[i]的绝对值小于等于4。
//输出格式
//　　每组数据输出1行，为最大的乘积。
//样例输入
//1
//5 5
//1 2 3 4 2
//样例输出
//48 


package practice.practice_013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int groupNum = sc.nextInt();
		
//		List<Integer> li 
//		int max = 0;
		List<Integer> li = new ArrayList<Integer> ();
		for (int i = 0; i < groupNum; i++) {
			int n = sc.nextInt(), m = sc.nextInt();
			List<Integer> temp = new ArrayList<Integer> ();
			for (int j = 0; j < n; j++) {
				temp.add(sc.nextInt());
			}
//			temp.sort(Convert.reserve());
			temp.sort(null);
			int t = 1;
			for (int j = 0; j < m; j++) {
				t = t * temp.get(temp.size() - j - 1);
			}
			li.add(t);
		}
		
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		
		
	}
}
