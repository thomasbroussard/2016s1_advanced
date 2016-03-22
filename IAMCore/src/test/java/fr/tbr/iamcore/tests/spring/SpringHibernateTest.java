package fr.tbr.iamcore.tests.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class) //This is to tell Junit to run with spring
@ContextConfiguration(locations={"application-context.xml"}) // to tell spring to load the required context
public class SpringHibernateTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void springSetup(){
		Assert.notNull(ds);
	}

	@Test
	public void dataSourceUsage() throws SQLException{
		Connection connection = ds.getConnection();
		System.out.println(connection.getSchema());
		connection.close();
		
	}
}
