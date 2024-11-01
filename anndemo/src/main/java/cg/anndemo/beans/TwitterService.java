package cg.anndemo.beans;

import org.springframework.stereotype.Component;

@Component("twitter")
public class TwitterService implements MessageService {
	@Override
	public void sendMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(" Sending " + msg + " Using Twitter");
	}
}
