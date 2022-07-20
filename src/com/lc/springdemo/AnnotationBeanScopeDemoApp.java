package com.lc.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//load Spring configuration code
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		//check if they are the same
		System.out.println(theCoach==alphaCoach);
		//call a method on the bean
		System.out.println(alphaCoach.getDailyFortune());
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
	}

}
