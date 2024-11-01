package cg.anndemo.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value="email")
//@Primary
public class EmailService  implements MessageService{
	@Override
	public void sendMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(" Sending " + msg + " Using Email");
	}

}
