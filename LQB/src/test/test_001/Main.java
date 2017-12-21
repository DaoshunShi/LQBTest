package test.test_001;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//点名器
		randomName();
	}
	
	
	
	/**
	 * 随机点名器
	 */
	public static void randomName() {
		java.util.Random random=new java.util.Random();
		int i=random.nextInt(6);
		switch (i) {
		case 0:
			System.out.println("石道顺");
			break;
		case 1:
			System.out.println("高胜严");
			break;
		case 2:
			System.out.println("路梓馨");
			break;
		case 3:
			System.out.println("马锐泊");
			break;
		case 4:
			System.out.println("付镇宁");
			break;
		case 5:
			System.out.println("徐宇航");
		}
	}
}