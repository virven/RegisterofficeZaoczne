package registerOffice.businessObjects.cars;

import registerOffice.Context;
import registerOffice.businessObjects.persons.Person;

public abstract class Car implements CarInterface{

	protected Person owner;
	Context context;
	public Car(){
		context =Context.getInstance();
		context.raiseNumberOfCars();
	}
	
	public void printData()
	{
		System.out.println("Owner: "+owner.getName());
		System.out.println(getCarDetails());
	}
	
	public abstract String getCarDetails();
	
	public abstract Car Clone();
	
	public void setOwner(Person owner)
	{
		this.owner=owner;
	}
	@Override
	protected void finalize() throws Throwable {
		context.reduceCars();
		super.finalize();
	}
	
}
