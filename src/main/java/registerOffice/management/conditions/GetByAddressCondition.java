package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Person;

public class GetByAddressCondition extends Condition<Person>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Person obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
