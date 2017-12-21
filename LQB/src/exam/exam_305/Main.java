//问题描述
//　　某寝室的同学们在学术完之后准备玩一个游戏：游戏是这样的，每个人头上都被贴了一张白色或者黑色的纸，现在每个人都会说一句话“我看到x张白色纸条和y张黑色的纸条”，又已知每个头上贴着白色纸的人说的是真话、每个头上贴着黑色纸的人说的是谎话，现在要求你判断哪些人头上贴着的是白色的纸条，如果无解输出“NoSolution.”；如果有多组解，则把每个答案中贴白条的人的编号按照大小排列后组成一个数（比如第一个人和第三个人头上贴着的是白纸条，那么这个数就是13；如果第6、7、8个人都贴的是白纸条，那么这个数就是678）输出最小的那个数（如果全部都是黑纸条也满足情况的话，那么输出0）
//输入格式
//　　第一行为一个整数n，接下来n行中的第i行有两个整数x和y，分别表示第i个人说“我看到x张白色纸条和y张黑色的纸条”。
//输出格式
//　　一行。如果无解输出“NoSolution.”。否则输出答案中数值（具体见问题描述）最小的那个，如果全部都是黑纸条也满足情况的话，那么输出0
//样例输入
//2
//1 0
//1 0
//样例输出
//0
//样例输入
//5
//3 1
//0 4
//1 3
//4 0
//1 3
//样例输出
//35
//数据规模和约定
//　　n<=8


package exam.exam_305;

import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int[][] xy;
		int n, x, y;

		n = scanner.nextInt();
		xy = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			xy[i][0] = scanner.nextInt();
			xy[i][1] = scanner.nextInt();
		}

		String[] result = new String[n + 1];
		int flag = 1;
		for (int i = 1; i < n + 1; i++) {
			// 是否为全黑标志位
			if (xy[i][0] == 0 && xy[i][1] == n - 1)
				flag = 0;

			result[i] = "" + i;
			for (int a = 1; a < n + 1; a++) {
				if(a == i)continue ;
				if (xy[i][0] == xy[a][0] && xy[i][1] == xy[a][1]) {
					
					if(xy[i][0] == 0){
						result[0] = a<i ? ""+a : ""+i ;
					}
					
					if (result[i].length() < (xy[i][0]+1))
						result[i] = result[i] + a;
				}
			}
		}
		
		if (flag == 1) {
			System.out.println(0);
		} else {
			int temp = 100000000;
			for (int i = 1; i <= n; i++) {
				if (result[i].length() > 1) {
					if(temp != 100000000 && String.valueOf(temp).length() < result[i].length()){
						temp = Integer.parseInt(result[i]) ;
					}else{
					temp = temp > Integer.parseInt(result[i]) ? Integer
							.parseInt(result[i]) : temp;
					}
				}
			}
			if (temp != 100000000) {
				System.out.println(temp);
			} else if(result[0] != null){
				System.out.println(result[0]) ;
			}else{
				System.out.println("NoSolution.") ;
			}
		}
	}
}



//import java.util.Scanner;
//
//public class Main {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[][] value = new int[n][3];
//		
//		for (int i = 0; i < n; i++) {
//			value[i][0] = sc.nextInt();
//			value[i][1] = sc.nextInt();
//			value[i][2] = 0;
//		}
//		
//		
//		
//	}
//	
//	public static void getRes(int[][] value) {
//		
//		boolean printed = false;
//		boolean ended = false;
//		int maxN = 0;
//		
//		while(!ended)  {
////			for (int )
//			int max = 0;
//			int num = -1;
//			int numMax = 0;
//			for (int i = 0; i < value.length; i++) {
//				if (value[i][2] > max) {
//					max = value[i][2];
//					num = i;
////					maxN =
//					if (maxN <= max) {
//						maxN = max;
//					}
//					else {
//						if (!printed) {
//							System.out.println("NoSolution.");
//						}
//						return;
//					}
//				}
//			}
//			if (value[num][0] + 1 == value[num][2] ) {
//				for (int i = 0; i < value.length; i++) {
//					if (value[num][0] == value[i][0] && value[num][1] == value[num][1]) {
//						
//						System.out.print(i);
//						value[num];
//						printed = true;
//					}
//				}
//			}
//		}
//		
//		
//		
//	}
//	
//	public static int[][] sum(int[][] value) {
//		int maxCount = 0;
//		
//		for (int i = 0; i < value.length; i++) {
//			for (int j = i + 1; j < value.length; j++) {
//				if (value[i][0] == value[j][0] && value[i][1] == value[j][1]) {
//					value[i][2]++;
//				}
//			}
//			for (int j = 0; j < value.length; j++) {
//				if (value[i][0] == value[j][0] && value[i][1] == value[j][1]) {
//					value[j][2] = value[i][2];
//				}
//			}
//		}
//		
//		return value;
//	}
//
//}
