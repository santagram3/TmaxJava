package ch11.sec06;

public class InsufficientException extends Exception {
	// 불충분한 예외 
	public InsufficientException() {
	}

	public InsufficientException(String message) {
		super(message);
	}
}