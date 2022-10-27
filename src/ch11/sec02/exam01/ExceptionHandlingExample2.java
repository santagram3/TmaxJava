package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자 수: " + result);
		} catch(Exception e) {
			System.out.println("첫번째방법 : "+e.getMessage()); //①
			System.out.println("두번째방법 : "+e.toString()); //②
			System.out.print("세번째방법 : ");
			e.printStackTrace(); //③
		} finally {
			System.out.println("[마무리 실행]\n");
		}
	}

	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
		System.out.println("NullPointerException");
	}
}