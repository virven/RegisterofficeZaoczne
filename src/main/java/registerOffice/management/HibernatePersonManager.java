package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.persons.Person;

public class HibernatePersonManager 
	implements ManagerInterface<Person>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Person get(int id) {
		
		List<Person> result = 
				session.getNamedQuery("Person.id")
					.setInteger("id", id).list();
		
		return result.get(0);
	}

	@Override
	public List<Person> getAll() {
		List<Person> result =
				session.getNamedQuery("Person.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Person obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Person.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
