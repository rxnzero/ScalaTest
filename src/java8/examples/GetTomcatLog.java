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
		
		// ���μ��� ���
//		System.out.println(lines.count());
		
		// �ɰ� ������ ���θ� ����ϵ��� ��
		lines.filter((s) -> s.contains("�ɰ�")).forEach(System.out::println);
		
	}
}
