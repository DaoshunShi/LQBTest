package test.test_005;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       int []data=new int[n];
       for(int i=0;i<n;i++)data[i]=scan.nextInt();
       int m=scan.nextInt();
       int [][]lrk=new int [m][3];
       for(int i=0;i<m;i++)
    	   for(int j=0;j<3;j++)lrk[i][j]=scan.nextInt();
       scan.close();
       
       int []answer=new int [m];
       for(int i=0;i<m;i++){
    	   ArrayList<Integer> list=new ArrayList<Integer>();
    	   for(int l=lrk[i][0]-1;l<lrk[i][1];l++)
    		   list.add(data[l]);
    	   //for(int j=0;j<list.size();j++)System.out.print(list.get(j)+" ");
    	   //System.out.println();
    	   int []arr=new int[list.size()];
    	   mergeSort(arr,list,0,list.size()-1);
    	   for(int j=0;j<arr.length;j++)System.out.print(arr[j]+" ");
    	   System.out.println();
    	   for(int j=0;j<list.size();j++)System.out.print(list.get(j)+" ");
    	   //System.out.println();
    	   answer[i]=arr[arr.length-lrk[i][2]];
    	   
       }
    	   
       for(int i=0;i<m;i++)System.out.println(answer[i]);
       
	} 

	
	static void mergeSort(int[] arr, ArrayList<Integer> list, int left, int right) {
		if (left < right) {
			int middle = (right + left) / 2;
			mergeSort(arr, list, left, middle);
			mergeSort(arr, list, middle + 1, right);
			merge(arr, list, left, middle, right);
			// for(int j=0;j<arr.length;j++)System.out.print(arr[j]+" ");
			// System.out.println();
		}
	}

	static void merge(int[] arr, ArrayList<Integer> list, int left, int middle, int right) {
		int pointer1 = left;
		int pointer2 = middle + 1;
		int tmp = left;
		while (pointer1 <= middle && pointer2 <= right) {
			if (list.get(pointer1).compareTo(list.get(pointer2)) <= 0) {
				arr[tmp++] = list.get(pointer1);
				pointer1++;
			} else {
				arr[tmp++] = list.get(pointer2);
				pointer2++;
			}
		}
		while (pointer1 <= middle) {
			arr[tmp++] = list.get(pointer1);
			pointer1++;
		}
		while (pointer2 <= right) {
			arr[tmp++] = list.get(pointer2);
			pointer2++;
		}
	}

}