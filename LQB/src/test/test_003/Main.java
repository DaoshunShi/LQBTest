//【编程大题】花朵数
//一个 N 位的十进制正整数，如果它的每个位上的数字的 N 次方的和等于这个数本身，
//则称其为花朵数。
//例如：当 N=3 时，153 就满足条件，因为 1^3 + 5^3 + 3^3 = 153，这样的数字也被称为
//水仙花数（其中，“^”表示乘方，5^3 表示 5 的 3 次方，也就是立方）。
//当 N=4 时，1634 满足条件，因为 1^4 + 6^4 + 3^4 + 4^4 = 1634。
//当 N=5 时，92727 满足条件。
//实际上，对 N 的每个取值，可能有多个数字满足条件。
//程序的任务是：求 N=21 时，所有满足条件的花朵数。注意：这个整数有 21 位，它的
//各个位数字的 21 次方之和正好等于这个数本身。
//如果满足条件的数字不只有一个，请从小到大输出所有符合条件的数字，每个数字占一
//行。因为这个数字很大，请注意解法时间上的可行性。要求程序在 1 分钟内运行完毕。
//【程序运行参考结果】
//128468643043731391252
//449177399146038697307
//100000000000000000000
//999999999999999999999
//


package test.test_003;

//方法二
import java.math.BigDecimal;

public class Main {

	private static BigDecimal[] powers = new BigDecimal[10];
//	private static int[] value = new int[10];
	
	public static void main(String[] args) {
		getPower();
		int[] value = new int[10];
		for (int i = 0 ; i < 10; i++) {
			value[i] = 0;
		}
		getResult(value, 0, 21);
		System.out.println("end");
	}
	
	private static void getResult(int[] value, int cur, int res) {
		if (cur == 9) {
			value[cur] = res;
			
			BigDecimal sum = getSum(value);
			if (isEqual(value, sum)) {
				System.out.println(sum);
			}
		}
		else {
			for (int i = 0; i <= res; i++) {
				value[cur] = i;
				getResult(value, cur+1, res-i);
			}
		}
		
	}
	
	private static void getPower() {
		for (int i = 0; i < 10; i++) {
			powers[i] = new BigDecimal(i).pow(21);
		}
	}
	
	private static BigDecimal getSum(int[] value) {
		BigDecimal sum = new BigDecimal(0);
		for (int i = 0; i < 10; i++) {
			sum = sum.add(powers[i].multiply(new BigDecimal(value[i])));
		}
		return sum;
	}
	
	private static boolean isEqual(int[] value, BigDecimal sum) {
		String str = sum.toString();
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = 0;
		}
		if (str.length() != 21) {
			return false;
		}
		for (int i = 0 ; i < str.length(); i++) {
			nums[Integer.valueOf(str.charAt(i) + "")]++;
		}
		
		for (int i = 0 ; i < 10; i++) {
			if (nums[i] != value[i]) {
				return false;
			}
		}
		return true;
	}
}


//方法一(超时)
//import java.math.BigDecimal;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = 21;
//		
//		for (BigDecimal i = new BigDecimal("100000000000000000000"); i.compareTo(new BigDecimal("1000000000000000000000")) < 0; i = i.add(new BigDecimal(1)) ) {
//			BigDecimal[] num = new BigDecimal[21];
//			BigDecimal res = new BigDecimal(0);
//			
//			for (int j = 0; j < 21; j++) {	//
//				num[j] = new BigDecimal("" + i.toString().charAt(j));
//				res = res.add(num[j].pow(n));
//			}
//			if (res.compareTo(i) == 0) {
//				System.out.println(i);
//			}
//		}
//		
//	}
//
//}
