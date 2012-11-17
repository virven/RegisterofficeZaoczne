package registerOffice.businessObjects.persons;

import java.util.ArrayList;
import java.util.List;

import registerOffice.Context;
import registerOffice.businessObjects.cars.*;

public class Person {

	private String name;
	private List<Car> cars;
	private String pesel;
	private String address;
	Context context;
	
	public Person(String name, String pesel, String address)
	{
		this(name,pesel);
		this.address=address;
	}
	public Person(String name, String pesel)
	{
		context= Context.getInstance();
		context.raisenumberOfPeople();
		this.pesel=pesel;
		this.name=name;
		this.cars=new ArrayList<Car>();
	}
	
	public Person(String name) {
		
		this(name,"");
	}
	
	public Person()
	{
		
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	@Override
	protected void finalize() throws Throwable {
		context.reducePeople();
		super.finalize();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
