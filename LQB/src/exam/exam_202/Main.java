package exam.exam_202;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float n = sc.nextFloat();
//		ArrayList<Integer> xl = new ArrayList();
		int[][] res = new int[10000][2];
		int len = 0;
		
		for (float i = 1; i < 10001; i++) {
			for (float j = i+1 ; j < 10001; j++) {
//				if (n == (i + i + j - 1) * j / 2) {
				if (n == (i + j) * (j - i + 1) / 2) {
					res[len][0] = (int)i;
					res[len][1] = (int)j;
					len++;
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
		
//		for (int i = 10000; i > 0; i--) {
//			if (n % i == 0) {
////				xl.add(i);
//				
//			}
//		}
		
//		for (int i = 1; i <= 10000; i++) {
//			if (n % i == 0) {
//				xl.add(i);
//			}
//		}
		
		
//		for (int i = 0; i < xl.size(); i++) {
//			System.out.println(xl.get(i));
//		}
	}

}
