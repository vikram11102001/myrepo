package basicprograms;

import java.util.ArrayList;

class Person{
	private int id;
	private String name;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

public class MatchingCities {
	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Ram");
		p1.setLocation("Chennai");
		
		Person p2 = new Person();
		p2.setId(2);
		p2.setName("Surya");
		p2.setLocation("Chennai");
		
		Person p3 = new Person();
		p3.setId(3);
		p3.setName("Karthi");
		p3.setLocation("Villupuram");
		
		ArrayList persons = new ArrayList();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		String locationToMatch = "Chennai";
		
		
		MatchingCities obj = new MatchingCities();
		System.out.println(obj.getNamesByLocation(persons, locationToMatch));
		
		
		
						
		
	}
	
	public ArrayList<String> getNamesByLocation(ArrayList<Person> persons, String location){
		 
		ArrayList matchingNames =null;
		for(Person p : persons) {
			if (p.getLocation().equals(location)) {
				if(matchingNames == null) {
					matchingNames = new ArrayList();
				}
                matchingNames.add(p.getName());
            }
			
		}
		return matchingNames;
	}
	
}
