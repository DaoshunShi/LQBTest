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


package basic.basic_026;

import java.util.HashMap;
import java.util.Scanner;

//方法一(ac)
public class Main {  
    
    public static void main(String[] args) {  
        HashMap<Integer, String> map = new HashMap<>();  
        map.put(0, "zero");  
        map.put(1, "one");  
        map.put(2, "two");  
        map.put(3, "three");  
        map.put(4, "four");  
        map.put(5, "five");  
        map.put(6, "six");  
        map.put(7, "seven");  
        map.put(8, "eight");  
        map.put(9, "nine");  
        map.put(10, "ten");  
        map.put(11, "eleven");  
        map.put(12, "twelve");  
        map.put(13, "thirteen");  
        map.put(14, "fourteen");  
        map.put(15, "fifteen");  
        map.put(16, "sixteen");  
        map.put(17, "seventeen");  
        map.put(18, "eighteen");  
        map.put(19, "nineteen");  
        map.put(20, "twenty");  
        map.put(30, "thirty");  
        map.put(40, "forty");  
        map.put(50, "fifty");  
          
          
        Scanner sc = new Scanner(System.in);  
        int h = sc.nextInt();  
        int m = sc.nextInt();  
        sc.close();  
          
        StringBuffer sb = new StringBuffer();  
          
        //h>=0 h<=24  
        if(h <= 20){  
            sb.append(map.get(h));  
        }else{  
            int temp1 = h/10*10;  
            int temp2 = h%10;  
            sb.append(map.get(temp1));  
            sb.append(" ");  
            sb.append(map.get(temp2));  
        }  
          
        sb.append(" ");  
          
        if(m == 0){  
            sb.append("o'clock");  
        }else if(m <= 20 || m==30 || m==40 || m==50){  
            sb.append(map.get(m));  
        }else{  
            int temp1 = m/10*10;  
            int temp2 = m%10;  
            sb.append(map.get(temp1));  
            sb.append(" ");  
            sb.append(map.get(temp2));  
              
        }  
          
        System.out.println(sb);  
    }  
  
}  


//方法二(ac)
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt(), m = sc.nextInt();
//		System.out.println(readHour(h) + " " + readMinute(m));
//	}
//	
//	public static String readHour(int num) {
//		return readNum(num);
//	}
//	
//	public static String readMinute(int num) {
//		if (num == 0) {
//			return "o'clock";
//		}
//		else {
//			return readNum(num);
//		}
//	}
//	
//	/**
//	 * 读数字 0-59
//	 * @param num
//	 * @return
//	 */
//	public static String readNum(int num) {
//		String result = "";
//		
//		if (num > 20) {
//			switch(num / 10) {
//			case 2:
//				result = "twenty";
//				break;
//			case 3:
//				result = "thirty";
//				break;
//			case 4:
//				result = "forty";
//				break;
//			case 5:
//				result = "fifty";
//				break;
//			}
//			result = result + " " + read10(num % 10);
//			
//		}
//		else {
//			result = read20(num);
//		}
//		return result;
//	}
//	
//	/**
//	 * 读数字 0-20
//	 * @param num
//	 * @return
//	 */
//	public static String read20(int num) {
//		String result = "";
//		switch (num) {
//		case 0:
//			result = "zero";
//			break;
//		case 1:
//			result = "one";
//			break;
//		case 2:
//			result = "two";
//			break;
//		case 3:
//			result = "three";
//			break;
//		case 4:
//			result = "four";
//			break;
//		case 5:
//			result = "five";
//			break;
//		case 6:
//			result = "six";
//			break;
//		case 7:
//			result = "seven";
//			break;
//		case 8:
//			result = "eight";
//			break;
//		case 9:
//			result = "nine";
//			break;
//		case 10:
//			result = "ten";
//			break;
//		case 11:
//			result = "eleven";
//			break;
//		case 12:
//			result = "twelve";
//			break;
//		case 13:
//			result = "thirteen";
//			break;
//		case 14:
//			result = "fourteen";
//			break;
//		case 15:
//			result = "fifteen";
//			break;
//		case 16:
//			result = "sixteen";
//			break;
//		case 17:
//			result = "seventeen";
//			break;
//		case 18:
//			result = "eighteen";
//			break;
//		case 19:
//			result = "nineteen";
//			break;
//		case 20:
//			result = "twenty";
//			break;
//		}
//		return result;
//	}
//
//	/**
//	 * 读数字 0-9
//	 * @param num
//	 * @return
//	 */
//	public static String read10(int num) {
//		String result = "";
//		switch (num) {
//		case 1:
//			result = "one";
//			break;
//		case 2:
//			result = "two";
//			break;
//		case 3:
//			result = "three";
//			break;
//		case 4:
//			result = "four";
//			break;
//		case 5:
//			result = "five";
//			break;
//		case 6:
//			result = "six";
//			break;
//		case 7:
//			result = "seven";
//			break;
//		case 8:
//			result = "eight";
//			break;
//		case 9:
//			result = "nine";
//			break;
//		}
//		return result;
//	}
//	
//}
