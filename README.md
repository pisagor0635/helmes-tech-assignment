# helmes-tech-assignment


You can use mysql as a container :

docker container run --name mysql --detach --publish 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 mysql

You can connect to database as : 

docker container exec -it mysql mysql -u root -p -h 127.0.0.1

the password is 1234.

Then you create the database :

create database helmes;

Then you can run the the project. The tables will be created. Then, you have to import the sector datas to sectors table.
