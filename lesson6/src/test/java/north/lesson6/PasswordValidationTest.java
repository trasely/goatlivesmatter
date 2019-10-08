package north.lesson6;

import org.omg.PortableInterceptor.SUCCESSFUL;
import junit.framework.TestCase;

public class PasswordValidationTest extends TestCase {
	PasswordValidation validation = null;
	

	public void testPasswordValidation() {
		Exception exassert = null;
		System.out.println("_______TESTPASSWORDVALIDATION_______");
		try {			
			System.out.println("--instantiating PasswordValidation Class--");
			validation = new PasswordValidation();
			validation.openConnection();
			validation.createUserEntry("timmy","thegoat");
			validation.createUserEntry("burger","king");
			validation.deleteSpecificUser("burger");
		}catch(Exception ex) {
			exassert = ex;
			ex.printStackTrace();
			
		}
		assertNull(exassert);
	}
}
