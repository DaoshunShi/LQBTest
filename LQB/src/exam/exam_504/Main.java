//题四：
//问题描述
//有两个容器，容积分别为A升和B升，有无限多的水，现在需要C升水。 我们还有一个足够大的水缸，足够容纳C升水。起初它是空的，我们只能往水缸里倒入水，而不能倒出。 可以进行的操作是： 把一个容器灌满； 把一个容器清空（容器里剩余的水全部倒掉，或者倒入水缸）； 用一个容器的水倒入另外一个容器，直到倒出水的容器空或者倒入水的容器满。问是否能够通过有限次操作，使得水缸最后恰好有C升水。
//输入要求
//三个整数A, B, C，其中 0 < A , B, C <= 1000000000  
//输出要求
//0或1，表示能否达到要求。
//样例输入
//
//样例输出


package exam.exam_504;

import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		int maxbs = a * b;
		int bs = 0 ;
		
		int m = Math.max(a, b), n = Math.min(a, b);
		int k = n;
		
		while (m % n != 0) {
			k = m % n;
			m = n;
			n = k;
		}
		
//		for (int i = maxbs; i > 1; i-- ) {
//			if (i % a == 0 && i % b == 0) {
//				bs = i;
//			}
//		}
		
//		System.out.println(k);
		
		if (c % k == 0) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
		
		
		
//		for (int i = 2; i <= Math.min(a, b); i++) {
//			if (a % i == 0 && b % i == 0) {
//				bs = bs % i;
//			}
//		}
//		
//		if (c % bs == 0) {
//			
//		}

	}

}
