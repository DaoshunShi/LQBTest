//问题描述
//　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
//　　交换的定义是：交换两个相邻的字符
//　　例如mamad
//　　第一次交换 ad : mamda
//　　第二次交换 md : madma
//　　第三次交换 ma : madam (回文！完美！)
//输入格式
//　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
//　　第二行是一个字符串，长度为N.只包含小写字母
//输出格式
//　　如果可能，输出最少的交换次数。
//　　否则输出Impossible
//样例输入
//5
//mamad
//样例输出
//3


package basic.basic_019;

//方法一(ac)
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());

            String str = scanner.nextLine();
            char[] chs = str.toCharArray();	//将原字符串转换为数组

            int[] count = new int[26];
            char ch = '0';
            int oddchar = 0;

            for (int j = 0; j < chs.length; j++) {	//记录每个字母出现次数
                int index = chs[j] - 'a';
                count[index]++;
            }

            for (int i = 0; i < 26; i++) {	//根据字母出现次数判断是否能组成回文
                if (count[i] % 2 != 0) {
                    oddchar++;
                    ch = (char) (i + 'a');
                }
            }

            if (oddchar > 1) {
                System.out.println("Impossible");
            } else {
                int result = exchange(chs, n, ch);	//计算形成完美回文所需移动次数
                System.out.println(result);
            }
        }
    }

    /**
     * 计算形成完美回文所需移动次数
     * @param chs	原数组
     * @param n		字符串上都
     * @param ch	不重复字母
     * @return
     */
    private static int exchange(char[] chs, int n, char ch) {
        int count = 0, i, j, k;
        for (i = 0; i < n / 2; i++) {	//从前向后遍历，使得从前向后第i位的字母与从后往前的第i位字母相同
            if (chs[i] == ch) {	//是不重复字母，则从后往前比较
                for (j = i; j < n - i - 1; j++) {
                    if (chs[j] == chs[n - i - 1]) {
                        break;
                    }
                }

                count += j - i;

                for (k = j; k > i; k--) {
                    chs[k] = chs[k - 1];
                }
                chs[i] = chs[n - i - 1];

            } else {	//是重复字母，则从前往后比较
                for (j = n - i - 1; j >= i; j--) {
                    if (chs[j] == chs[i]) {
                        break;
                    }
                }

                count += n - i - 1 - j;

                for (k = j; k < n - i - 1; k++) {
                    chs[k] = chs[k + 1];
                }
                chs[n - i - 1] = chs[i];
            }
        }
        return count;
    }
}


//方法二(wa)
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
////		int[] count = new int[26];
////		boolean possible = true;
//		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
//		Scanner sc = new Scanner(System.in);
//		int singleNum = 0, moveNum = 0, n = sc.nextInt();
//		String str = sc.next();
//		StringBuilder sb = new StringBuilder(str);
//		
//		//判断是否可能
////		for (int i = 0; i < str.length(); i++) {
////			char t = sb.charAt(i);
////			count[t - 'a'] ++;
////		}
////		for (int i = 0; i < 26; i++) {
////			if (count[i] % 2 != 0) {
////				singleNum++;
////			}
////		}
//		
//		//移动
//		for (int i = 0; i < str.length()/ 2 ; i++) {
//			for (int j = str.length() - i - 1; j >= i; j--) {
//				if (sb.charAt(i) == sb.charAt(j)) {
//					if (i < j) {
//						moveNum += str.length() - i - 1 - j;
//						sb.deleteCharAt(j);
//						sb.insert(str.length() - 1 - i, sb.charAt(i));
////						System.out.println(sb);
//						break;
//					}
//					else if (i == j) {
////						singleNum++;
//						char t = sb.charAt(i);
//						sb.deleteCharAt(i);
//						sb.insert(i+1, t);
//						moveNum++;
//						j--;
////						System.out.println(sb);
//						break;
//					}
//				}
//			}
//		}
//	
//		if (singleNum > 1) {
//			System.out.println("Impossible");
//		}
//		else {
//			System.out.println(moveNum);
//		}
//	}
//	
//
//}
