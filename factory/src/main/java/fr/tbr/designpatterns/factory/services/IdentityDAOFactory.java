package fr.tbr.designpatterns.factory.services;

import java.util.HashMap;
import java.util.Map;

import fr.tbr.designpatterns.factory.datamodel.Identity;

public class IdentityDAOFactory {

	public static final String JDBC = "JDBC";
	
	public static final Map<String, Class<? extends DAO>> productTypes = new HashMap<String, Class<? extends DAO>>();
	
	static{
		productTypes.put("JDBC", JdbcDAO.class);
		productTypes.put("XML", XmlDAO.class);
		
	}
	
	public static DAO<Identity> getDao(IDAOTypes type, Map<String, String> properties) {

		Class<? extends DAO> selectedClass = productTypes.get(type.getDAOName());
		if (selectedClass == null){
			return null;
		}try{
			return selectedClass.newInstance();	
		}catch(Exception e){
			
		}
		return null;
		
		
		
		
		
		

	}

}
