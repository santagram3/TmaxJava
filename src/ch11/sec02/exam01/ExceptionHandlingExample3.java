package ch11.sec02.exam01;
public class ExceptionHandlingExample3 {
	
	public static void main(String[] args) {
		String a1 = "100"; 
		String a2 = "100a"; 
		System.out.println("==============1");
		int s1 = Integer.parseInt(a1);
		System.out.println("==============2");
		int s2 = Integer.parseInt(a2);
		System.out.println("==============3");
		
		System.out.println("s1 = "+ s1);
		System.out.println("==============4");
		System.out.println("s2 = "+ s2);
	}
}