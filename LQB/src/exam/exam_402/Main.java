package exam.exam_402;


import java.util.Scanner;

public class Main {

	private static boolean[] zsb = new boolean[10003];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
//		getZsb(b);
		
//		for (int i = a; i <= b; i++) {
//			if (zsb[i]) {
//				System.out.println(i + "=" + i);
//			}
//			else {
//				System.out.println(getRes(i));
//			}
//		}
		
		
		for (int i = a; i <= b; i++) {
			System.out.println(getRes(i));
		}
		
	}
	
//	private static void getZsb(int b) {
//		
//	
//		for (int i = 2; i < b; i++) {
//			if ((i % 6 == 1) || (i % 6 == 5)) {
//				zsb[i] = true;
//			}
//			else {
//				zsb[i] = false;
//			}
//		}
//		
//		zsb[2] = true;
//		zsb[3] = true;
//		
//	}
	

	private static String getRes (int n) {
		String result = "";
		int res = n;
		int j = 2;
		result = n + "=" ;
		
		while (res != 1) {
			if (res % j == 0) {
				res = res / j;
				result = result + j +  "*";
			}
			else {
				j++;
			}
		}
		
		result = result.substring(0, result.length()-1);
		return result;
	}

}
