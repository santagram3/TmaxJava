package ch06.sec07.exam05;

public class Car {
	// 필드 선언
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 1번 생성자 
	Car(String model){
		this.model = model;
	}
	// 2번생성자 
	Car (String model , String color){
		// 1번생성자 호출 
		this(model);
		this.color = color;
	}
	// 3번생성자
	Car(String model, String color, int maxSpeed) {
		// 2번 생성자 호출 
		this(model,color);
		this.maxSpeed = maxSpeed;
	}
}