package cg.annotationdemo.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class EmailMessage implements Message{

	@Override
	public void sendMessage(String msg) {
	
			System.out.println("Sending msg using email");
		
	}

}
