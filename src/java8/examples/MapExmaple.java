package java8.examples;

import java.util.LinkedHashMap;

public class MapExmaple {
	
	public static void main(String[] args) {
		LinkedHashMap map = new LinkedHashMap();
		
		for(int i=0; i<10; i++) {
			map.put(i,  ""+i);
		}
		
	}
}
