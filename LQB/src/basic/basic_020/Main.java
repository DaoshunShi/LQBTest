//问题描述
//　　Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
//　　比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
//　　所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
//　　十二亿三千四百五十六万七千零九
//　　用汉语拼音表示为
//　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu
//　　这样他只需要照着念就可以了。
//　　你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
//　　注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
//输入格式
//　　有一个数字串，数值大小不超过2,000,000,000。
//输出格式
//　　是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
//样例输入
//1234567009
//样例输出
//shi er yi san qian si bai wu shi liu wan qi qian ling jiu


package basic.basic_020;

//方法一



//方法三(ac)
//import java.util.Scanner;
//
//public class Main {
//
//	static String[] unit = { "", "", "wan ", "yi " };
//
//	static String[] digit = { "", "", "shi ", "bai ", "qian " };
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		while (scanner.hasNext()) {
//			String str = scanner.nextLine();
//			char[] chs = str.toCharArray();
//
//			int len = chs.length;
//			int index = 0;// 记录chs数组的下标
//
//			int group = (len - 1) / 4 + 1;// 4位一组
//			int rest = len % 4;// 最左边的可能不足四位，需要单独处理
//
//			String spell;
//			StringBuffer result = new StringBuffer();
//
//			if (rest != 0) {
//				if (rest == 2) {
//					if (chs[index] == '1') {
//						result.append("shi ");
//					} else {
//						spell = getSpelling(chs[index]);
//						result.append(spell + "shi ");
//					}
//					index++;
//					
//					if (chs[index] != '0') {
//						result.append(getSpelling(chs[index]));
//					}
//					index++;
//
//				} else {
//					boolean flag = true;
//					for (int i = rest; i > 0; i--) {
//						char ch = chs[index++];
//						if (ch != '0') {
//							spell = getSpelling(ch);
//							if (flag) {
//								result.append(spell + digit[i]);
//							} else {
//								result.append("ling " + spell + digit[i]);
//							}
//						} else {
//							flag = false;
//						}
//					}
//				}
//				result.append(unit[group--]);
//			}
//
//			for (int i = group; i > 0; i--) {
//				boolean flag = true;
//				for (int j = 4; j > 0; j--) {
//					char ch = chs[index++];
//					if (ch != '0') {
//						spell = getSpelling(ch);
//						if (flag) {
//							result.append(spell + digit[j]);
//						} else {
//							result.append("ling " + spell + digit[j]);
//							flag = true;
//						}
//					} else {
//						flag = false;
//					}
//				}
//				result.append(unit[group--]);
//			}
//
//			result.deleteCharAt(result.length() - 1);
//			System.out.println(result);
//		}
//	}
//
//	private static String getSpelling(char c) {
//		String spell = null;
//		switch (c) {
//		case '0':
//			spell = "ling ";
//			break;
//		case '1':
//			spell = "yi ";
//			break;
//		case '2':
//			spell = "er ";
//			break;
//		case '3':
//			spell = "san ";
//			break;
//		case '4':
//			spell = "si ";
//			break;
//		case '5':
//			spell = "wu ";
//			break;
//		case '6':
//			spell = "liu ";
//			break;
//		case '7':
//			spell = "qi ";
//			break;
//		case '8':
//			spell = "ba ";
//			break;
//		case '9':
//			spell = "jiu ";
//			break;
//		}
//		return spell;
//	}
//}


//方法二(ac)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		//每组1位
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value = n;
		int len = String.valueOf(n).length();
		int[] li = new int[len];
		for (int i = 0; i < len; i++) {
			li[i] = value % 10;
			value = value / 10;
		}
		
		for (int i = len - 1; i >= 0; i--) {
			if (li[i] == 0) {	//值为0
				if (i > 0 && li[i - 1] != 0) {	//位于非最后一位，且非最后一个0
					readNumber(li[i]);
				}
				if (i % 8 == 0) {	//位于亿位为0
					int temp = n / 100000000;
					if (temp > 0) 
						readWeishu(i);
				}
				else if (i % 8 != 0 && i % 4 == 0) {	//位于万位为0
					int temp = n % 100000000;
					temp = temp / 10000;
					if (temp > 0)
						readWeishu(i);
				}
			}
			else if (li[i] == 1) {	//值为1
				if (i % 4 == 1) {	//位于十位
					if (i + 1 < len) {	//不位于首位
						readNumber(li[i]);
						readWeishu(i);
					}
					else {	//位于首位
						readWeishu(i);
					}
				}
				else {	//不位于十位
					readNumber(li[i]);
					readWeishu(i);
				}
			}
			else {	//值为2-9
				readNumber(li[i]);
				readWeishu(i);
			}
			
			
		}
	}
	
	/**
	 * 读位数
	 * @param i
	 */
	public static void readWeishu(int i) {
		int res = i % 4;
		switch(res) {
		case 0:
			if (i % 8 == 0 && i / 8 == 1) {
				System.out.print("yi ");
			}
			else if (i % 8 !=0 && i % 4 == 0) {
				System.out.print("wan ");
			}
			break;
		case 1:
			System.out.print("shi ");
			break;
		case 2:
			System.out.print("bai ");
			break;
		case 3:
			System.out.print("qian ");
			break;
		}
	}
	
	/**
	 * 读数字本身
	 * @param value
	 */
	public static void readNumber(int value) {
		switch(value) {
		case 0:
			System.out.print("ling ");
			break;
		case 1:
			System.out.print("yi ");
			break;
		case 2:
			System.out.print("er ");
			break;
		case 3:
			System.out.print("san ");
			break;
		case 4:
			System.out.print("si ");
			break;
		case 5:
			System.out.print("wu ");
			break;
		case 6:
			System.out.print("liu ");
			break;
		case 7:
			System.out.print("qi ");
			break;
		case 8:
			System.out.print("ba ");
			break;
		case 9:
			System.out.print("jiu ");
			break;
		}
	}

}
