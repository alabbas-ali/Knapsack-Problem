package main;

import java.util.ArrayList;
import java.util.List;

interface Service {
	public List<Persone> getList();
}

class PersoneService implements Service{

	public List<Persone> getList(){
		List<Persone> people = new ArrayList<>();
		Persone p1= new Persone();
		p1.setFirstName("Sam");
		Persone p2= new Persone();
		p2.setFirstName("Peter");
		people.add(p1);
		people.add(p2);
		return people;
	}
}

class PoliceManService implements Service{

	@Override
	public List<Persone> getList() {
		List<Persone> people = new ArrayList();
		Persone p1= new Persone();
		p1.setFirstName("Sam");
		Persone p2= new Persone();
		p2.setFirstName("Peter");
		people.add(p1);
		people.add(p2);
		return people;
	}
	
}


public class Persone {
	
	String firstName;
	
	String lastName;
	
	int age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		Service s = new PoliceManService();
		s.getList();
	}
}









