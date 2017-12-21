package test.test_002;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		sort2();
	}
	
	public static void sort1() {
		int[] intArray = new int[] {2, 1, 3, -2};
		Arrays.sort(intArray);	//正序排序
		Arrays.sort(intArray);	//逆序排序
		
	}
	
	public static void sort2() {
		LinkedList list = new LinkedList();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(-2);
		Collections.sort(list);	//正序排序
		Collections.sort(list, Collections.reverseOrder());	//逆序排序
		System.out.println("1");
	}

}
