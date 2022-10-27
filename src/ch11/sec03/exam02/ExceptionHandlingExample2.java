package ch11.sec03.exam02;

public class ExceptionHandlingExample2 {
	public static void main(String[] args) {
		String[] array = {"100", "1oo"};

		for(int i=0; i<=array.length; i++) {
			try {
				System.out.println("===========변환 시작");
				int value = Integer.parseInt(array[i]);
				System.out.println("===========변환 끝");
				System.out.println("array[" + i + "]: " + value);
			} catch(Exception e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch(ArrayIndexOutOfBoundsException e) {
				// 이렇게 순서가 바뀌게 되면 
				System.out.println("실행에 문제가 있습니다.");
			}
			// 이런 결과가 나오는 이유는 
			// ArrayIndexOutOfBoundsException이 Exception 을 상속 받았기 때문에  
		}
	}
}