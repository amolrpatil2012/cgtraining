package cg.annotationdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cg.annotationdemo.beans.Message;

@Component
public class MessageService {

	
	public Message getMsgProvider() {
		return msgProvider;
	}

	@Autowired
	public MessageService(Message msgProvider) {
		super();
		this.msgProvider = msgProvider;
	}


	public void setMsgProvider(Message msgProvider) {
		this.msgProvider = msgProvider;
	}

	Message msgProvider;
	
	public void sendMessage ( String msg)
	{
		msgProvider.sendMessage(msg);
	}
	
	
}
