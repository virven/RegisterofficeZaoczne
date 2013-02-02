package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Skater;

public class GetByAddressCondition extends Condition<Skater>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Skater obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
