//问题描述
//　　同在一个高中，他却不敢去找她，虽然在别人看来，那是再简单不过的事。暗恋，是他唯一能做的事。他只能在每天课间操的时候，望望她的位置，看看她倾心的动作，就够了。操场上的彩砖啊，你们的位置，就是他们能够站立的地方，他俩的关系就像砖与砖之间一样固定，无法动摇。还记得当初铺砖的工人，将整个操场按正方形铺砖（整个操场可视为R行C列的矩阵，矩阵的每个元素为一块正方形砖块），正方形砖块有两种，一种为蓝色，另一种为红色。我们定义他和她之间的“爱情指标”为最大纯色正方形的面积，请你写一个程序求出“爱情指标”。
//输入格式
//　　第一行两个正整数R和C。
//　　接下来R行C列描述整个操场，红色砖块用1来表示，蓝色砖块用0来表示。
//输出格式
//　　一个数，表示他和她之间的“爱情指标”。
//样例输入
//5 8
//0 0 0 1 1 1 0 1
//1 1 0 1 1 1 1 1
//0 1 1 1 1 1 0 1
//1 0 1 1 1 1 1 0
//1 1 1 0 1 1 0 1
//样例输出
//9
//数据规模和约定
//　　40%的数据R,C<=10;
//　　70%的数据R,C<=50;
//　　100%的数据R,C<=200;


package algo.algo_112;

import java.util.Scanner;

public class Main {

	private static int value[][];
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int r=s.nextInt();
		int c=s.nextInt();
		int maxL = 0;
		value = new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				value[i][j]=s.nextInt();
			}
		}
		
		 for(int i = 0; i < r; i++){
	    	 for(int j = 0; j < c; j++){
	    		 for(int l = 0; l <= maxLen(i, j); l++)
	    			 if (judge(i,j,l)) {
	    				 if (l > maxL) {
	    					 maxL = l;
	    				 }
	    			 }
	    	 }
	     }
		 
		 System.out.println(maxL * maxL);
		
	}
	
	private static int maxLen(int i, int j) {
		int len = Math.min(value.length - i , value[0].length-j );
//		int len = Math.max(value.length - i , value[0].length-j );
		return len;
	}
	
	private static boolean judge(int i, int j, int l) {
		int color = value[i][j];
		for (int m = i; m < i + l; m++) {
			for (int n = j; n < j + l; n++) {
//				if (n == 8) {
//					System.out.print("123**************8");
//				}
				if (color != value[m][n])
					return false;
			}
		}
		return true;
	}

}
