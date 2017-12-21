//问题描述
//　　平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
//输入格式
//　　输入仅包含两行，每行描述一个矩形。
//　　在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
//输出格式
//　　输出仅包含一个实数，为交的面积，保留到小数后两位。
//样例输入
//1 1 3 3
//2 2 4 4
//样例输出
//1.00


package basic.basic_018;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
		double x3 = sc.nextDouble(), y3 = sc.nextDouble(), x4 = sc.nextDouble(), y4 = sc.nextDouble();
		
		double xa = Math.min(x1, x2), ya = Math.min(y1, y2);
		double xb = Math.max(x1, x2), yb = Math.max(y1, y2);
		
		double xc = Math.min(x3, x4), yc = Math.min(y3, y4);
		double xd = Math.max(x3, x4), yd = Math.max(y3, y4);
		
		double s;
		
		if (xa >= xd || xb <= xc) {
			s = 0;
		}
		else if (ya >= yd || yb <= yc) {
			s = 0;
		}
		else {
			s = Math.abs((Math.min(yb, yd) - Math.max(ya, yc)) * (Math.min(xb, xd) - Math.max(xa, xc) ));
//			System.out.println(Math.min(yb, yd) - Math.max(ya, yc));
//			System.out.println(Math.min(xb, xd) - Math.max(xa, xc));
		}
		
		System.out.printf("%.2f", s);
	}

}
