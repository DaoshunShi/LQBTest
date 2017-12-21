//问题描述
//如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。由于这个数目很大，请你输出它对1000000007取模后的值。
//
//输入格式
//输入包含两个正整数，K和L。
//
//输出格式
//输出一个整数，表示答案对1000000007取模后的值。
//样例输入
//4 2
//样例输出
//7
//数据规模与约定
//对于30%的数据，KL <= 106；
//
//对于50%的数据，K <= 16， L <= 10；
//
//对于100%的数据，1 <= K,L <= 100。


package algo.algo_003;


//方法二(ac)
import java.util.Scanner;  

public class Main
{  

    final static int MOD = 1000000007;  

    public static void main(String[] args)  
    {  
        Scanner input = new Scanner(System.in);  

        while (input.hasNext())  
        {  
            int k = input.nextInt();  
            int l = input.nextInt();  
            int num = 0;  
            int[][] nums = new int[l][k];  
            for (int i = 0; i < l; i++)  
                for (int j = 0; j < k; j++)  
                    nums[i][j] = 0;  
            for (int j = 0; j < k; j++)  
                nums[0][j] = 1;  
            for (int i = 1; i < l; i++)  
                for (int j = 0; j < k; j++)  
                    for (int x = 0; x < k; x++)  
                    {  
                        if (x != j - 1 && x != j + 1)  
                        {  
                            nums[i][j] += nums[i - 1][x];  
                            nums[i][j] %= MOD;  
                        }  
                    }  
            for (int j = 1; j < k; j++)  
            {  
                num += nums[l - 1][j];  
                num %= MOD;  
            }  
            System.out.println(num);  
        }  

    }  
}  


//方法一(ac)
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt(), l = sc.nextInt();
//		int[][] matrix = new int[l][k];
//		System.out.println(getCount(k, l));
//	}
//
//	public static int getCount(int k, int l) {
//		int[] sum = new int[l];
//		int[][] matrix = new int[l][k];
//		
//		matrix[0][0] = 0;
//		for (int i = 1; i < k; i++) {
//			matrix[0][i] = 1;
//			sum[0] = k - 1;
//		}
//		for (int i = 1; i < l; i++) {
//			matrix[i] = getMatrix(matrix[i - 1], k);
//			sum[i] = 0;
//			for (int t = 0; t < k; t++) {
//				sum[i] = ( sum[i] + matrix[i][t]) % 1000000007;
//			}
//		}
//		return sum[l - 1];
//	}
//
//	public static int[] getMatrix(int[] previousCount, int k) {
//		int[] list = new int[k];
//		for (int i = 0; i < k; i++) {
//			for (int j = 0; j < k; j++) {
//				if (i != j - 1 && i != j + 1) {
//					list[i] += previousCount[j];
//					list[i] %= 1000000007;
//				}
//			}
//		}
//		return list;
//	}
//}
