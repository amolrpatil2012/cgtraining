package cg.anndemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

	// Dependency - Field Injection
	//@Autowired								
	MessageService service;									
	
	
	
	public MessageService getService() {
		return service;
	}


	// setter injection
	//@Autowired
	public void setService(MessageService service) {
		this.service = service;
	}

	// constructor injection - default
	@Autowired	
	public MessageProcessor(@Qualifier("twitter") MessageService service) {
		super();
		this.service = service;
	}


	public void handleMsg ( String msg)
	{
		service.sendMsg(msg);
	}
}
