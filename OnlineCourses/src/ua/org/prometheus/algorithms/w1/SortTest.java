package ua.org.prometheus.algorithms.w1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import static ua.org.prometheus.algorithms.w1.Sort.*;

public class SortTest {
	int[] testArrayInt;
	Integer[] testArray;
	Integer[] expectedArray;
	int testArraySize = 100;
	int testArrayLowLimit = -99;
	int testArrayHighLimit = 100;
	
	Comparator<Integer> comparator = (o1, o2) -> {compareCount++; return Integer.compare(o1, o2);};
	@Before
	public void setUp() throws Exception {
	}

	@Before
	public void Before() {
		
		resetCounters();
		testArrayInt = new Random().ints(testArraySize, testArrayLowLimit, testArrayHighLimit).toArray();
		testArray = new Random().ints(testArraySize, testArrayLowLimit, testArrayHighLimit)
				.mapToObj(Integer::valueOf).toArray(Integer[]::new);
		expectedArray = Arrays.stream(testArray).sorted().toArray(Integer[]::new);
	}
	public void printOut() {
		System.out.println("Com: " + compareCount + " Sw: " + swapCount + " nn/2: "
	+ (0.0 + (compareCount + swapCount)/2.0)/(testArraySize*testArraySize/2)
	+ " n: " + (0.0 + compareCount + swapCount)/testArraySize);
	}
	@Test
	public void testSortIsertionTArrayComparatorOfT() {
		System.out.println("Insertion");
		sortIsertion(testArray, comparator);
		assertArrayEquals(expectedArray, testArray);
		printOut();
		resetCounters();
		sortIsertion(testArray, comparator);
		assertArrayEquals(expectedArray, testArray);
		printOut();
		resetCounters();
		Comparator<Integer> comparatorReverse = (o1, o2) -> {compareCount++; return Integer.compare(o2, o1);};
		sortIsertion(testArray, comparatorReverse);
		printOut();
		}

	@Test
	public void testSortBublTArrayComparatorOfT() {
		System.out.println("Buble");
		sortBubl(testArray, comparator);
		assertArrayEquals(expectedArray, testArray);
		printOut();
		resetCounters();
		sortBubl(testArray, comparator);
		assertArrayEquals(expectedArray, testArray);
		printOut();
		resetCounters();
		Comparator<Integer> comparatorReverse = (o1, o2) -> {compareCount++; return Integer.compare(o2, o1);};
		sortBubl(testArray, comparatorReverse);
		printOut();
		}
	@Test
	public void testSwap() {
		Integer[] integers = new Integer[]{1,2,3};
		Sort.swap(0, 1, integers);
		assertEquals(1, Sort.swapCount);
	}

}
