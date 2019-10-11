package north.lesson7;

import java.sql.*;
import java.math.*;
import java.security.*;

public class PasswordValidation {

	private Connection conn = null;

	public PasswordValidation() {
	}

	/**
	 * Open a connection to the database and assign the 'conn' object to the open
	 * connection
	 * 
	 * @throws Exception
	 * 
	 * 
	 *                   #done
	 */
	public void openConnection() throws Exception {
		System.out.println("... OPEN CONNECTION ...");

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/glm", "timmy", "thegoat");

	}

	/**
	 * delete from users (or whatever the user login table is called)
	 * 
	 * @throws Exception
	 */
	public void removeAllEntries() throws Exception {
		System.out.println("... REMOVE ALL ENTRIES ...");
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("delete from login");
		System.out.println("Records deleted successfully");

	}

	public UserLogin validate(UserLogin ul) throws Exception {
		if (ul.getUsername().trim().length() < 8) {
			System.out.println("Invalid User Length");
			ul.setResult(false);
			ul.setMessage("Ivalid user length");
			return ul;

		}

		if (ul.getPassword().trim().length() < 8) {
			System.out.println("Invalid Password Length");
			ul.setResult(false);
			ul.setMessage("Ivalid Password Length");
			return ul;
		}
		ul.setResult(true);
		return ul;
	}

	public boolean validateName(UserLogin ul) throws Exception {

		// check for 0 length String -- and check for no white spaces
		// google string compare & google trim for strings
		// get string length and make sure it is > 8 (ie: our user rules would be your
		// username needs to be more than, or equal to, 8 characters)
		// do the string length check for password as well

		System.out.println("... Validate Name ...");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername() + "'");
		boolean exists = false;
		// String str = "";

		if (rs.next()) {

			System.out.println("User already exists");
			exists = true;
			ul.setUsername(rs.getString("username"));
			System.out.println(ul.getUsername().trim());

		}
		return exists;

	}

	/*
	 * Statement stmt = conn.createStatement(); ResultSet rs =
	 * stmt.executeQuery("SELECT userid FROM login WHERE username = '" +
	 * ul.getUsername() + "' and password ='" + generateMD5(ul) + "'");
	 * if(rs.next()) { System.out.println("userid [" + rs.getString("userid") +
	 * "]"); ul.setUserid(rs.getInt("userid")); ul.setResult(true);
	 * ul.setMessage("User Added"); }else { System.out.println("NO RECORD FOUND");
	 * ul.setResult(false); ul.setMessage("User Not Found"); }
	 * 
	 * 
	 * 
	 */

	public void deleteSpecificUser(UserLogin ul) throws Exception {
		System.out.println("... Delete Specific User ...");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername() + "'");

		if (rs.next()) {

			stmt.executeUpdate("delete from login where username = '" + ul.getUsername() + "'");
			System.out.println("User deleted from login");

		} else
			System.out.println("User does not exist");

	}

	/**
	 * insert a new record into the database
	 * 
	 * @param uname Username
	 * @param pword Password, should be converted to MD5 value BEFORE insert
	 * @throws Exception
	 */
	public void createUserEntry(UserLogin ul) throws Exception {
		System.out.println("... CREATE USER ...");
		if (!validateName(ul)) {

			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into login(username, password) values('" + ul.getUsername() + "', '"
					+ generateMD5(ul) + "')");

		}

	}

	/**
	 * Fetch the user using the converted password as an MD5
	 * 
	 * @param uname Username
	 * @param pword Password, should be converted to MD5 value BEFORE select
	 * @return
	 * @throws Exception
	 */
	public UserLogin userLogin(UserLogin ul) throws Exception {
		System.out.println("... USER LOGIN ...");
		System.out.println("... USER LOGIN ...");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM login WHERE username = '" + ul.getUsername()
				+ "' and password ='" + generateMD5(ul) + "'");
		if (rs.next()) {
			System.out.println("userid [" + rs.getString("userid") + "]");
			ul.setUserid(rs.getInt("userid"));
			ul.setResult(true);
			ul.setMessage("User Added");
		} else {
			System.out.println("NO RECORD FOUND");
			ul.setResult(false);
			ul.setMessage("User Not Found");
		}

		return ul;

	}

	/**
	 * convert the password to an MD5 value and return it
	 * 
	 * @param pword
	 * @return
	 * @throws Exception
	 */
	public String generateMD5(UserLogin ul) throws Exception {
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
