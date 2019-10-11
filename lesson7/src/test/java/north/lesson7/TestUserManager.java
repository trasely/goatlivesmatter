package north.lesson7;

import junit.framework.TestCase;

public class TestUserManager extends TestCase {

	public void testOpenConnection() {
		try {
			PasswordValidation validator = new PasswordValidation();
			validator.openConnection();
			UserLogin login = new UserLogin();
			login.setUsername(null);
			validator.createUserEntry(login);
			assertEquals(login.isResult(), false);
//			assertEquals(login.getMessage(), "");
		}catch(Exception ex) {
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}

//	public void testValidateName() {
//		fail("Not yet implemented");
//	}

//	public void testCreateUserEntry() {
//		fail("Not yet implemented");
//	}

	public void testWhiteSpace() {
		try {
			PasswordValidation validator = new PasswordValidation();
			validator.openConnection();
			UserLogin login = new UserLogin();
			login.setUsername("        ");
			//validator.createUserEntry(login);
			login = validator.userLogin(login);
			assertTrue(login.getUserid() > 0 );
			
			/*
			in our jsp ... we would have
			UserLogin = userManger.addUser();
			<somestring> = ul.getMessage();
			
			
			
			
			*/
		}catch(Exception ex) {
			fail(ex.getMessage());
		}
	}

	
	
	public void testUserLogin() {
		try {
			PasswordValidation validator = new PasswordValidation();
			validator.openConnection();
			UserLogin login = new UserLogin();
			//validator.createUserEntry(login);
			login = validator.userLogin(login);
			assertTrue(login.getUserid() > 0 );
			
			/*
			in our jsp ... we would have
			UserLogin = userManger.addUser();
			<somestring> = ul.getMessage();
			
			
			
			
			*/
		}catch(Exception ex) {
			fail(ex.getMessage());
		}
	}

}
