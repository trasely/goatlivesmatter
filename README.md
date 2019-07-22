# goatlivesmatter
Goat Lives Matter: a DevOps Training Repository

## Accounts
* [GitHub](http://github.com)	
* [gmail](http://gmail.com)	
* [dockerhub](https://hub.docker.com/)	
* [slack](https://slack.com/)	

## Required Software
* [git](https://git-scm.com/downloads)
* [putty](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html)
* [puttygen](https://www.puttygen.com/)
* [notepad++](https://notepad-plus-plus.org/)
* [eclipse](https://www.eclipse.org/downloads/packages/)
* [openjdk](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* [virtualbox](https://www.virtualbox.org/wiki/Downloads)
* [maven](https://maven.apache.org/download.cgi?Preferred=ftp://mirror.reverse.net/pub/apache/)


## Setting up your build environment
### Build Environment 
* After all of the software is installed, take note where you put the jdk and maven
* tap the windows key, search for system 
	* Select 'Advanced System Settings'
	* Select 'Environment Variables'
	* Select 'New ...'
		* Variable name: JAVA_HOME
		* Variable value: <root directory to the JDK>
	* Select 'New ...'
		* Variable name: M2_HOME
		* Variable value: <root directory to maven>
* If the command mvn does not work from the command prompt, you will need to add it to your path
	* following the steps above
	* Select the system variable 'PATH' and add the following
		* Variable value: %M2_HOME%/bin:


### Create an SSH Key
* from the command prompt execute: ```mkdir %USERPROFILE%\.ssh```
* Open puttygen
* Click 'generate' and move your mouse until the key is generated
* add 'goatlivesmatter' to the second field, 'Key Comment'
* In the box where the key is visible, and starting with ssh-rsa, select all and copy 
	* Save it to: C:\Users\<your-user-name>\.ssh\goatlivesmatter.pub
* From the top menus, select 'Conversion' then 'Export OpenSSH key'
	* Save it without an extention to: C:\Users\<your-user-name>\.ssh\goatlivesmatter

### Edit/Create ssh config
* add the following to an empty file  
```
Host github.com
 Hostname github.com
 IdentityFile C:\Users\<your-user-name>\.ssh\<name-of-your-private-ssh-private-key>
```
* save the file as: C:\Users\<your-user-name>\.ssh\config  
_hint: make sure the file does not have any extension on it, some editors will try to append .txt when saving a file with no extension_  

### Add ssh key to github 
* In the top right of your github account, after you have logged in, will be a tiny dropdown arrow. Mouse of it and select 'settings'
* On the right, select 'SSH and GPG keys' 
* On the left, select 'New SSH Key'
* Go back to Notepad++ and open C:\Users\<your-user-name>\.ssh\goatlivesmatter.pub
	* it should look like this ... 
```
ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAQEAsn21hVxsewJ0bXwHLatOqCX/gXJBczz6Hob3W7kbM8YzSm4dQT4RjE9etnYelBGWB3+ZafkkhbE1wjN3ZuXcyZEtbqoIsKw+80mU0XpC9sjSiBYfrmwed4HRbWKSBZBeYmKzvPEA0APeGvSynka1cgWXJ8COmRVYIoU8IieF8+FpWKHoVcpFr4y7YsM7YOnJqE4IQ/fDVUvk/VgFzr0PGeS+ibFONH1DkDAf/xi/JZvRtC4mRk/N87LxCSv+jKv+5uey0MNtrf3hw3k/0GFZJEAOoA+F/I1zPNF1meHFfmat80EdqXcoNl30JxHF2qmOM+MCbD6XWnIoxoNDQyzqWw== rsa-key-20190722
```
* select all, copy
* Back to Github and adding a new SSH key
* Title: goatlivesmatter
* Key: <paste> 
* Save

### Create a test project and test your SSH key
* go back to github and login
* at the top left, click the + sign and create a new project, name it whatever you want.
* middle of the screen, right side, big green button 'clone or download', click to open the dialog
	* make sure to select 'SSH', it should looke like this ```git@github.com:<yourid>/mydemoproject.git```, copy it
* go to the command prompt, to your working development directory (whatever that is) and clone the repo: ```git clone git@github.com:<yourid>/mydemoproject.git```
* if it fails to check out, you will need to check your config settings and make sure it is pointing to the proper ssh key 
* if you do not have a README.md file, create it and edit it with 'hello world'
* Not test your push capabilities
```
git add .
git commit -m "testing push ability"
git push origin master
```
* the changes should push back up to github 
* check that the changes completed by refreshing your main repo page


### Now we're ready to start slinging code ... 


## Lession 1:  
[Write Lesson 2](lesson1/README.md)

## Lession 2:  
[Installing Tomcat](lesson2/README.md)

## Lesson 3: 
[Hello world Web-App](lesson3/README.md)

## Lesson 4: <TBD>







