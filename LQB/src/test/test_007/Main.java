//验证是否所有的6n-1 与 6n + 1 都是质数


package test.test_007;

public class Main {

	private static boolean [] zsb = new boolean[10003]; 
	
	public static void main(String[] args) {
		
		getZsb(10002);
		
		for (int i = 2; i < 10000; i++) {
			printI(i);
		}
		
	}
	
	private static void getZsb(int n) {
		if (n < 6) {
			for (int i = 0; i < 6; i++) {
				zsb[i] = false;
			}
//			zsb[2] = true;
//			zsb[3] = true;
//			zsb[5] = true;
		}
		else {
			for (int i = 0; i <= n; i++) {
				if (i % 6 == 1 || i % 6 == 5) {
					zsb[i] = true;
				}
				else {
					zsb[i] = false;
				}
			}
		}
		zsb[2] = true;
		zsb[3] = true;
		zsb[5] = true;
	}
	
	private static String printI (int i) {
		String result = "";
//		System.out.print(i + "=");
		int res = i, j = 2;
		while (res != 1) {
			if (res % j == 0) {
				res = res / j;
				result = result + j + "*";
			}
			else {
				j++;
			}
			

		}
		
//		if (j == res && !zsb[i]) {
//			System.out.println(i);
//		}
		if (j == res) {
			if (!zsb[i]) {
				System.out.println(i);
			}
		}
		
		return result.substring(0, result.length() - 1);
	}

}
