//问题描述
//　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
//输入格式
//　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
//输出格式
//　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
//样例输入
//3 3
//1 2 3
//4 5 6
//7 8 9
//样例输出
//1 4 7 8 9 6 3 2 5
//样例输入
//3 2
//1 2
//3 4
//5 6
//样例输出
//1 3 5 6 4 2


package basic.basic_025;




//方法一(ac)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        int[][] num = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] t = br.readLine().split(" "); 
            for(int j = 0; j < m; j++){
                num[i][j] = Integer.parseInt(t[j]);
            }
        }
        
        int[] memory = new int[n*m];        //存储每一步取到的数
        loopGetNum(n,m,num,memory);
        
        for(int i = 0; i < memory.length; i++){
            System.out.print(memory[i]+" ");
        }
        
    }

    
    private static void loopGetNum(int n, int m, int[][] num, int[] memory) {
        int row = 0;          //行
        int col = 0;          //列
        int cirNum = 0;       //圈数
        int total = n * m;    //总的执行次数，即数字的总个数
        
        for(int i = 0; i < total; i++){
            if(row < n && col == cirNum){                //第一列
                memory[i] = num[row][col];
                row++;
            }else if(row == n && col < m-1){            //最后一行
                col++;
                memory[i] = num[row-1][col];
            }else if(row-1 > cirNum && col == m-1){        //最后一列
                row--;
                memory[i] = num[row-1][col];
            }else if(row-1 == cirNum && col > cirNum){    //第一行
                col--;
                memory[i] = num[row-1][col];
                if(row-1 == cirNum && col == cirNum+1){    //若到第一行第二个数字，则缩小矩阵行列范围，形成子矩阵
                    cirNum++;
                    n = n-1;
                    m = m-1;
                    row = cirNum;
                    col = cirNum;
                }
                
            }
        }
    }
}


//方法二(运行超时)
//import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		//ac
////		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////	    String[] str = br.readLine().split(" ");
////	    int n = Integer.parseInt(str[0]);
////	    int m = Integer.parseInt(str[1]);
////	      
////	    int[][] num = new int[n][m];
////	    for(int i = 0; i < n; i++){
////	    	String[] t = br.readLine().split(" "); 
////	        for(int j = 0; j < m; j++){
////	        	num[i][j] = Integer.parseInt(t[j]);
////	        }
////	    }
////	      
////	    read(num);
//		
//    //运行超时
//		Scanner sc = new Scanner(System.in);
//		String[] str = sc.nextLine().split(" ");
//		int m = Integer.parseInt(str[0]), n = Integer.parseInt(str[1]);
//		//比
////		int m = sc.nextInt(), n = sc.nextInt();
////		String str = sc.nextLine(); 
//		//快
//		
//		
//		int[][] matrix = new int[m][n];
//		for (int i = 0; i < m; i++) {
//			String[] t = sc.nextLine().split(" ");
//			for (int j = 0; j < n; j++) {
//				matrix[i][j] = Integer.parseInt(t[j]);
//			}
//		}
//		//比
////		for (int i = 0; i < m; i++) {
////			for (int j = 0; j < n; j++) {
////				matrix[i][j] = sc.nextInt();
////			}
////		}
//		//快
//		
//		read(matrix);
//	}
//	
//	
//	public static void read(int[][] value) {
//		int top = 0, left = 0, bottom = value.length - 1, right = value[0].length - 1;	//标志边界
//		char direction = 'd';	//标志读取方向	d:向下 u:向上 l:向左 r:向右
//		int i = 0, j = 0;	//标记当前位置
//		while (bottom >= top && left <= right) {
//			switch (direction) {
//			case 'd':
//				while (i <= bottom) {	//向下读值
//					System.out.print(value[i][j] + " ");
//					i++;
//				}
//				i--;	//回退一格，保证i=bottom
//				j++;
//				direction = 'r';
//				left++;
//				break;
//			case 'r':
//				while (j <= right) {
//					System.out.print(value[i][j] + " ");
//					j++;
//				}
//				j--;	//回退一格，保证j=right
//				i--;
//				direction = 'u';
//				bottom--;
//				break;
//			case 'u':
//				while (i >= top) {
//					System.out.print(value[i][j] + " ");
//					i--;
//				}
//				i++;	//回退一格，保证i=bottom
//				j--;
//				direction = 'l';
//				right-- ;
//				break;
//			case 'l':
//				while (j >= left) {
//					System.out.print(value[i][j] + " ");
//					j--;
//				}
//				j++;	//回退一格，保证j=left
//				i++;
//				direction = 'd';
//				top++;
//			}
//		}
//	}
//
//}
