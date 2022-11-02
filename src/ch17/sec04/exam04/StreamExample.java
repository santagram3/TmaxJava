package ch17.sec04.exam04;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
		// Path 인터페이스 path = Paths.get > 경로 가져오다 . (StreamExample.class.getResource("data.txt").toURI())
		// StreamExample.class.getResource("data.txt").// 경로 가져오고 toURI() 그걸 객체로만듦
		// 결론 ! Path 인터페이스를 사용해서 path 경로객체를 가져옴 // 
		Stream<String> stream2 = Files.lines(path, Charset.defaultCharset());

		Stream<String> stream = Files.lines(path); // 이렇게 해도 읽네 .. ? 
		
		// 스트링내용이 담긴 stream = Files.lines (파일에 라인들)(경로 ,)
		//Charset.defaultCharset() = path로부터 파일을 열고 한행씩 읽으면서 문자열, 스트림 생성, 기본UTF-8 문자셋으로 읽음
		stream.forEach(line -> System.out.println(line) );
		stream.close();
	}
}