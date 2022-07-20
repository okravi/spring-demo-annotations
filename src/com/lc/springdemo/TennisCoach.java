package com.lc.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") -> DisposableBean should be implemented
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {}
	
	//define init method
	@PostConstruct
	public void doInit() {
		System.out.println("Initialising");
	}
	
	//define destroy method for singletons
	@PreDestroy
	public void doDestroy() {
		System.out.println("Destroying");

	}
	
	//define destroy method for prototypes
	/*
	@Override
	public void destroy() throws Exception {
		System.out.println(">> TennisCoach: inside destroy()");
		
	}
	*/
	
	/*
	//@Autowired can be omitted if only there is only one public constructor
	@Autowired 
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	//define a setter method for injections
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
