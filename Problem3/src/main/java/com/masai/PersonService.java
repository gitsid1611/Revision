package com.masai;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonService {

	@Autowired
	private Map<Person, Gym>  theMap;
	
	@Autowired
	private List<Person> theList;
	
	@Autowired
	private String appName;

	public Map<Person, Gym> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Person, Gym> theMap) {
		this.theMap = theMap;
	}

	public List<Person> getTheList() {
		return theList;
	}

	public void setTheList(List<Person> theList) {
		this.theList = theList;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
	
	public void printMap(){

		System.out.println("------------");
		for(Entry<Person,Gym> e : theMap.entrySet()) {
			Person pt =e.getKey();
			Gym gy = e.getValue();
			
			System.out.println(pt+"is going in :"+gy+" Gym");
		}
		
		System.out.println("------------");
		
	}

    public void printList(){
    	Person p1 =new Person();
    	System.out.println("--------");
    	theList.stream().sorted().forEach(s->System.out.println(s));
    	
    	
     }

	public void printAppName(){
		
		System.out.println("----------------");
		System.out.println(appName);

		

		}
	
	
}
