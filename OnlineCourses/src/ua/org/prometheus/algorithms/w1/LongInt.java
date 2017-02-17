package ua.org.prometheus.algorithms.w1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongInt {
	ArrayList<Short> value = new ArrayList<>();
	int sections;
	boolean sign;
	
	public LongInt(short number) {
		this.value.add(number);
	}
	
	public LongInt(String number) {
		for (int i = number.length(); i >= 4; i -= 4) {
			String part = number.substring(i - 4, i);
			value.add(new Short(part));
		}
		String part = number.substring(0, number.length()%4);
		value.add(new Short(part));
	}

	@Override
	public String toString() {
//		return sign?"-":"" + Arrays.toString(value.toArray());
//		return sign?"-":"" + value.stream().collect(StringBuilder::new,
////		           StringBuilder::appendCodePoint, StringBuilder::append).toString();
//		return sign?"-":"" + value.stream().collect(StringBuilder::new,
//        StringBuilder::append, StringBuilder::append).toString();
		List<Short> list;
		
		return null;
	}
	
}
