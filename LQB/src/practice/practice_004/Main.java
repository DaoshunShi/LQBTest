//问题描述
//　　给定当前的时间，请用英文的读法将它读出来。
//　　时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
//　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
//　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
//　　时和分的读法使用的是英文数字的读法，其中0~20读作：
//　　0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty。
//　　30读作thirty，40读作forty，50读作fifty。
//　　对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
//　　按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
//输入格式
//　　输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
//输出格式
//　　输出时间时刻的英文。
//样例输入
//0 15
//样例输出
//zero fifteen


package practice.practice_004;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(), m = sc.nextInt();
		
		String res = read(h, m);
		System.out.println(res);
	}
	
	private static String read (int h, int m) {
		String res  = "";
		if (m == 0) {
			res = readNum(h) + " o'clock";
		}
		else {
			res = readNum(h) + " " + readNum(m);
		}
		return res;
	}
	
	private static String readNum(int n) {
		String str = "";
		int t = n;
		
		if (t > 20) {	//30读作thirty，40读作forty，50读作fifty。
			switch (t / 10) {
			case 2:
				str = str + "twenty";
				break;
			case 3:
				str = str + "thirty";
				break;
			case 4:
				str = str + "forty";
				break;
			case 5:
				str = str + "fifty";
				break;
			}
			if (t % 10 != 0) {
				
				str = str + " " + readIn20(t % 10);
			}
		}
		else {
			str = str + readIn20(n);
		}
		return str;
	}
	
	private static String readIn20(int n) {
		String str = "";
		int t = n;
		switch (t) {
		case 0:
			str = str + "zero";
			break;
		case 1:
			str = str + "one";
			break;
		case 2:
			str = str + "two";
			break;
		case 3:
			str = str + "three";
			break;
		case 4:
			str = str + "four";
			break;
		case 5:
			str = str + "five";
			break;
		case 6:
			str = str + "six";
			break;
		case 7:
			str = str + "seven";
			break;
		case 8:
			str = str + "eight";
			break;
		case 9:
			str = str + "nine";
			break;
		case 10:
			str = str + "ten";
			break;
		case 11:
			str = str + "eleven";//1:eleven, 12:twelve, 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen, 19:nineteen, 20:twenty
			break;
		case 12:
			str = str + "twelve";
			break;
		case 13:
			str = str + "thirteen";
			break;
		case 14:
			str = str + "fourteen";
			break;
		case 15:
			str = str + "fifteen";
			break;
		case 16:
			str = str + "sixteen";
			break;
		case 17:
			str = str + "seventeen";
			break;
		case 18:
			str = str + "eighteen";
			break;
		case 19:
			str = str + "nineteen";
			break;
		case 20:
			str = str + "twenty";
			break;
		}
		return str;
	}
}
