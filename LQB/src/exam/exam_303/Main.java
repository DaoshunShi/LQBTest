package exam.exam_303;

import java.util.Scanner;

public class Main {

	private static String[] str = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		
		
//		String[] sb = new String[n];
//		
//		sb[0] = "A";
//		for (int i = 1; i < n; i++) {
//			sb[i] = sb[i - 1] + (char)('A' + i) + sb[i - 1];
//		}
//		
//		System.out.println(sb[n - 1]);
		


		StringBuilder sb = new StringBuilder("A");
		
		for (int i = 1; i < n; i++) {
			StringBuilder temp = new StringBuilder(sb.toString());
//			StringBuilder temp = sb;
			sb = sb.append((char)('A' + i));
			sb = sb.append(temp);
			
		}
		
		System.out.println(sb);

	}
	

	
	

}
