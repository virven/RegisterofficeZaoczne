package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Person;

public class GetByNameCondition extends Condition<Person>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Person obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
