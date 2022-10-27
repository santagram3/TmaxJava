package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
	public static void printLength(String data) {
		System.out.println("=======printLength start=========");
		int result = data.length();
		System.out.println("길이 구했다 ");
		System.out.println("문자 수: " + result);
	}

	public static void main(String[] args) {
		System.out.println("프로그램시작");
		System.out.println("================1");
		printLength("ThisIsJava");
		System.out.println("================2");
		printLength(null);
		System.out.println("================3");
		System.out.println("[프로그램 종료]");
	}
}