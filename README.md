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
* Click 'Save Public Key'
	* Save it to: C:\Users\<your-user-name>\.ssh\goatlivesmatter.pub
* Click 'Save Private Key'
	* Save it to: C:\Users\<your-user-name>\.ssh\goatlivesmatter

### Edit/Create ssh config
* add the following to an empty file  
```
Host github.com
 Hostname github.com
 IdentityFile C:\Users\<your-user-name>\.ssh\<name-of-your-private-ssh-private-key>
```
* save the file as: C:\Users\<your-user-name>\.ssh\config  
_hint: make sure the file does not have any extension on it, some editors will try to append .txt when saving a file with no extension_  

### Step 3: Add ssh key to github 
_coming soon_
