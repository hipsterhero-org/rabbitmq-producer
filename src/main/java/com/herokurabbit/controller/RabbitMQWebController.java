package com.herokurabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.herokurabbit.model.Account;
import com.herokurabbit.service.RabbitMQSender;

@RestController
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("name") String name,
						   @RequestParam("id") String id) {
	
	Account account = new Account();
	account.setId(id);
	account.setName(name);
		rabbitMQSender.send(account);

		return "Message sent to the RabbitMQ Successfully";
	}

}

