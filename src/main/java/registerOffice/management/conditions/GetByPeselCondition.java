package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Person;

public class GetByPeselCondition extends Condition<Person>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Person obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
