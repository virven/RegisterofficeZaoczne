package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.cars.Car;
import registerOffice.businessObjects.cars.PersonCar;
import registerOffice.businessObjects.cars.TruckCar;
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
		
		ManagerInterface<Person> hib= 
				new HibernatePersonManager(session);
				
		
		Person adam = new Person("Adam", "1234", "Brzegi 55");
		Car alfa = new PersonCar("Alfa Romeo","gda1234");
		Car peugeot = new PersonCar("Pegeot","gda5678");
		alfa.setOwner(adam);
		peugeot.setOwner(adam);
		adam.getCars().add(alfa);
		adam.getCars().add(peugeot);
		
		hib.save(adam);
		
		List<Person>results = hib.getAll();
		
		for(Person p :results)
		{
			System.out.println(p.getName());
		}
		
		
		
//		ManagerInterface<Person> mgr= new HsqlPersonManager();
//		
////		ManagerInterface<Person> mgr= new PersonManager();
////		
//		mgr.save(new Person("Adam","1234","Gdańsk"));
//		mgr.save(new Person("Paweł","12345","Elbląg"));
//		mgr.save(new Person("Michał","12344","Gdańsk"));
//		mgr.save(new Person("Ola","1234534","Gdynia"));
//		mgr.save(new Person("Ania","1236544","Sopot"));
//		mgr.save(new Person("Adam","12342","Sopot"));
//		mgr.save(new Person("Adam","12344","Gdańsk"));
//		mgr.save(new Person("Adam","12354","Gdynia"));
////		
//		for(Person p: mgr.getAll())
//			System.out.println(p.getName());
//		
//		Condition<Person> byname=new GetByNameCondition("Adam");
//		Condition<Person> byaddress=new GetByAddressCondition("Sopot");
//		Condition<Person> mainCondition=new Condition<Person>()
//				{
//					@Override
//					protected boolean check(Person obj) {
//						return true;
//					}};
//		
//		byname.setCondition(byaddress);
//		mainCondition.setCondition(byname);
//		for(Person p:mgr.getAll(mainCondition))
//		{
//			System.out.println(p.getName()
//					+" "
//					+p.getAddress()
//					+" "+ p.getPesel());
//		}
//		
	}

}
