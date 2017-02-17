package ua.org.prometheus.algorithms.w1;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LongIntTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLongIntShort() {
		
	}

	@Test
	public void testLongIntString() {
		LongInt number = new LongInt("1234567890");
		System.out.println(number);
	}

	@Test
	public void testIterator() {
		   LinkedList<Object> list = new LinkedList<Object>();

		   // add some elements
		   list.add("Hello");
		   list.add(2);
		   list.add("Chocolate");
		   list.add("10");

		   // print the list
		   System.out.println("LinkedList:" + list);

		   // set Iterator as descending
		   Iterator<Object> x = list.descendingIterator();

		   // print list with descending order
		   System.out.println();
		   while (x.hasNext()) {
		   System.out.print(x.next() + " ");
		   }
		   StringJoiner sJt = new StringJoiner(" ");
		   StringBuilder sBuilder = new StringBuilder();
		   list.stream().reduce("",  (a,b) -> sBuilder.append(" " + b));
		   list.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
		   System.out.println("\n\n sb1 \n" + sBuilder.toString());
		   

		   list.stream().forEach(a -> sJt.add(a.toString()));
		   System.out.println("\n\n collect \n" + sJt.toString());
				   
		   System.out.println("\n\n collect \n" + 
				   list.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
		   
		   sBuilder.setLength(0);
		   list.iterator().forEachRemaining(i -> sBuilder.append(i + " "));
		   System.out.println("\n sb2 \n" + sBuilder.toString());
		   
		   StringJoiner sJ1 = new StringJoiner(" ");
		   list.iterator().forEachRemaining(a -> sJ1.add(a.toString()));
		   System.out.println("averse: \n" + sJ1.toString());
		   
		   StringJoiner sJ2 = new StringJoiner(" ");
		   list.descendingIterator().forEachRemaining(a -> sJ2.add(a.toString()));
		   System.out.println("reverse: \n" + sJ2.toString());
	}
}
