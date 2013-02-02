package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.persons.Skater;

public class HibernatePersonManager 
	implements ManagerInterface<Skater>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Skater get(int id) {
		
		List<Skater> result = 
				session.getNamedQuery("Skater.id")
					.setInteger("id", id).list();
		if(result.size()==0)
			return null;
		
		Skater returnValue = new Skater(
				result.get(0).getName(), 
				result.get(0).getNumer_buta(),
				result.get(0).getAddress());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Skater> getAll() {
		List<Skater> result =
				session.getNamedQuery("Skater.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Skater obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Skater obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Skater.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
