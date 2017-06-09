package java8.examples;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// java8 functions
public class LambdaExample {
	
	static Func sub = (int a, int b) -> a - b;
	static Func add = (int a, int b) -> a + b;
	
	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("Hello World.");
		}).start();
	
		int result = add.calc(1,2) + sub.calc(3, 4);
		
		System.out.println(String.format("result = %d", result));
		
		Arrays.asList(1,2,3).stream();
		Arrays.asList(1,2,3).parallelStream();
		
		Arrays.asList(1,2,3).stream().forEach(System.out::println);
		
		Arrays.asList(1,2,3).stream().map(i -> i*i).forEach(System.out::println);
	
		Arrays.asList(1,2,3).stream().limit(1).forEach(System.out::println); 
		
		Arrays.asList(1,2,3).stream().skip(1).forEach(System.out::println); 
		
		Arrays.asList(1,2,3).stream().filter(i-> 2>=i).forEach(System.out::println);
		
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println); // 1,2,3,4,5,6,7,8,9
		
		Arrays.asList(1,2,3).stream().reduce((a,b)-> a-b).get(); // -4
		
		
		List<Integer> collected = (List<Integer>) Arrays.asList(1,2,3).stream().collect(Collectors.toList());
		System.out.println(collected);
		
		Iterator<Integer> it = Arrays.asList(1,2,3).stream().iterator();
		it.forEachRemaining(System.out::println);
		
		
	}
	
}
