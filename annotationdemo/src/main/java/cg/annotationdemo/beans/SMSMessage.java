package cg.annotationdemo.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSMessage implements Message{

	@Override
	public void sendMessage(String msg) {
		System.out.println("Sending msg using sms");
		
	}

}
