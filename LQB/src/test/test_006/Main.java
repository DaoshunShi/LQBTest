//问题描述
//有一棵 n 个节点的树，树上每个节点都有一个正整数权值。如果一个点被选择了，那么在树上和它相邻的点都不能被选择。求选出的点的权值和最大是多少？
//
//输入格式
//第一行包含一个整数 n 。
//
//接下来的一行包含 n 个正整数，第 i 个正整数代表点 i 的权值。
//
//接下来一共 n-1 行，每行描述树上的一条边。
//
//输出格式
//输出一个整数，代表选出的点的权值和的最大值。
//样例输入
//5
//1 2 3 4 5
//1 2
//1 3
//2 4
//2 5
//样例输出
//12
//样例说明
//选择3、4、5号点，权值和为 3+4+5 = 12 。
//数据规模与约定
//对于20%的数据， n <= 20。
//
//对于50%的数据， n <= 1000。
//
//对于100%的数据， n <= 100000。
//
//权值均为不超过1000的正整数。


package test.test_006;


import java.io.*;
import java.util.*;

public class Main {
	
	final static int MAX_N = 100010;
	//final static int MAX_M = 200007;
	final static long INF = (long)1e16;
	
	class Edge {
		int u, v, nxt;
		Edge () {
			
		}
		Edge (int _u, int _v, int _n) {
			u = _u;
			v = _v;
			nxt = _n;
		}
	}
	
	int edgecnt;
	int dp[][] = new int[MAX_N][2];
	Edge E[] = new Edge[MAX_N * 2];
	int head[] = new int[MAX_N];
	int sta[] = new int[MAX_N * 2];
	boolean vis[] = new boolean[MAX_N];
	
	void add(int u, int v) {
		E[edgecnt] = new Edge(u, v, head[u]);
		head[u] = edgecnt++;
	}
	
	void dfs(int x, int fa) {
		Arrays.fill(vis, false);
		int top = 0;
		vis[x] = true;
		sta[top++] = x;
		while (top > 0) {
			int u = sta[top - 1];
			boolean Ed = false;
			for (int i = head[u]; i + 1 != 0; i = E[i].nxt) {
				int v = E[i].v;
				if (vis[v]) continue;
				Ed = true;
				sta[top++] = v;
				vis[v] = true;
			}
			if (Ed) continue;
			--top;
			for (int i = head[u]; i + 1 != 0; i = E[i].nxt) {
				int v = E[i].v;
				dp[v][0] += Math.max(dp[u][0], dp[u][1]);
				dp[v][1] += dp[u][0];
				
			}
		}
	}
	
	void run() throws IOException {
		int n = cin.nextInt();
		
		for (int i = 1; i <= n; ++i) 
			dp[i][1] = cin.nextInt();
		Arrays.fill(head, -1);
		for (int i = 1; i < n; ++i) {
			int u = cin.nextInt();
			int v = cin.nextInt();
			add(u, v);
			add(v, u);
		}
		dfs(1, -1);
		int ans = Math.max(dp[1][0], dp[1][1]);
		out.println(ans);
		out.close(); 
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	Main() {
		 cin = new InputReader(System.in);
	//	cin = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}

	PrintWriter out;
	InputReader cin;
	//Scanner cin;

	class InputReader {
		InputReader(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			// try {
			// reader = new BufferedReader(new FileReader("input.txt"));
			// } catch (FileNotFoundException ex) {
			// }
			tokenizer = new StringTokenizer("");
		}

		private String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public Integer nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		private BufferedReader reader;
		private StringTokenizer tokenizer;
	}
}




//方法三(淦)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.util.Scanner;
//
//public class Main {
//
//	private static BigDecimal[][] dp = new BigDecimal[100001][2];
//	private static int[][] list = new int [100001][300];
//	
//	private static void createTree (int point1, int point2) {
//		int i = 0, j = 0;
//		while (list[point1][i] != 0) 
//			i++;
//		list[point1][i] = point2;
//		
//		while (list[point2][j] != 0) 
//			j++;
//		list[point2][j] = point1; 
//	}
//	
//	private static void dfs(int start, int root) {
//		int child = list[start][0], i = 0;
//		
//		while (child != 0) {
//			child = list[start][i];
//			if (child != root) {
//				dfs(child, start) ;
////				dp[start][1] += dp[child][0];
////				dp[start][0] += Math.max(dp[child][0], dp[child][1]);
//				dp[start][1] = dp[start][1].add(dp[child][0]);
//				dp[start][0] = dp[start][0].add(dp[child][0].compareTo(dp[child][1]) > 0 ? dp[child][0] : dp[child][1]);
//			}
//			i++;
//			
//		}
//	}
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(bf.readLine());
//		String nums[] = bf.readLine().split(" ");
//		
//		for (int i = 0; i <= n; i++) {
//			dp[i][0] = new BigDecimal(0);
//			dp[i][1] = new BigDecimal(0);
//		}
//		
//		for (int i = 0; i < n; i++){
//			dp[i + 1][1] = new BigDecimal(Integer.parseInt(nums[i]));
//		}
//		for (int i = 1; i < n; i++) {
//			String[] strTree = bf.readLine().split(" ");
//			createTree(Integer.parseInt(strTree[0]), Integer.parseInt(strTree[1]));
//		}
//		
//		dfs(1, 0);
//
////		System.out.println(Math.max(dp[1][1], dp[1][0]));
//		System.out.println(dp[1][1].compareTo(dp[1][0]) > 0 ? dp[1][1] : dp[1][0]);
//	}
//
//}


//方法二(部分结果超出范围)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Main {
//
//	private static int n;
//	private static int[][] dp = new int[100001][2];
//	private static int[][] list = new int [100001][300];
//	
//	private static void createTree (int point1, int point2) {
//		int i = 0, j = 0;
//		while (list[point1][i] != 0) 
//			i++;
//		list[point1][i] = point2;
//		
//		while (list[point2][j] != 0) 
//			j++;
//		list[point2][j] = point1; 
//	}
//	
//	private static void dfs(int start, int root) {
//		int child = list[start][0], i = 0;
//		
//		while (child != 0) {
//			child = list[start][i];
//			if (child != root) {
//				dfs(child, start) ;
//				dp[start][1] += dp[child][0];
//				dp[start][0] += Math.max(dp[child][0], dp[child][1]);
//			}
//			i++;
//			
//		}
//	}
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(bf.readLine());
//		String nums[] = bf.readLine().split(" ");
//		for (int i = 0; i < n; i++){
//			dp[i + 1][1] = Integer.parseInt(nums[i]);
//		}
//		for (int i = 1; i < n; i++) {
//			String[] strTree = bf.readLine().split(" ");
//			createTree(Integer.parseInt(strTree[0]), Integer.parseInt(strTree[1]));
//		}
//		
//		dfs(1, 0);
//
//		System.out.println(Math.max(dp[1][1], dp[1][0]));
//	}
//
//}



//方法一(大量数据时运行超时)
//import java.util.Scanner;
//
//public class Main {
//
//	private static int n;
//	private static int[][] dp = new int[100001][2];
//	private static int[][] list = new int [100001][300];
//	
//	private static void createTree (int point1, int point2) {
//		int i = 0, j = 0;
//		while (list[point1][i] != 0) 
//			i++;
//		list[point1][i] = point2;
//		
//		while (list[point2][j] != 0) 
//			j++;
//		list[point2][j] = point1; 
//	}
//	
//	private static void dfs(int start, int root) {
//		int child = list[start][0], i = 0;
//		
//		while (child != 0) {
//			child = list[start][i];
//			if (child != root) {
//				dfs(child, start) ;
//				dp[start][1] += dp[child][0];
//				dp[start][0] += Math.max(dp[child][0], dp[child][1]);
//			}
//			i++;
//			
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		for (int j = 0; j < n; j++) {
//			dp[j + 1][1] = sc.nextInt();
//		}
//		for (int i = 1; i < n; i++) {
//			createTree(sc.nextInt(), sc.nextInt());
//		}
//		
//		dfs(1, 0);
//		
//		System.out.println(Math.max(dp[1][1], dp[1][0]));
//		
//	}
//
//}
