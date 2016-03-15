/**
 * 
 */
package fr.tbr.designpatterns.factory.services;

/**
 * @author tbrou
 *
 */
public enum DAOTypes implements IDAOTypes {
	
	JDBC,
	XML,;

	@Override
	public String getDAOName() {
	
		return this.toString();
	}

}
