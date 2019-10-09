package north.lesson7;

import java.sql.*;
import java.math.*;
import java.security.*;


public class PasswordValidation {

	private Connection conn = null;
	
	public PasswordValidation() { }
	
	private PasswordValidation(boolean islocal) {
		try {
			 System.out.println("... CONSTRUCTOR ...");
			String username = "leopold";
			String password = "stotch";
			openConnection();
			//removeAllEntries();
			createUserEntry(username, password);
			deleteSpecificUser(username);
			userLogin(username, password);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception ex) {}
		}
	}
	
	

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
		 System.out.println("Record deleted successfully");
		 
		
	}
	
	
	public boolean validateName(String uname) throws Exception {
		System.out.println("... Validate Name ...");
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + uname + "'");
	boolean exists = false;
	
	
	if(rs.next()) {
		
		System.out.println("User already exists");
		exists = true;
		}
	return exists;
	
	
	}
	
	
	public void deleteSpecificUser(String uname) throws Exception{
		System.out.println("... Delete Specific User ...");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + uname + "'");
		
		if(rs.next()) {
		
		stmt.executeUpdate("delete from login where username = '" + uname + "'");
		System.out.println("User deleted from login");
		
		}else System.out.println("User does not exists");
		
		
	}
	
	/**
	 * insert a new record into the database
	 * @param uname	Username 
	 * @param pword Password, should be converted to MD5 value BEFORE insert
	 * @throws Exception
	 */
	public void createUserEntry(String uname, String pword) throws Exception{
		 System.out.println("... CREATE USER ...");
		 
		if(!validateName(uname)) {
			
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("insert into login(username, password) values('" + uname + "', '" + generateMD5(pword) + "')");
		
		}
		
		
		
	}
	
	/**
	 * Fetch the user using the converted password as an MD5
	 * @param uname Username
	 * @param pword Password, should be converted to MD5 value BEFORE select
	 * @throws Exception
	 */
	public void userLogin(String uname, String pword) throws Exception{
		 System.out.println("... USER LOGIN ...");
		 

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + uname + "' and password ='" + generateMD5(pword) + "'");
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
	 public String generateMD5(String pword) throws Exception{
		 System.out.println("... GENERATE MD5 ...");
		 String hashtext = null;
		 MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pword.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		 return hashtext;
	 }
	
	
	public static void main(String[] args) {
		new PasswordValidation(true);

	}

}
