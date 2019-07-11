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

### Add ssh key to github 
* In the top right of your github account, after you have logged in, will be a tiny dropdown arrow. Mouse of it and select 'settings'
* On the right, select 'SSH and GPG keys' 
* On the left, select 'New SSH Key'
* Go back to Notepad++ and open C:\Users\<your-user-name>\.ssh\goatlivesmatter.pub
* This gets a little tricky, so you might want to make a backup of your pub key (you can always regenerate it)
	* it should look like this ... 
```
---- BEGIN SSH2 PUBLIC KEY ----
Comment: "goatlivesmatter-public"
ZU5xuvjTcwPe0P4Vb1f3pe2eydwAKhoChjz15RjUeSaDsnimJFZPsHQfkMZPn2Zk
EmI/DrJHbiLV4BR9bN3QlnG1iExlr1YuMHdmEU0MX+HkRgEvoPIKF5wnEr2IqqPy
tAyP3cq7ThXBEW8Il+UudR0aAcULI0133Fv0oaOYkYcb8ECf7Eza7ea5Gmjffaw1
2m0thBpdfzRG40+3wnxCC9f/MAwEWZ77NminIpFgj6lcmwJwtOCxpyZWacy39Lwl
yi7fRxHCm8ilGmIxIlrCGaM62ELVSh+4dNYmoJhG21dphzybtm+CedgftPYjWZ77
vANLqe56gq83mfkrFjyYDFhwPJ+um0szak5E/p/Q04a2ZwLKqQ==
---- END SSH2 PUBLIC KEY ----	
```
	* you move the comment, the part in quotes after the equal sign and putting a space after the ==
	* remote the comment line, remote both --- lines and make the file a single string so it looks like this
```
ZU5xuvjTcwPe0P4Vb1f3pe2eydwAKhoChjz15RjUeSaDsnimJFZPsHQfkMZPn2ZkEmI/DrJHbiLV4BR9bN3QlnG1iExlr1YuMHdmEU0MX+HkRgEvoPIKF5wnEr2IqqPytAyP3cq7ThXBEW8Il+UudR0aAcULI0133Fv0oaOYkYcb8ECf7Eza7ea5Gmjffaw12m0thBpdfzRG40+3wnxCC9f/MAwEWZ77NminIpFgj6lcmwJwtOCxpyZWacy39Lwlyi7fRxHCm8ilGmIxIlrCGaM62ELVSh+4dNYmoJhG21dphzybtm+CedgftPYjWZ77vANLqe56gq83mfkrFjyYDFhwPJ+um0szak5E/p/Q04a2ZwLKqQ== goatlivesmatter-public
```
	* select all, copy and save
* Back to Github and adding a new SSH key
* Title: goatlivesmatter
* Key: <paste> 
* Save
* as noted, this is a little tricky so that might tell you something is wrong, just hack on it until it works (cheesy instructions, but this is one of those things you have do for youself) 

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









