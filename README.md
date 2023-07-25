# Practica@IBM Spital project


## HOW TO ACCESS SWAGGER INTERFACE
To access swagger UI, please use the following URL when running the project on the local machine: http://localhost:8080/swagger-ui/index.html

## How to clone GIT Repo

I've made a short GIF highlighting the steps needed to clone the repo.
Once the cloning steps are done, you can open the project in Intellij.

Steps are:
- Click on the "Code" button
  
- Copy the HTTPS link

- On your PC, go to the desired location and right click -> Show more options -> Git Bash Here
  
- In the command line that opens enter the following command: `$ git clone <Shift + Insert to paste the URL copied on stape 2> `

![clone](https://github.com/bogdanmaceasa/practica.ibm.spital/assets/74003240/64ea9c78-a0de-4bb4-a42d-448eaef0838d)




## How to link local repo to Github
- Open Fork and click on File -> Open Repository...

- Select the folder from where you cloned it / downloaded it previously

### Fetch & Pull the latest changes from GitHub

- Make sure that you perform a **Fetch** before **Pull**, otherwise the newest changes will not be pulled.

- Make sure you select the <font color="lightblue">Stash and reapply local changes</font> before clicking the **Pull** button.

![addingtoFork](https://github.com/bogdanmaceasa/practica.ibm.spital/assets/74003240/9dc3bba7-63b3-40d1-ba43-57b407f8d58c)


## How to Install PostgreSQL Server

- Download the postgreSQL Server kit from https://www.postgresql.org/download/
- Follow the install wizzard, **make sure you note down the password** this will be used to connect to the server, without it you will not be able to connect to it.
- Other configuration options can be left unchanged ( i.e the **port** - leave it to the default 5432 )
- After the installation is completed, you can skip launching the *Stack Builder* utilitary, so simply uncheck it and click Finish.

![postgresql_server_instal](https://user-images.githubusercontent.com/74003240/182189694-8f90a2d6-107a-4e80-a99a-399147437524.gif)



## How to create a SQL Database

- Search and open pgAdmin
- When it starts, you will be asked for the password - enter the password you set during the installation process
- The same will be asked when double-clicking on the PostgreSQL 14 server
- Left-click on the Databases and Create - Database
- Enter the desired name, leave everything else unchanged
- All done!

![pgAdmin](https://user-images.githubusercontent.com/74003240/182189707-e2de389a-aba6-4d57-a3c2-baa7fba1768b.gif)


