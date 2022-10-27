package ch11.sec03.exam02;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		String[] array = {"100", "1oo"};

		for(int i=0; i<=array.length; i++) {
			try {
				System.out.println("===========변환 시작");
				int value = Integer.parseInt(array[i]);
				System.out.println("===========변환 끝");
				System.out.println("array[" + i + "]: " + value);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
			} catch(Exception e) {
				System.out.println("실행에 문제가 있습니다.");
				
			}
			// 이런 결과가 나오는 이유는 
			// ArrayIndexOutOfBoundsException이 Exception 을 상속 받았기 때문에  
			// 궁금한점 1 . Exception여기에 걸렸으면 실행에 문제가 있습니다.에 걸리고 멈춰야되는데 
			// 왜 .. ? 다시 변환 시작 하는건지 .. ? 
			// 궁금한점 2 . ArrayIndex이게 exception 보다 위에있는데 왜 exception 이게 먼저 발동된건지 ? 
			
		}
	}
}