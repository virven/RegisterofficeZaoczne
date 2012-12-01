package registerOffice.businessObjects.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import registerOffice.Context;
import registerOffice.businessObjects.persons.Person;

@Entity
public abstract class Car implements CarInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Person owner;
	
	@Transient
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void finalize() throws Throwable {
		context.reduceCars();
		super.finalize();
	}
	
}
