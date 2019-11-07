package north.lesson7;

import junit.framework.TestCase;

public class TestUserLoginObject extends TestCase {
	UserLogin user = new UserLogin();
	
	public void testGetUserid() {
		assertEquals(user.getUserid(),-1);
	}

	public void testGetUsername() {
		assertEquals(user.getUsername(),"");
	}

	public void testGetPassword() {
		assertEquals(user.getPassword(),"");
	}

	public void testIsResult() {
		assertEquals(user.isResult(),false);
	}

	public void testGetMessage() {
		assertEquals(user.getMessage(),"");
	}

}
