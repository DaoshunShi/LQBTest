package exam.exam_405;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//	private static boolean [] timeUsed;
//	private static int[][] time ;
	private static int maxCount;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [][] time = new int[n][2];
		int maxEnd = 0;
		
		
		for (int i = 0 ; i < n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
			maxEnd = Math.max(maxEnd, time[i][1]);	//记录最大的结束时间
		}
		boolean [] used = new boolean[maxEnd + 1];
//		int n0 = sc.nextInt();
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(time[i][0] + "  " + time[i][1]);
//		}
//		System.out.println(used.length);
		
		
		putNext(time, used, 0, 0);
		System.out.println(maxCount);
//		for (int i = 0; i < used.length; i++) {
//			System.out.println(used[i]);
//		}
		
	}
	
	public static void putNext(int[][] time, boolean[] used, int next, int currentCount) {
//		for (int )
		
		if (next >= time.length) {
			maxCount = Math.max(currentCount, maxCount);
//			for (int i = 0; i < used.length; i++) {
//				System.out.println(used[i] + " " + i);
//			}
//			System.out.println(currentCount);
//			System.out.println();
			
			return;
		}
		
		boolean canPutIn = true;
//		System.out.println(time[next][0] + "  " + time[next][1]);
		for (int i = time[next][0] ; i < time[next][1]; i++) {
			if (used[i]) {
				canPutIn = false;
			}
		}
		
		if (canPutIn) {	//可放入
			//放入
			for (int i = time[next][0]; i < time[next][1]; i++) {
				used[i] = true;
			}
			putNext(time, used, next + 1, currentCount + 1);
			
			//不放入
			for (int i = time[next][0]; i < time[next][1]; i++) {
				used[i] = false;
			}
			putNext(time, used, next + 1, currentCount);
		}
		else {	//不可放入
			putNext(time, used, next + 1, currentCount);
		}
		
		
		
		
		
	}

}
