package fr.tbr.iamcore.services.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.IdentityDAOInterface;

public class IdentityJDBCDAO implements IdentityDAOInterface {
	
	private String driverClassName;
	private String url;
	private String user;
	private String password;
	
	/**
	 * @return the driverClassName
	 */
	public final String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * @param driverClassName the driverClassName to set
	 */
	public final void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	/**
	 * @return the url
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public final void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public final String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	public IdentityJDBCDAO() {

	}

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// 1-Set up the driver
		Class.forName(this.driverClassName);

		// 2-Prepare the connection
		String url = this.url;

		// 3-connect
		Connection connection = DriverManager.getConnection(url, this.user, this.password);
		return connection;
	}

	private static void releaseConnection(Connection connection)
			throws SQLException {
		connection.close(); // TODO maybe manage a pool to optimize performance
	}

	@Override
	public List<Identity> search(Identity identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Identity identity) {
		try {
			Connection connection = getConnection();
			String query = "INSERT INTO IDENTITIES"
					+ " (IDENTITIES_FIRSTNAME, IDENTITIES_LASTNAME, IDENTITIES_EMAIL ,IDENTITIES_BIRTHDATE)"
					+ " VALUES (?, ?, ?, ?)";

			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, identity.getFirstName());
			pstmt.setString(2, identity.getLastName());
			pstmt.setString(3, identity.getEmail());
			Date date = new Date(identity.getBirthDate().getTime());
			pstmt.setDate(4, date);
			pstmt.execute();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Identity identity) {
		// Example update "TOM"."IDENTITIES" set
		// "IDENTITIES_FIRSTNAME"='Clement' where "IDENTITIES_ID"=4 and
		// "IDENTITIES_FIRSTNAME"='Clément' and "IDENTITIES_LASTNAME"='Serrano'
		// and "IDENTITIES_EMAIL"='cse@cse.com' and
		// "IDENTITIES_BIRTHDATE"='2014-12-18'

		// First: the query (use the datasource explorer to tweak your query)
		// TODO maybe externalize the queries in a dedicated file
		String updateQuery = "update IDENTITIES set IDENTITIES_FIRSTNAME= ? , "
				+ "IDENTITIES_LASTNAME= ?, " + "IDENTITIES_EMAIL= ?, "
				+ "IDENTITIES_BIRTHDATE= ? " + "WHERE IDENTITIES_ID = ?";
		try {
			// Second : get a connection
			Connection connection = getConnection();
			// Get a prepared statement from the query String
			PreparedStatement stmt = connection.prepareStatement(updateQuery);

			// Initialize parameters
			stmt.setString(1, identity.getFirstName());
			stmt.setString(2, identity.getLastName());
			stmt.setString(3, identity.getEmail());
			Date date = new Date(identity.getBirthDate().getTime());
			// Convert from java.util.Date to java.sql.Date
			stmt.setDate(4, date); // parameters are typed, you have to indicate
									// the index and call the typed method.
			stmt.setInt(5, identity.getId());
			// Perform the update
			stmt.executeUpdate();
			// commit : flush the pending operations "cache" in the database
			connection.commit();
			// don't forget to release the connection
			releaseConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Identity identity) {
		// TODO Auto-generated method stub

	}

	public List<Identity> readAll() {
		List<Identity> identities = new ArrayList<Identity>();
		try {
			Connection connection = getConnection();
			String query = "SELECT * from IDENTITIES";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.execute();
			ResultSet results = pstmt.getResultSet();
			while (results.next()) {
				String firstName = results.getString("IDENTITIES_FIRSTNAME");
				String lastName = results.getString("IDENTITIES_LASTNAME");
				String email = results.getString("IDENTITIES_EMAIL");
				Date birthDate = results.getDate("IDENTITIES_BIRTHDATE");
				Identity id = new Identity(firstName, lastName, email);
				id.setBirthDate(birthDate);
				id.setId(results.getInt("IDENTITIES_ID"));
				identities.add(id);
			}
			releaseConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return identities;
	}

}
