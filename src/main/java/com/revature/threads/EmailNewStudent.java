package com.revature.threads;

import com.revature.services.sendMail;

public class EmailNewStudent implements Runnable{

	@Override
	public void run() {
		sendMail.sendEmail("See you in class!", "gilbybirdsong@gmail.com");
	}

}
