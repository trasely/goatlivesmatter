package north.lesson7;

import junit.framework.TestCase;

public class TestUserManager extends TestCase {
	
	public void testOpenConnection() {
		try {
			PasswordValidation validator = new PasswordValidation();
			validator.openConnection();
			UserLogin login = new UserLogin();
			validator.createUserEntry(login);
			assertEquals(login.isResult(), false);
			assertEquals(login.getMessage(), "User Exist");
		}catch(Exception ex) {
			fail(ex.getMessage());
		}
	}

//	public void testValidateName() {
//		fail("Not yet implemented");
//	}

//	public void testCreateUserEntry() {
//		fail("Not yet implemented");
//	}

	public void testUserLogin() {
		try {
			PasswordValidation validator = new PasswordValidation();
			validator.openConnection();
			UserLogin login = new UserLogin();
//			validator.createUserEntry(login);
			login = validator.userLogin(login);
			assertTrue(login.getUserid() > 0 );
		}catch(Exception ex) {
			fail(ex.getMessage());
		}
	}

}
