# plexteq

Project provie 3 endpoinds for:

- backup users and thier todo
- show list of backups
- export backup to *.csv file

for start the project from command line just type "java -jar {path to file backup-service-1.0-SNAPSHOT.jar}" path in project "/target/backup-service-1.0-SNAPSHOT.jar"

- backup users and thier todos localhost:8080/backups (POST method)
- get list of backups localhost:8080/backups (GET method)
- export in CSV  localhost:8080/export/{backupId}


project use:
maven
spring
@lombok


This is service for backuping 
We already have a simple server for tracking todo items(not in this repo).
Which contains two entity types User and Todo.
 - User has an id, a username, an email address and a list of todo items.
 - Todo has an id, a subject, a due date and if the item is done or not.
The server provides to following REST API:
localhost:9000

