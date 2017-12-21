//问题描述
//　　Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。
//　　给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
//　　1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa + pb。
//　　2. 重复步骤1，直到{pi}中只剩下一个数。
//　　在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
//　　本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。
//
//　　例如，对于数列{pi}={5, 3, 8, 2, 9}，Huffman树的构造过程如下：
//　　1. 找到{5, 3, 8, 2, 9}中最小的两个数，分别是2和3，从{pi}中删除它们并将和5加入，得到{5, 8, 9, 5}，费用为5。
//　　2. 找到{5, 8, 9, 5}中最小的两个数，分别是5和5，从{pi}中删除它们并将和10加入，得到{8, 9, 10}，费用为10。
//　　3. 找到{8, 9, 10}中最小的两个数，分别是8和9，从{pi}中删除它们并将和17加入，得到{10, 17}，费用为17。
//　　4. 找到{10, 17}中最小的两个数，分别是10和17，从{pi}中删除它们并将和27加入，得到{27}，费用为27。
//　　5. 现在，数列中只剩下一个数27，构造过程结束，总费用为5+10+17+27=59。
//输入格式
//　　输入的第一行包含一个正整数n（n<=100）。
//　　接下来是n个正整数，表示p0, p1, …, pn-1，每个数不超过1000。
//输出格式
//　　输出用这些数构造Huffman树的总费用。
//样例输入
//5
//5 3 8 2 9
//样例输出
//59


package basic.basic_028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	private static int sum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] str = bf.readLine().split(" ");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++){
			list.add(Integer.parseInt(str[i]));
		}
		
		for (int i = 0; i < n; i++) {
			list = getNext(list);
		}
		
		System.out.println(sum);
	}
	
	public static List<Integer> getNext(List<Integer> list) {
		List<Integer> li = new ArrayList<Integer>();
		li = list;
		li.sort(null);
		if (li.size() > 1) {
			int temp = li.get(0) + li.get(1);
			sum += temp;
			li.remove(1);
			li.remove(0);
			li.add(temp);
		}
//		
//		for (int i = 0; i < li.size(); i++) {
//			System.out.print(li.get(i) + " ");
//		}
//		System.out.println();
		
		return li;
	}

}
