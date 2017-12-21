//问题描述
//给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
//
//输入格式
//第一行包含一个数n，表示序列长度。
//
//第二行包含n个正整数，表示给定的序列。
//
//第三个包含一个正整数m，表示询问个数。
//
//接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
//
//输出格式
//总共输出m行，每行一个数，表示询问的答案。
//样例输入
//5
//1 2 3 4 5
//2
//1 5 2
//2 3 2
//样例输出
//4
//2
//数据规模与约定
//对于30%的数据，n,m<=100；
//
//对于100%的数据，n,m<=1000；
//
//保证k<=(r-l+1)，序列中的数<=106。


package algo.algo_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		//采用BufferedReader加快读取速度
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		int[] intArray = new int[n];	//存储序列
		String[] str = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			intArray[i] = Integer.valueOf(str[i]);
		}
		int m = Integer.valueOf(bf.readLine());
		int[][] searchArray = new int[m][3];	//存储查询序列
		for (int i = 0; i < m; i++) {
			String[] tempStr = bf.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				searchArray[i][j] = Integer.valueOf(tempStr[j]);
			}
		}
		
		for (int i = 0; i < m; i++) {
			System.out.println(search(intArray, searchArray[i]));
		}
	}
	
	/**
	 * 查找intArray序列中，从searchArray[0]到searchArray[1]中，第searchArray[2]大的值
	 * @param intArray
	 * @param searchArray
	 * @return
	 */
	public static int search(int[] intArray, int[] searchArray) {
		int[] subArray = new int[searchArray[1] - searchArray[0] + 1];	//存储子数组
		for (int i = 0; i < subArray.length; i++) {
			subArray[i] = intArray[i + searchArray[0] - 1];
		}

		Arrays.sort(subArray);
		
		return subArray[subArray.length - searchArray[2] ];
	}
}
