package exam.exam_406;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//	private static 
	
	private static List<Integer> ysLi = new ArrayList<Integer>();
	private static int ys_s;
	private static int ys_len;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ys_s = 0;
		ys_len = 0;
		
		getYs(n);	//得到因数表
		
		//输出因数表
//		for (int i = 0; i < ysLi.size(); i++) {
//			System.out.println(ysLi.get(i));
//		}
		
		//递归求最长子链（子链之积无限制）
//		for (int i = 0; i < ysLi.size(); i++) {
//			for (int j = i + 1; j <ysLi.size(); j++) {
//				if (ysLi.get(j) - ysLi.get(j - 1) != 1) {	//子链结束
//					if (j - i > ys_len) {
//						ys_len  = j - i;
//						ys_s = i;
//					}
//					break;
//				}
//				else {	//子链继续
//				}
//			}
//		}
		
		//递归求最长子链（子链之积有限制）
		for (int i = 0; i < ysLi.size(); i++) {
			int curMul = 1;
			for (int j = i + 1; j < ysLi.size(); j++) {
				curMul = curMul * ysLi.get(j);
				if (ysLi.get(j) - ysLi.get(j - 1) != 1 || curMul > n) {	//子链结束
					if (j - i > ys_len ) {
						ys_len  = j - i;
						ys_s = i;
					}
					break;
				}
				else {	//子链继续
					
//					if (j - i > ys_len && curMul < n) {
//						ys_len  = j - i;
//						ys_s = i;
//					}
//					break;
				}
			}
		}
		
		//输出最长子链
		System.out.println(ys_len);
		System.out.print(ysLi.get(ys_s));
		for (int i = 1; i < ys_len; i++) {
			System.out.print("*" + ysLi.get(ys_s + i));
		}
		
		
		
	}
	
	private static void getYs(int n) {
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				ysLi.add(i);
			}
		}
	}
	

}
