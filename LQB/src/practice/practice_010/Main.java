//　　输入11个整数，计算它们的最大值和最小值。
//样例输入
//0 1 2 3 4 5 6 7 8 9 10
//样例输出
//10 0


//ac
package practice.practice_010;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> li = new ArrayList<Integer> ();
		for (int i = 0; i < 11; i++) {
			li.add(sc.nextInt());
		}
		li.sort(null);
		
		System.out.println(li.get(10) + " " + li.get(0));
	}

}
