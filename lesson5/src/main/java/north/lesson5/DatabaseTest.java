package north.lesson5;


import java.sql.*;  
class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/glm","root","Qx2GwyL767;()");
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from login");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  



}catch(Exception e){ System.out.println(e);}  
}  
} 
public class DatabaseTest 
{
	
	public void openConnection() throws Exception{
		System.out.println("openConnection");
		
		
		
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
 	}
	

	public static void main(String[] args) 
	{
		new DatabaseTest();
		

	}
	
	

}

