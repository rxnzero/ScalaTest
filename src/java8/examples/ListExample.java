package java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListExample {

	public static void main(String[] args) {
		List<String> list = (List<String>)Arrays.asList("a", "b", "c");
		
		String joined = list.stream().collect(Collectors.joining(", "));
		System.out.println(joined);
		
		for(String s : list) System.out.println("1 - " + s);
		
		for(int i=0; i<list.size(); i ++) System.out.println("2 - " + list.get(i));		
	}

}
