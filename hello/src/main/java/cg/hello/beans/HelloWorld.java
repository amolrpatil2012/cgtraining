package cg.hello.beans;

public class HelloWorld {
	
	private String message;
	
	public HelloWorld() {}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
