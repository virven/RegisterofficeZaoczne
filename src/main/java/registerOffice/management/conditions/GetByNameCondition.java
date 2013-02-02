package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Skater;

public class GetByNameCondition extends Condition<Skater>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Skater obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
