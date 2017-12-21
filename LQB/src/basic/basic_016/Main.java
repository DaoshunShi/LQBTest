//问题描述
//　　求出区间[a,b]中所有整数的质因数分解。
//输入格式
//　　输入两个整数a，b。
//输出格式
//　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
//样例输入
//3 10
//样例输出
//3=3
//4=2*2
//5=5
//6=2*3
//7=7
//8=2*2*2
//9=3*3
//10=2*5
//提示
//　　先筛出所有素数，然后再分解。
//数据规模和约定
//　　2<=a<=b<=10000


package basic.basic_016;

//方法3(ac)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      Scanner scan= new Scanner(System.in);
      int a=scan.nextInt();
      int b=scan.nextInt();
      scan.close();

      for(int i=a;i<=b;i++){
    	  if(isPrime(i)){System.out.println(i+"="+i);continue;}
    	  int k=2;
    	  int n=i;
    	  int []n_k=new int[1000];
    	  int counter=0;
    	  while(n!=k){
    		  if(n%k==0){
    			  n_k[counter]=k;
    			  n=n/k;
    			  counter++;
    		  }
    		  else k=k+1;
    	  }
    	  System.out.print(i+"=");
    	  for(int j=0;j<counter;j++)
    		  System.out.print(n_k[j]+"*");
    	  System.out.print(n+"\n");
    		  
      }
      
	}
	static boolean isPrime(int num){
		int tmp=(int)Math.sqrt(num);
		if(num==2||num==3)return true;
		if(num%6!=1&&num%6!=5)return false;
		for(int i=5;i<=tmp;i+=6)
			if(num%i==0||num%(i+2)==0)return false;
		return true;
	}

}


//方法2(运行超时）
//import java.util.Scanner;  
//
//public class Main {  
//  
//    public static void main(String[] args) {  
//        Scanner scan = new Scanner(System.in);  
//        String str = scan.nextLine();  
//        String[] strs = str.split(" ");  
//  
//        int n = Integer.parseInt(strs[0]);  
//        int m = Integer.parseInt(strs[1]);  
//  
//        for (int i = n; i <= m; i++) {  
//            // 调用分解质因数的函数  
//            fen_jie_zhi_yin_shu(i);  
//  
//        }  
//    }  
//  
//    public static void fen_jie_zhi_yin_shu(int x) {  
//        int sushu = 2;  
//        int n = x;  
//        int first = 1;  
//        while (sushu <= n) {  
//            if (!(x % sushu == 0)) {  
//                sushu++;  
//            } else {  
//                x /= sushu;  
//                if (first == 1) {  
//                    System.out.print(n + "=" + sushu);  
//                    first++;  
//                } else {  
//                    System.out.print("*" + sushu);  
//                }  
//            }  
//        }  
//        System.out.println();  
//    }  
//}  


//方法1（ac）
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt(), b = sc.nextInt();
//		
//		Map<Integer, Boolean> zsb = new HashMap<Integer, Boolean>();
//		for (int i = 2; i <= 10000; i++ ) {
//			zsb.put(i, false);
//			for (int j = 2; j < i; j++) {
//				if (i % j == 0) {
//					zsb.put(i, true);
//					continue;
//				}
//			}
//		}
//		
//		for (int i = a; i <= b; i++) {
//			if (zsb.get(i)) {
//				System.out.print(i + "=" );
//				int res = i;
//				int j = 2;
//				while (res > 1) {
//					if (res % j == 0) {
//						System.out.print(j);
//						res = res / j;
//						if (res > 1) {
//							System.out.print("*");
//						}
//					}
//					else {
//						j++;
//					}
//				}
//				System.out.println();
//
//			}
//			else {
//				System.out.println(i + "=" + i);
//			}
//		}
//		
//	}
//
//}
