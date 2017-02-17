package ua.org.prometheus.algorithms.w1;

import java.util.Comparator;

public class Sort {
	static int swapCount;
	static int compareCount;
	private Sort() {
		//utility class
	}
	public static <T extends Comparable<T>> void sortIsertion(T[] array) {
		//  sorting function signature stab
	}

	public static <T> void sortIsertion(T[] array, Comparator<T> comp) {
		for (int i = 1; i < array.length; i++) {
			T element = array[i];
			for (int j = i - 1; (j>=0)&&comp.compare(array[j], element) > 0; j--) 
				swap(j, j + 1, array);
		}
	}
	public static <T> void sortBubl(T[] array, Comparator<T> comp) {
		boolean flag;
		for (int i = 0; i < array.length; i++) {
			flag = false;
			for (int j = 1; j < array.length - i; j++) 
				if(comp.compare(array[j - 1], array[j]) > 0){
					swap(j - 1, j, array);
					flag = true;
				}
					
			if(!flag)
				break;
		}
	}
	public static <T> void swap(int i1,int i2, T[] array) {
		T temp = array[i1];
		array[i1] =	array[i2];
		array[i2] = temp;
		++swapCount;
	}
	public static void resetCounters() {
		Sort.swapCount = 0;
		Sort.compareCount = 0;
	}
}
