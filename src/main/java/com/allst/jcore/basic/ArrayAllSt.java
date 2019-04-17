package com.allst.jcore.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author June
 */
public class ArrayAllSt {

	/**
	 * 数组的定义
	 */
	String[] arrayStra = new String[5];
	final static String[] arrayStrb = {"a","b","c","d","e"};
	String[] arrayStrc = new String[]{"a","b","c","d","e"};
	
	public static void main(String[] args) {
//		testArr();
//		new ArrayAllSt().testCrt();
//		testConn();
//		new testParam().testMethod(arrayStrb);
//		testRev();
//		testRemove();
		int[] str = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
		arrayRe(str);
	}

	/**
	 *
	 */
	public static void testArr() {
		int[] arrayInt = {1,2,3,4,5};
		String intArrayString = Arrays.toString(arrayInt);
		System.out.print("----->>");
//		System.out.print(arrayInt)
		System.out.print(intArrayString + "<<----- \n");		
	}

	/**
	 * 从数组中创建集合列表
	 */
	public void testCrt() {
		String[] stringArr = {"a","b","c","d","e"};
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArr));
		System.out.println("----->>" + arrayList + "<<-----");
	}
	/**
	 * 检查数组中是否包含有特定字符
	 */
	public static void testChk() {
		String[] stringArray = { "a", "b", "c", "d", "e" };
		boolean b = Arrays.asList(stringArray).contains("a");
		System.out.println(b); 
	}

	/**
	 * 连接两个数组合并
	 */
	public static void testConn() {
		int[] numa = {1, 2, 3, 4, 5};
		int[] numb = {6, 7, 8, 9, 10};
		int[] numc = ArrayUtils.addAll(numa, numb);
		String numTemp = Arrays.toString(numc);
		System.out.println(numTemp);
	}

	/**
	 * 申明一个数组内连
	 */
	public static class testParam {
		String str = "> ";
		public void testMethod(String[] data) {
			for(int i = 0; i < data.length; i++){
				 str += data[i] + " > ";
			}
			System.out.println(str);
		}
	}

	/**
	 * 反向数组
	 */
	public static void testRev() {
		int[] arr = {1, 2, 3, 4};
		ArrayUtils.reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 删除数组指定位置的元素
	 */
	public static void testRemove() {
		int[] arr = {1, 2, 3, 4, 5};
		int[] other = ArrayUtils.remove(arr, 3);
		System.out.println(Arrays.toString(other));
	}
	
	/**
	 * 求出数组中重复元素的个数
	 */
	public static void arrayRe(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer integer = map.get(array[i]);
			map.put(array[i], integer == null ? 1 : ++integer);
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		for (Entry<Integer, Integer> entry : set) {
			System.out.println(entry.getKey() + " 出现: " + entry.getValue() + " 次");
		}
	}
}
