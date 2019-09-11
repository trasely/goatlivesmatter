mvn run-app com.example.MainClass

public connection conn = null;

public DatabaseTest{
		try{
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
	}
	
	public void closeConnection(){
		try{
			conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
	}	
	
	public void login(){
		try{
			//TO-DO 
			//You need to do the login 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
	}	