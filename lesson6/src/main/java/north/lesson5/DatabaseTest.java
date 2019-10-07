package north.lesson5;


import java.sql.*;  






public class DatabaseTest 
{
	public Connection conn = null;
	public void openConnection() throws Exception{
		System.out.println("openConnection");
		
		Class.forName("com.mysql.jdbc.Driver");  
		conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/glm","timmy","thegoat");
		
		
		
	}
	public DatabaseTest(){
		
 		try{
 			
 		System.out.println("DatabaseTest");
 		
 		openConnection();
 		login();
 		
 		}catch(Exception ex){
 			ex.printStackTrace();
 		}finally{
 			closeConnection();
 		}
 	}
 	
 	public void closeConnection(){
 		System.out.println("closeConnection");
 		try{
 			//conn.close();
 		}catch(Exception ex){
 			ex.printStackTrace();
 		}
 	}	
 	
 	public void login() throws Exception{
 		System.out.println("login");
 		Statement stmt=conn.createStatement();  
		//ResultSet rs=stmt.executeQuery("select * from login");
		ResultSet rs=stmt.executeQuery("select userid from login where username = 'terry' and password = 'thecow'");
		while(rs.next())  
		//System.out.println(rs.getString("Username")+"  "+rs.getString("Password"));  
		System.out.println("UserID; " + rs.getInt("UserID"));
 	}
	

	public static void main(String[] args) 
	{
		new DatabaseTest();
		

	}
	
	
	

}

