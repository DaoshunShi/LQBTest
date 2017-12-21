package exam.exam_304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//方法一
//public class Main {
//	public static void main(String[] args) throws NumberFormatException, IOException {
////		Scanner sc = new Scanner(System.in);
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(bf.readLine());
//		String[][] strs = null;
//		Map <Integer, Integer> map = new HashMap<Integer, Integer>();
//		int same = -1, lack = -1;
//		
//		for (int i = 0; i < n; i++) {
//			strs[i] = bf.readLine().split(" ");
//			
//			for (int j = 0; j < strs[i].length; j++) {
//				if (map.get(Integer.parseInt(strs[i][j])) != null) {
//					map.put(Integer.parseInt(strs[i][j]), map.get(Integer.parseInt(strs[i][j])) + 1);
//					same = Integer.parseInt(strs[i][j]);
//				}
//				else {
//					map.put(Integer.parseInt(strs[i][j]), 1);
//				}
//			}
//		}
//		
//		for (int i : map.keySet()) {
//			if (map.get(i + 1) == null) {
//				lack = i + 1;
//				break;
//			}
//		}
//	}
//}


//方法二(ac)
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
//		int n = sc.nextInt();
		int n = Integer.valueOf(sc.nextLine());
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			for (int j = 0; j < str.length; j++) {	
				li.add(Integer.valueOf(str[j]));
			}
		}
		
		
//		for (int i = 0; i < li.size(); i++) {
//			System.out.println(li.get(i));
//		}
//		System.out.println("**************");
		
		int[] value = new int[li.size()];
		for (int i = 0; i < li.size(); i++) {
			value[i] = li.get(i);
		}
		
		getRes(sort(value));
		
	}
	
	
	public static int[] sort(int[] value) {
//		int[] res = new int[value.length];
		int[] res = value;
		
//		for (int i = 0; i < value.length - 1; i++) {
//			System.out.println(value[i]);
//		}
//		
//		for (int i = 0; i < res.length - 1; i++) {
//			System.out.println(res[i]);
//		}
		
		for (int i = 0 ; i < res.length; i++) {
			for (int j = i; j < res.length; j++) {
				if (res[i] > res[j]) {
					int temp = res[j];
					res[j] = res[i];
					res[i] = temp;
				}
			}
		}
		
//		for (int i = 0; i < res.length - 1; i++) {
//			System.out.println(res[i]);
//		}
		
		return res;
	}


	public static void getRes(int[] value) {
		int shorted = -1, same = -1;
		
		
//		for (int i = 0; i < value.length - 1; i++) {
//			System.out.println(value[i]);
//		}
		
		for (int i = 0; i < value.length - 1; i++) {
			if (value[i] == value[i+1]) {
				same = value[i];
			}
			if (value[i+1] - value[i] == 2 && value[i] != value[i + 1]) {
				shorted = value[i] + 1;
			}
		}
		
		System.out.println(shorted + " " + same);
		
		
		
	}
	
}

//164 178 108 109 180 155 141 159 104 182 179 118 137 184 115 124 125 129 168 196
//172 189 127 107 112 192 102 131 133 169 158
//128 102 110 148 139 157 140 195 197
//185 152 135 106 123 173 122 136 174 191 145 116 151 143 175 120 161 134 162 190
//149 138 142 146 199 126 165 156 153 193 144 166 170 121 171 132 101 194 187 188
//113 130 176 154 177 120 117 150 114 183 186 181 100 163 160 167 147 198 111 119 
