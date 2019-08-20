# Lesson 3: Hello world Web-App

FIRST: rename your current folder goatlivesmatter to goatlivesmatter-lesson2  
SECOND: clone this repo again ```cd c:\dev\projects```  and clone it ```git clone git@github.com:ssgeejr/goatlivesmatter.git```  
Create a new branch named:  lesson3  
_You may have to read up on how to create a new branch, you're on own here_  

Follow the next lesson.  If it seems vague, google and research how to do this. You can't always depend on consice clear directions (I will always try to give them, but imprection is my game) 
  

Below the dotten line, comment your work (just like math, show your work)  

*Open eclipse
  * Select File/New/Other 
  * Maven > Maven Project [Next] [Next] 
  * Select [maven-archetype-webapp] [Next]
  * GroupID: goatlivesmatter ArtifactID: helloworld [Next]  
* After the project loads, right click on the pom.xml file and selct [Run As]
* [Maven build ...]
* goals: clean package
* [Apply] [Run]
* Copy the new War file your tomcat home (CATALINA_HOME) under the directory webapps
* Start/Restart tomcat
* Navigate to http://localhost:8080/helloworld/

Once you get this far -- don't commit yet -- let me know and we I will explain to you how to get this into the goatlivesmatter project  

.......................................................  

