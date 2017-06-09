package java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	List<Integer> list;
	
	public PredicateExample() {
		list = Arrays.asList(1,2,3,4,5,6,7,8,9);		
	}

	public Predicate<Integer> moreThenThree() {
		return n -> n > 3;
	}
	
	public void eval(Predicate<Integer> predicate) {
	
		for(Integer n : list) {
			if(predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	
	}
	
	public static void main(String[] args) {
		PredicateExample example = new PredicateExample();
		
		example.eval(n -> true);
		
		example.eval(n -> n%2 == 0);
		
		example.eval(example.moreThenThree());
		
		
	}
}
