//问题描述
//　　一个数如果恰好等于它的因子之和，这个数就称为“完数”。例如，6的因子为1、2、3，而6＝1＋2＋3，因此6就是“完数”。又如，28的因子为1、2、4、7、14，而28＝1＋2＋4＋7＋14，因此28也是“完数”。编写一个程序，判断用户输入的一个数是否为“完数”。
//　　输入格式：输入只有一行，即一个整数。
//　　输出格式：输出只有一行，如果该数为完数，输出yes，否则输出no。
//　　输入输出样例
//样例输入
//6
//样例输出
//yes


//ac
package practice.practice_011;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> li = new ArrayList<Integer>();
		
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				li.add(i);
			}
		}
		
		int sum = 0;
		for (int i = 0; i < li.size(); i++) {
			sum += li.get(i);
		}
		if (sum == n) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}

}
