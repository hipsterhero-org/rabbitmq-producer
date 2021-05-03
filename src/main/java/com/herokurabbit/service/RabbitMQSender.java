package com.herokurabbit.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.herokurabbit.model.Account;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${heroku.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${heroku.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Account company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}
}