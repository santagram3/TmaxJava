package ch11.sec02.CastingException;
public class CastingRun {
	public static void main(String[] args) {
		Animal an = new Cat();
		System.out.println("============1");
		Cat cat = (Cat)an;
		System.out.println("============2");
		cat.sound();
		System.out.println("============3");
		Dog dog = (Dog)an;
		System.out.println("============4");
		dog.sound();
	}
}
