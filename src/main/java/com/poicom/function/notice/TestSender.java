package com.poicom.function.notice;

import com.poicom.function.notice.factory.SendMailFactory;

public class TestSender {

	public void test(){
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}

}
