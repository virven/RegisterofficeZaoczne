package registerOffice.businessObjects.lyzwy;

import javax.persistence.Entity;


@Entity
public class PersonLyzwy extends Lyzwy{

	//pole statyczne
	
	//pola prywatne
	
	
	
	private String mark;
	private String model;
	
	//pola publiczne
	
	//konstruktory
	public PersonLyzwy(String mark, String model)
	{
		this.mark=mark;
		this.model=model;
	}
	
	public PersonLyzwy()
	{
		this("","");
	}
	
	//wlasciwosci
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	//metody
	

	@Override
	public String getLyzwyDetails() {
		// TODO Auto-generated method stub
		return mark+" "+model;
	}

	@Override
	public Lyzwy Clone() {
		
		PersonLyzwy returnValue =new PersonLyzwy();
		returnValue.setModel(this.model);
		
		return returnValue;
	}
}
