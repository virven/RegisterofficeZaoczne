package registerOffice.businessObjects.lyzwy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import registerOffice.Context;
import registerOffice.businessObjects.persons.Skater;

@Entity
public abstract class Lyzwy implements LyzwyInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Skater owner;
	
	@Transient
	Context context;
	public Lyzwy(){
		context =Context.getInstance();
		context.raiseNumberOfLyzwy();
	}
	
	public void printData()
	{
		System.out.println("Owner: "+owner.getName());
		System.out.println(getLyzwyDetails());
	}
	
	public abstract String getLyzwyDetails();
	
	public abstract Lyzwy Clone();
	
	public void setOwner(Skater owner)
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
		context.RedukujLyzwy();
		super.finalize();
	}
	
}
