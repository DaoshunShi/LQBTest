package exam.exam_201;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int[] res = new int[10000];
//		int num = 0;
		ArrayList<Integer> res = new ArrayList();
		
		if (n % 2 == 0) {	//偶数
			for (int i = 1; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						if (i * 2 + j * 2 + k == n) {	//5位数
							res.add(i * 10000 + j * 1000 + k *100 + j * 10 + i);
//							res[num] = i * 10000 + j * 1000 + k *100 + j * 10 + i;
//							num++;
						}
						

					}
				}
			}
			for (int i = 1; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						if (i * 2 + j * 2 + k * 2 == n) {	//6位数
							res.add(i * 100000 + j * 10000 + k *1000+ k *100 + j * 10 + i);
//							res[num] = i * 100000 + j * 10000 + k *1000+ k *100 + j * 10 + i;
//							num++;
						}
						

					}
				}
			}
		} else {	//奇数
			for (int i = 1; i <= 9; i++) {
				for (int j = 0; j <= 9; j++) {
					for (int k = 0; k <= 9; k++) {
						if (i * 2 + j * 2 + k == n) {	//5位数
							res.add(i * 10000 + j * 1000 + k *100 + j * 10 + i);
//							res[num] = i * 10000 + j * 1000 + k *100 + j * 10 + i;
//							num++;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
//		for (int i = 0; i < num; i++) {
//			System.out.println(res[i]);
//		}
	}
	
//	public static boolean getTrue(int num, int n) {
//		int [] list = new int[6];
//		int temp = num;
//		for (int i = 0; i < 6; i++) {
//			list[i] = temp % 10;
//			temp = temp / 10;
//		}
//		if 
//	}

}