package cg.anndemo.beans;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSService  implements MessageService{

	@Override
	public void sendMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(" Sending " + msg + " Using SMS");
	}

}
