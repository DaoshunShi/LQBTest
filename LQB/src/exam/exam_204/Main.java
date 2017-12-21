package exam.exam_204;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if (n % 2 == 1) {
			for (int i = 0; i <= n * n; i++) {
				printlinePlus(i, n);
			}
		}
	}
	
	public static void printlinePlus(int m, int n) {
		String str = "";
		
		if (2 * m > n * n) {	//后一半大行
			for (int i = 0; i < (-n + m / n * 2 + 1) / 2; i++) {
				str += printblank(n);
			}
			for (int i = 0; i < (2 * n - m / n * 2 - 1); i++) {
				str += printline(m % n , n);
			}
			for (int i = 0; i < (-n + m /n * 2 + 1) / 2; i++) {
				str += printblank(n);
			}
		} 
		else {	//前一半大行
			for (int i = 0; i < (n - m / n * 2 - 1) / 2; i++) {
				str += printblank(n);
			}
			for (int i = 0; i < m /n *2 + 1; i++) {
				str += printline(m % n , n);
			}
			for (int i = 0; i < (n - m / n * 2 - 1) / 2; i++) {
				str += printblank(n);
			}
		}
		
		System.out.println(str);
	}
	
	public static String printblank(int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += " ";
		}
		return str;
	}
	
	public static String printline(int l, int n) {
		String str = "";
		l ++;
		
		if (2 * l > n) {	//后一半小行
			for (int i = 0; i < (-n + 2 * l - 1) / 2; i++) {
				str += " ";
			}
			for (int i = 0; i < (2 * n - 2 * l + 1); i++) {
				str += "*";
			}
			for (int i = 0; i < (-n + 2 * l - 1) / 2; i++) {
				str += " ";
			}
		} 
		else {	//前一半小行
			for (int i = 0; i < (n + 1 - 2 * l) / 2; i++) {
				str += " ";
			}
			for (int i = 0; i < 2 * l -1; i++) {
				str += "*";
			}
			for (int i = 0; i < (n + 1 - 2 * l) / 2; i++) {
				str += " ";
			}
		}
		
		return str;
	}

}
