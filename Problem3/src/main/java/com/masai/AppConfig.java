package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {
	@Bean
	public Map<Person, Gym> theMap(){
		
		Map<Person, Gym> theMp = new HashMap<>();
		
		theMp.put(new Person(1, "Sudhir", "sid1611@gmail.com", 21, "7778748279"), new  Gym(1, "fitness", 3000));
		
		theMp.put(new Person(2, "nitin", "zkir@gmail.com", 22, "9895674123"), new  Gym(4, "pro fit", 2000));
		
		theMp.put(new Person(1, "ashu", "ashu1@gmail.com", 21, "1237894560"), new  Gym(5, "fitty", 3500));
		
		return theMp;
		
	}
	@Bean
	public List<Person> settheList(){
		List<Person> li =new ArrayList<>();
		
		li.add(new Person(1,"sid", "sid@gmail.com", 23, "9890013411"));		
		li.add(new Person(2,"shub", "shub@gmail.com", 23, "1234513411"));
		li.add(new Person(3,"akash", "akash@gmail.com", 23, "9812345411"));
		li.add(new Person(4,"ezaz", "ezaz@gmail.com", 23, "7894513411"));
		li.add(new Person(5,"nitin", "saa@gmail.com", 23, "65478813411"));
		
		
		return li;
		
	}

	@Bean
	public String appName() {
		return "Fit-Guru";
	}
	
}
