package fr.tbr.iamcore.tests.identity.xml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.services.dao.impl.IdentityXMLDAO;

public class IdentitiesXMLTest {

	@BeforeClass
	public static void beforeExecution() {

	}

	@Before
	public void beforeEachTest() {

	}

	@Test
	public void xmlDAO() {

		// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// DocumentBuilder db = dbf.newDocumentBuilder();
		// Document doc = db.newDocument();
		//
		// Element identities = doc.createElement("identities");
		// doc.appendChild(identities);
		//
		// Element identity = doc.createElement("identity");
		// identity.setAttribute("name", "thomas");
		//
		// identities.appendChild(identity);

		Identity identity = new Identity("Thomas", "Broussard",
				"thomas.broussard@tbr.com");
		IdentityXMLDAO dao = new IdentityXMLDAO();
		dao.write(identity);

		Assert.fail();
	}
	@Test 
	public void xmlDAO2(){
		
	}
	@After
	public void afterEachTest() {

	}

	@AfterClass
	public static void afterExecution() {

	}

}
