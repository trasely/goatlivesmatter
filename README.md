# goatlivesmatter
Goat Lives Matter: a DevOps Training Repository


## Setting up your build environment


### Step 1: Create an SSH Key
Google and find out how by using puttygen https://www.puttygen.com/

### Step 2: edit ssh config

```
create a directory .ssh under %USERPROFILE%

mkdir %USERPROFILE%\.ssh

put your ssh key here (read on google how to create this)

create a file named: config

put it under %USERPROFILE%\.ssh\ 

add this to it:

Host github.com
 Hostname github.com
 IdentityFile C:\Users\<your-user-name>\.ssh\<name-of-your-private-ssh-key>

```

### Step 3: Add ssh key to github 
_coming soon_
