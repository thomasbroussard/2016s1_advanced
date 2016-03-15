package fr.tbr.designpatterns.factory.launchers;

import fr.tbr.designpatterns.factory.datamodel.Identity;
import fr.tbr.designpatterns.factory.services.DAO;
import fr.tbr.designpatterns.factory.services.DAOTypes;
import fr.tbr.designpatterns.factory.services.IdentityDAOFactory;

public class Main {

	


	public static void main(String[] args) {
		DAO<Identity> dao = IdentityDAOFactory.getDao(DAOTypes.JDBC, null);
		
	
		
	}
}
