package exam.exam_403;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static int count = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int next = 1;
		List<Integer> li = new ArrayList<Integer>();
		while (next > 0) {
			next = sc.nextInt();
			if (next > 0) {
				li.add(next);
			}
		}
		
		for (int i = 0; i < li.size(); i++) {
			count = 0;
			nextStep(li.get(i));
			System.out.println(count);
		}
		
//		for (int i = 0; i < li.size(); i++) {
//			System.out.println(li.get(i));
//		}
		
//		nextStep(30);
//		System.out.println(count);
		
	}
	
	private static void nextStep(int res) {
		
		if (res > 0) {
			if (res == 1) {
				count = count + 1;
				return ;
			}
			else if (res == 2) {
				count = count + 2;
				return ;
			}
			else {
				nextStep(res -1);
				nextStep(res - 2);
			}
		}
		
	}

}
