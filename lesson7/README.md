# LESSON 7

## Value Objects

Take Lesson6 and create a value object for user management  
The name of the value object should be `UserLogin`  
UserLogin should have the following private objects  
* useir     int
* username  String
* password  String
* result	boolean
* message	String

Each object should have a getter and setter and you should also override the "toString" method


Create a new class "UserManager"  
This class should create an instance of 'PasswordValidation'  

Edit PasswordValidation to accept only the UserLogin value object and return the same object with the result and message when applicable 



