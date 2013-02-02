package registerOffice.management;

import java.util.ArrayList;
import java.util.List;

import registerOffice.businessObjects.lyzwy.Lyzwy;
import registerOffice.businessObjects.persons.Skater;

public class DatabaseContext {

	private static List<Skater> persons=new ArrayList<Skater>();
	private static List<Lyzwy> lyzwy=new ArrayList<Lyzwy>();
	
	public static List<Skater> getPersons() {
		return persons;
	}
	public static List<Lyzwy> getLyzwy() {
		return lyzwy;
	}
	
	
}
