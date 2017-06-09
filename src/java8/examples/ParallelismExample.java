package java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParallelismExample {
	
	public static void main(String[] args) throws Exception {
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers =
		    new ArrayList<>(Arrays.asList(intArray));

		System.out.println("listOfIntegers:");
		listOfIntegers
		    .stream()
		    .forEach(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("listOfIntegers sorted in reverse order:");
		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed(); 
		Collections.sort(listOfIntegers, reversed);  

		listOfIntegers
		    .stream()
		    .forEach(e -> System.out.print(e + " "));
		System.out.println("");
		     
		System.out.println("Parallel stream");
		listOfIntegers
		    .parallelStream()
		    .forEach(e -> System.out.print(e + " "));
		System.out.println("");
		    
		System.out.println("Another parallel stream:");
		listOfIntegers
		    .parallelStream()
		    .forEach(e -> System.out.print(e + " "));
		System.out.println("");
		     
		System.out.println("With forEachOrdered:");
		listOfIntegers
		    .parallelStream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		
		
		
		try {
		    List<String> listOfStrings =
		        new ArrayList<>(Arrays.asList("one", "two"));
		         
		    // This will fail as the peek operation will attempt to add the
		    // string "three" to the source after the terminal operation has
		    // commenced. 
		             
		    String concatenatedString = listOfStrings
		        .stream()
		        
		        // Don't do this! Interference occurs here.
		        .peek(s -> listOfStrings.add("three"))
		        
		        .reduce((a, b) -> a + " " + b)
		        .get();
		                 
		    System.out.println("Concatenated string: " + concatenatedString);
		         
		} catch (Exception e) {
		    System.out.println("Exception caught: " + e.toString());
		}
		
		
		List<Integer> serialStorage = new ArrayList<>();
	     
		System.out.println("Serial stream:");
		listOfIntegers
		    .stream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { serialStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		     
		serialStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Parallel stream:");
		List<Integer> parallelStorage = Collections.synchronizedList(
		    new ArrayList<>());
		listOfIntegers
		    .parallelStream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { parallelStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		     
		parallelStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
	}
}
