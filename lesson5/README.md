# LESSON 5

* Install MySQL Community Edition (not the 'pay for' vesion, it's actually called 'mysql community')
* Read how to add the mysql driver
* start MySQL 
	* AS 'the DBA' (default admin user)
	* Connect to mysql using the MySQL Desktop ( I actually don't know what it's called) 
		* Pro-Tip: I think it's called 'mysql workbench' and you can install it when you install the server
	* Once connected, create a database named 'glm' (goatlivesmatter)
	* create a user named timmy with a password of thegoat and grant full control on the glm database, grant access to any location
	* log out
	* log back in as timmy/thegoat and attach to the glm database
	* AS 'timmy' ... 
	* create a table named login with the following columns
		* username varchar(16) not null
		* password varchar(16) not null
		* userid integer [look up how to make this an auto-increment]
		* last_login timestamp not null 
* Create a maven project in eclipse (create default app, not web app)
	* Create a file called 'DatabaseTest.java'
	* make sure it has a main function
	* Instantiate the following public objects:  
		* Connection conn = null;
	* create the following functions
	```
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
	```
	* you want main to call DatabaseTest constructor
	* connect to the database in a seperate function
	* attemp to login (there are no records - so this should fail)
	* once we get here -- we'll do Lesson6
