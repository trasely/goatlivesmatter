package north.lesson7;

public class UserManager {

	public UserManager() {
		// TODO Auto-generated constructor stub
		try {
			System.out.println("UserManager");
			UserLogin ul = new UserLogin();
			System.out.println(ul);
			System.out.println("PasswordValidation");
			PasswordValidation pv = new PasswordValidation();
			System.out.println(pv);
			
			ul.setUsername("tht Basiui");
			ul.setPassword("asdfasdfsa");
			
		pv.openConnection();
		//pv.deleteSpecificUser(ul);
		pv.createUserEntry(ul);
		pv.validate(ul);
		pv.userStats(ul);
		
		
		
		pv.userLogin(ul);
		
		
		//pv.removeAllEntries();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserManager(); 
		
	}
	

}

