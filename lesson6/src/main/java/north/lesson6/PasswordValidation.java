package north.lesson6;

import java.sql.*;

public class PasswordValidation {

	private Connection conn = null;
	
	public PasswordValidation() {
		try {
			 System.out.println("... CONSTRUCTOR ...");
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception ex) {}
		}
	}

	/**
	 * Open a connection to the database and assign the 'conn' object to the open connection
	 * @throws Exception
	 */
	public void openConnection() throws Exception{
		 System.out.println("... OPEN CONNECTION ...");
		
	}
	
	
	/**
	 * delete from users (or whatever the user login table is called)
	 * @throws Exception
	 */
	public void remoteAllEntries() throws Exception{
		 System.out.println("... REMOVE ALL ENTRIES ...");
		
	}
	
	/**
	 * insert a new record into the database
	 * @param uname	Username 
	 * @param pword Password, should be converted to MD5 value BEFORE insert
	 * @throws Exception
	 */
	public void createUserEntry(String uname, String pword) throws Exception{
		 System.out.println("... CREATE USER ...");
		
	}
	
	/**
	 * Fetch the user using the converted password as an MD5
	 * @param uname Username
	 * @param pword Password, should be converted to MD5 value BEFORE select
	 * @throws Exception
	 */
	public void userLogin(String uname, String pword) throws Exception{
		 System.out.println("... USER LOGIN ...");
		
	}
	
	/**
	 * convert the password to an MD5 value and return it 
	 * @param pword
	 * @return
	 * @throws Exception
	 */
	 public String generateMD5(String pword) throws Exception{
		 System.out.println("... GENERATE MD5 ...");
		 String md5 = null;
		 
		 return md5;
	 }
	
	
	public static void main(String[] args) {
		new PasswordValidation();

	}

}
