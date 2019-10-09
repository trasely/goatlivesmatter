package north.lesson7;

import java.sql.*;
import java.math.*;
import java.security.*;


public class PasswordValidation {

	private Connection conn = null;
	
	public PasswordValidation() { }
	

	/**
	 * Open a connection to the database and assign the 'conn' object to the open connection
	 * @throws Exception
	 * 
	 * 
	 * #done
	 */
	public void openConnection() throws Exception{
		 System.out.println("... OPEN CONNECTION ...");
		 
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/glm","timmy","thegoat");
		
	}
	
	
	/**
	 * delete from users (or whatever the user login table is called)
	 * @throws Exception
	 */
	public void removeAllEntries() throws Exception{
		 System.out.println("... REMOVE ALL ENTRIES ...");
		 Statement stmt = conn.createStatement();
		 
		 stmt.executeUpdate("delete from login");
		 System.out.println("Records deleted successfully");
		 
		
	}
	
	
	public boolean validateName(UserLogin ul) throws Exception {
		System.out.println("... Validate Name ...");
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername() + "'");
	boolean exists = false;
	
	
	if(rs.next()) {
		
		System.out.println("User already exists");
		exists = true;
		}
	return exists;
	
	
	}
	
	
	public void deleteSpecificUser(UserLogin ul) throws Exception{
		System.out.println("... Delete Specific User ...");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername() + "'");
		
		if(rs.next()) {
		
		stmt.executeUpdate("delete from login where username = '" + ul.getUsername() + "'");
		System.out.println("User deleted from login");
		
		}else System.out.println("User does not exist");
		
		
	}
	
	/**
	 * insert a new record into the database
	 * @param uname	Username 
	 * @param pword Password, should be converted to MD5 value BEFORE insert
	 * @throws Exception
	 */
	public void createUserEntry(UserLogin ul) throws Exception{
		 System.out.println("... CREATE USER ...");
		 
		if(!validateName(ul)) {
			
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("insert into login(username, password) values('" + ul.getUsername() + "', '" + generateMD5(ul) + "')");
		
		}
		
		
		
	}
	
	/**
	 * Fetch the user using the converted password as an MD5
	 * @param uname Username
	 * @param pword Password, should be converted to MD5 value BEFORE select
	 * @throws Exception
	 */
	public void userLogin(UserLogin ul) throws Exception{
		 System.out.println("... USER LOGIN ...");
		 System.out.println("... USER LOGIN ...");
		 

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername() + "' and password ='" + generateMD5(ul) + "'");
			if(rs.next()) {
				System.out.println("userid [" + rs.getString("userid") + "]");
				
			}else  System.out.println("NO RECORD FOUND");
			
		
	}
	
	/**
	 * convert the password to an MD5 value and return it 
	 * @param pword
	 * @return
	 * @throws Exception
	 */
	 public String generateMD5(UserLogin ul) throws Exception{
		 System.out.println("... GENERATE MD5 ...");
		 String hashtext = null;
		 MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(ul.getPassword().getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		 return hashtext;
	 }

}
