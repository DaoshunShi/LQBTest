package exam.exam_301;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//方法二
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//利用HashMap存储并去重
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if (map.get(temp) != null) {
				map.put(temp, map.get(temp) + 1);
			}
			else {
				map.put(temp, 1);
			}
		}
		
		int maxNum = 0;
		for (Integer i : map.keySet()) {
//			System.out.println(i + " " + map.get(i));
			if (map.get(i) > maxNum) {
				maxNum = i;
			}
		}
		
		System.out.println(maxNum);
	}
}


//方法一(ac)
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int max = 0, count = 0;
//		int[][] nums = new int[n][2];
//		for (int i = 0; i < n; i++) {
//			nums[i][0] = sc.nextInt();
//			nums[i][1] = 0;
//		}
//		
//		for (int i = 0; i< n; i++) {
//			for (int j = i; j < n; j++) {
//				if (nums[i][0] == nums[j][0]) {
//					nums[i][1]++;
//				}
//			}
//			
//			if (nums[i][1] > count) {
//				count = nums[i][1];
//				max = i;
//			}
//		}
//		
//		System.out.println(nums[max][0]);
//	}
//
//}
