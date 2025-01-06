package com.Lalitdk.project.uber.uberApp;

import com.Lalitdk.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail("fedeyow771@pofmagic.com",
				"This is the testing mail ",
				"Body of the mail is the i want to send the mail to you an tell u taht ur rode hads been booked");
	}

	@Test
	void sendEmailsMultiple(){
		String email[] = {
				"fedeyow771@pofmagic.com",
				"lalitdeshmukh018@gmail.com",
				"dattatraydeshmukh150@gmail.com",
				"pooja6deshmukh@gmail.com"
		};
		emailSenderService.sendEmail(email,
				"Hello from Lalit's Ride CONNECT",
				"welcome to my ride connect");
	}

}
