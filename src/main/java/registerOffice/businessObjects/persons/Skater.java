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
import registerOffice.businessObjects.lyzwy.*;


@Entity
@Table(name = "Skaters")
@NamedQueries({
	@NamedQuery(
			name="Skater.all",
			query="from Skater p"
			),
	@NamedQuery(
			name="Skater.id",
			query="from Skater p where id= :id"
			),
	@NamedQuery(
			name="Skater.delete",
			query="Delete from Skater p where id=:id"
			)
})
public class Skater {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Imie")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Lyzwy> lyzwy;
	
	private String numer_buta;
	private String addres;
	
	@Transient
	Context context;
	
	public Skater(String name, String numer_buta, String addres)
	{
		this(name,numer_buta);
		this.addres=addres;
	}
	public Skater(String name, String numer_buta)
	{
		context= Context.getInstance();
		context.raisenumberOfPeople();
		this.numer_buta=numer_buta;
		this.name=name;
		this.lyzwy=new ArrayList<Lyzwy>();
	}
	
	public Skater(String name) {
		
		this(name,"");
	}
	
	public Skater()
	{
		
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Lyzwy> getLyzwy() {
		return lyzwy;
	}
	public void setCars(List<Lyzwy> lyzwy) {
		this.lyzwy = lyzwy;
	}

	public String getNumer_buta() {
		return numer_buta;
	}

	public void setPesel(String numer_buta) {
		this.numer_buta = numer_buta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		context.RedukujPeople();
		super.finalize();
	}

	public String getAddress() {
		return addres;
	}

	public void setAddress(String adres) {
		this.addres = adres;
	}

	
}
