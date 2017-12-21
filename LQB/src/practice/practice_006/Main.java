//问题描述
//　　给定n个十六进制正整数，输出它们对应的八进制数。
//
//输入格式
//　　输入的第一行为一个正整数n （1<=n<=10）。
//　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
//
//输出格式
//　　输出n行，每行为输入对应的八进制正整数。
//
//　　【注意】
//　　输入的十六进制数不会有前导0，比如012A。
//　　输出的八进制数也不能有前导0。
//
//样例输入
//　　2
//　　39
//　　123ABC
//
//样例输出
//　　71
//　　4435274
//
//　　【提示】
//　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。


package practice.practice_006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		StringBuilder[] value = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			value[i] = trans(bf.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(value[i]);
		}
		
	}
	
	public static StringBuilder trans(String value) {
		StringBuilder res = new StringBuilder();
		StringBuilder tempStr = new StringBuilder();
		
		for (int i = 0; i < value.length(); i ++) {	//16 -> 2
			switch (value.charAt(i)) {
			case '0':tempStr.append("0000");break;
			case '1':tempStr.append("0001");break;
			case '2':tempStr.append("0010");break;
			case '3':tempStr.append("0011");break;
			case '4':tempStr.append("0100");break;
			case '5':tempStr.append("0101");break;
			case '6':tempStr.append("0110");break;
			case '7':tempStr.append("0111");break;
			case '8':tempStr.append("1000");break;
			case '9':tempStr.append("1001");break;
			case 'A':tempStr.append("1010");break;
			case 'B':tempStr.append("1011");break;
			case 'C':tempStr.append("1100");break;
			case 'D':tempStr.append("1101");break;
			case 'E':tempStr.append("1110");break;
			case 'F':tempStr.append("1111");break;
			}
		}
		
		while (tempStr.length() % 3 != 0) {	//补0
			tempStr.insert(0, '0');
		}
		
		for (int i = 0; i < tempStr.length(); i = i+3 ) {
			String str = tempStr.substring(i, i+3);
			switch (str) {
			case "000":
				if (i != 0) {
					res.append('0');
				}
				break;
			case "001":	res.append('1');break;
			case "010":	res.append('2');break;
			case "011":	res.append('3');break;
			case "100":	res.append('4');break;
			case "101":	res.append('5');break;
			case "110":	res.append('6');break;
			case "111":	res.append('7');break;
			}
		}
		
//		System.out.println(tempStr);
		
		return res;
	}
	
}



//运行超时
//package practice.practice_006;
//
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner (System.in);
////		int n = sc.nextInt();
//		int n = Integer.valueOf(sc.nextLine());
//		
//		String[] valueH = new String[n];
//		String[] valueB = new String[n];
//		String[] valueO = new String[n];
//		for (int i = 0; i < n; i++) {
//			valueH[i] = sc.nextLine();
//			valueB[i] = h2b(valueH[i]);
//			valueO[i] = b2o(valueB[i]);
//		}
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(valueO[i]);
//		}
//	}
//	
//	//16进制转2进制
//	private static String h2b(String valueH) {
//		String resB = "";
//		for (int i = 0; i < valueH.length(); i++) {
//			resB = resB + trans(valueH.charAt(i));
//		}
//		return resB;
//	}
//	
//	//2进制转8进制
//	private static String b2o(String valueB) {
//		String resO = "";
//		while (valueB.length() % 3 != 0) {	//补0
//			valueB = "0" +  valueB;
//		}
//		
//		for (int i = 0; i < valueB.length(); i = i + 3) {
//			String str = valueB.substring(i, i+3);
//			resO = resO + Integer.toOctalString(Integer.valueOf(str, 2)).toString();
//		}
//		
//		while (resO.charAt(0) == '0') {
//			resO = resO.substring(1, resO.length());
//		}
//		
//		return resO;
//	}
//	
////	private static 
//	
//	private static String trans(char value) {
//		String res = "";
//		switch (value) {
//		case '0':
//			res = "0000";
//			break;
//		case '1':
//			res = "0001";
//			break;
//		case '2':
//			res = "0010";
//			break;
//		case '3':
//			res = "0011";
//			break;
//		case '4':
//			res = "0100";
//			break;
//		case '5':
//			res = "0101";
//			break;
//		case '6':
//			res = "0110";
//			break;
//		case '7':
//			res = "0111";
//			break;
//		case '8':
//			res = "1000";
//			break;
//		case '9':
//			res = "1001";
//			break;
//		case 'A':
//			res = "1010";
//			break;
//		case 'B':
//			res = "1011";
//			break;
//		case 'C':
//			res = "1100";
//			break;
//		case 'D':
//			res = "1101";
//			break;
//		case 'E':
//			res = "1110";
//			break;
//		case 'F':
//			res = "1111";
//			break;
//		}
//		return res;
//	}
//
//}
