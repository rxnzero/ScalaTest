package java8.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GetTomcatLog {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Tomcat 9.0/logs/catalina.2017-02-23.log");
		
		Stream<String> lines = Files.lines(path, Charset.forName("euc-kr"));
		
		// 라인수를 출력
//		System.out.println(lines.count());
		
		// 심각 레벨의 라인만 출력하도록 함
		lines.filter((s) -> s.contains("심각")).forEach(System.out::println);
		
	}
}
