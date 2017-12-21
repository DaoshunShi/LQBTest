package exam.exam_203;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 1) {
			for (int i = 0; i <= n; i++) {
				printline(i, n);
			}
		}
	}
	
	public static void printline(int l, int n) {
		String str = "";
		
		if (2 * l > n) {
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
		else {
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
		
		System.out.println(str);
	}
}
