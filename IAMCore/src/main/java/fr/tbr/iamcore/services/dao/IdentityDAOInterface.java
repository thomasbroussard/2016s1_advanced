package fr.tbr.iamcore.services.dao;

import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;

public interface IdentityDAOInterface {

	public List<Identity> readAll();

	public List<Identity> search(Identity identity);
	
	public void write(Identity identity);
	
	public void update(Identity identity);
	
	public void delete(Identity identity);

}
