package registerOffice.businessObjects.persons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.Context;
import registerOffice.businessObjects.cars.*;


@Entity
@Table(name = "Osoby")
@NamedQueries({
	@NamedQuery(
			name="Person.all",
			query="from Person p"
			),
	@NamedQuery(
			name="Person.id",
			query="from Person p where id= :id"
			),
	@NamedQuery(
			name="Person.delete",
			query="Delete from Person p where id=:id"
			)
})
public class Person {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Imie")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Car> cars;
	
	private String pesel;
	private String address;
	
	@Transient
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
