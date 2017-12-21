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


package basic.basic_012;


//方法一(ac)
import java.util.Scanner;  

public class Main {  
    static StringBuilder[] octals = null;//保存八进制数  
    
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        int len = sc.nextInt();  
        octals = new StringBuilder[len];  
        for (int i = 0; i < len; i++) {  
            trans(sc.next(),i);  
        }  
        for (int i = 0; i < octals.length; i++) {  
            System.out.println(octals[i]);  
        }  
    }  
    
    public static void trans(String value,int i){  
        StringBuilder sb = new StringBuilder();  
        StringBuilder result = new StringBuilder();  
        char[] c = value.toCharArray();  
        for (int j = 0; j < value.length(); j++) {  
            switch(c[j]){  
            case '1' : result.append("0001");break;  
            case '2' : result.append("0010");break;  
            case '3' : result.append("0011");break;  
            case '4' : result.append("0100");break;  
            case '5' : result.append("0101");break;  
            case '6' : result.append("0110");break;  
            case '7' : result.append("0111");break;  
            case '8' : result.append("1000");break;  
            case '9' : result.append("1001");break;  
            case '0' : result.append("0000");break;  
            case 'A' : result.append("1010");break;  
            case 'B' : result.append("1011");break;  
            case 'C' : result.append("1100");break;  
            case 'D' : result.append("1101");break;  
            case 'E' : result.append("1110");break;  
            case 'F' : result.append("1111");break;  
            }  
        }  
        if(result.length() % 3 != 0){  
            result.insert(0, "0");  
        }  
        if(result.length() % 3 != 0){  
            result.insert(0, "0");  
        }  
          
        for (int j = 0; j < result.length() ; j += 3) {  
            String s = result.substring(j,j+3);  
            if(s.equals("000")){  
                if(j !=0){  
                    sb.append('0');//如果是第一位就不要放0  
                }  
            }  
            else if(s.equals("001"))  
                sb.append('1');  
            else if(s.equals("010"))  
                sb.append('2');  
            else if(s.equals("011"))  
                sb.append('3');  
            else if(s.equals("100"))  
                sb.append('4');  
            else if(s.equals("101"))  
                sb.append('5');  
            else if(s.equals("110"))  
                sb.append('6');  
            else if(s.equals("111"))  
                sb.append('7');               
        }  
        octals[i] = sb;  
    }  
}  


//方法二(ac,较慢)
//较慢原因:每次转换需转换4次(16->10->2->10->8)，而方法一每次转换只需2次(16->2->8)，因此速度较慢
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		StringBuilder[] strO = new StringBuilder[n];
//		
//		for (int i = 0; i < n; i++) {
//			strO[i] = transHtoO (sc.next());
//		}
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(strO[i]);
//		}
//	}
//	
//	public static StringBuilder transHtoO (String value) {
//		StringBuilder resultB = new StringBuilder();
//		StringBuilder resultO = new StringBuilder();
//		
//		for (int i = 0; i < value.length(); i++) {
//			String temp = value.charAt(i) + "";	//获取第i位的十六进制数
//			temp = Integer.valueOf(temp, 16).toString();	//将十六进制数转为十进制
//			temp = Integer.toBinaryString(Integer.valueOf(temp)).toString();	//将十进制转换为二进制
//			while (temp.length() < 4) {	//为次二进制数补0
//				temp = "0" + temp;
//			}
//			resultB.append(temp);	//存储二进制
//		}
//		
//		while (resultB.length() % 3 != 0) {
//			resultB.insert(0, "0");
//		}
//		
//		for (int i = 0; i < resultB.length(); i += 3) {
//			String temp = resultB.substring(i, i+3);	//获取二进制的数值
//			temp = Integer.valueOf(temp, 2).toString();	//将二进制转换为十进制
//			temp = Integer.toOctalString(Integer.valueOf(temp));	//将十进制转换为八进制
//			resultO.append(temp);	//存储八进制
//		}
//		
//		if (resultO.substring(0, 1).equals("0")) {	//当八进制数以0开始时，删除0
//			resultO.deleteCharAt(0);
//		}
//		
////		System.out.println(resultB);
//		return resultO;
//	}
//}