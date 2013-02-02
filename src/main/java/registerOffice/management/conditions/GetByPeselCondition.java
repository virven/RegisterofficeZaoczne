package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Skater;

public class GetByPeselCondition extends Condition<Skater>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Skater obj) {
		
		return obj.getNumer_buta().equalsIgnoreCase(pesel);
	}

}
