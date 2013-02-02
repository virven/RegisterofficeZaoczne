package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.lyzwy.FiguroweLyzwy;
import registerOffice.businessObjects.lyzwy.Lyzwy;
import registerOffice.businessObjects.lyzwy.PersonLyzwy;
import registerOffice.businessObjects.persons.*;
import registerOffice.management.*;
import registerOffice.management.conditions.Condition;
import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Skater> hib= 
				new HibernatePersonManager(session);
				
		
		Skater Monika = new Skater("Monika", "31", "Gdynia");
		Skater Tomek = new Skater("Tomek", "46", "Gdansk");
		Skater Michal = new Skater("Michal", "43", "Sopot");
		Skater Krystyna = new Skater("Krystyna", "33", "Wejherowo");
		Lyzwy damskie = new PersonLyzwy("BAUER","VAPOR 3.0");
		Lyzwy damskie2 = new PersonLyzwy("FILA","DONNA");
		Lyzwy meskie = new PersonLyzwy("ADIDAS","SPEEDER");
		Lyzwy meskie2 = new PersonLyzwy("NIKE","PROFILLER");
		meskie.setOwner(Michal);
		meskie2.setOwner(Tomek);
		damskie.setOwner(Monika);
		damskie2.setOwner(Krystyna);
		Monika.getLyzwy().add(damskie);
		Krystyna.getLyzwy().add(damskie2);
		Tomek.getLyzwy().add(meskie);
		Michal.getLyzwy().add(meskie2);
		
		hib.save(Monika);
		hib.save(Krystyna);
		hib.save(Michal);
		hib.save(Tomek);
		
		List<Skater>results = hib.getAll();
		
		for(Skater p :results)
		{
			System.out.println(p.getName());
		}
		
		
	}

}
