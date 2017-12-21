package exam.exam_205;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int resN = n;	//剩余物品数量
		float w = sc.nextFloat();
		float resW = w;	//剩余载重量
		float money = 0f;	//总价值
		float[][] gp = new float[n][2];
		float[] li = new float[n];
		for (int i = 0; i < n; i++) {
			gp[i][0] = sc.nextFloat();
			gp[i][1] = sc.nextFloat();
		}
		for (int i = 0; i < n; i++) {
			li[i] = gp[i][1] / gp[i][0]; 
		}
		
		while(resN > 0 && resW > 0) {
			float maxLi = 0f;
			int LiNum = n;
			
			//找到目前性价比最高的货物
			for (int i = 0; i < n; i++) {
				if (li[i] > maxLi) {
					maxLi = li[i];
					LiNum = i;
				}
			}
			
			//装载目前性价比最高的货物
			if (gp[LiNum][0] < resW) {	//可装下时
				money += gp[LiNum][1];
				resW -= gp[LiNum][0];
				resN--;
				li[LiNum] = 0;
			}
			else {	//不可装下时
				float temp = resW * gp[LiNum][1] / gp[LiNum][0] ;
				money += temp;
				resW = 0;
			}
			
		}
		
//		System.out.println(money);
		System.out.printf("%.1f\n", money);
		
//		for (int i = 0; i< n; i++) {
//			System.out.println(gp[i][0] + " " + gp[i][1] + " " + li[i]);
//			System.out.printf("%.1f\n", li[i]);
//		}
	}

}

//解题思路：求单位重量价格最高的
