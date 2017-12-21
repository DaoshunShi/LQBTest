//http://blog.csdn.net/fxjzzyo/article/details/61914733

package test.sortTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
//		int[] intArray = new int[] {2, 1, 3, -2};
//		Arrays.sort(intArray);
//
//		for(int i = 0;i<intArray.length;i++){
//		        System.out.print(intArray[i]+" ");
//		    }
////		运行结果：-2 1 2 3
////		----------
//		String[] strArray = new String[] {"x","a","B"};
//		Arrays.sort(strArray );
//
//		for(int i = 0;i<strArray .length;i++){
//			System.out.print(strArray[i]+" ");
//		}

//		int[] intArray = new int[] {2, 1, 3, -2};
////		Arrays.sort(intArray, Comparator.reverseOrder());
////		Arrays.sort(intArray,Comparator.reverseOrder());
//		Arrays.sort(intArray,Comparator.reverseOrder()); 
//		for (int i = 0; i < intArray.length; i++) {
//			System.out.print(intArray[i] + " ");
//		}
		
//		LinkedList list = new LinkedList();
//		list.add(2);
//		list.add(3);
//		list.add(1);
//		list.add(-2);
//		Collections.sort(list,Collections.reverseOrder());
//		System.out.println(list.toString());
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(3);
//		list.add(1);
//		list.add(-2);
//		list.sort(Comparator.reverseOrder());
//		System.out.println(list.toString());
		
//	       TreeSet ts=new TreeSet();
//	       ts.add("orange");
//	       ts.add("apple");
//	       ts.add("banana");
//	       ts.add("grape");
//	       Iterator it=ts.iterator();
//	       while(it.hasNext())
//	       {
//	           String fruit=(String)it.next();
//	           System.out.println(fruit);
//	       }
		
	       HashSet h=new HashSet();
	       h.add("1st");
	       h.add("2nd");
	       h.add(new Integer(3));
	       h.add(new Double(4.0));
	       h.add("2nd");            //重复元素，未被添加
	       h.add(new Integer(3));      //重复元素，未被添加
	       h.add(new Date());
	       System.out.println("开始：size="+h.size());
	       Iterator it=h.iterator();
	       while(it.hasNext())
	       {
	           Object o=it.next();
	           System.out.println(o);
	       }
	 
	       h.remove("2nd");
	       System.out.println("移除元素后：size="+h.size());
	       System.out.println(h);
	}

}
