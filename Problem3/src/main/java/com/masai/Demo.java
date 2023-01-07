package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext apt = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonService ptservice = apt.getBean("personService",PersonService.class);
		
		ptservice.printMap();
		
		ptservice.printList();
		
		ptservice.printAppName();
	}
}
