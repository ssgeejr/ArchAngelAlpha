# ArchAngel
Sample Project: standalone, java, containerized microservice ... with a Mongo and CouchDB backend

### Index
* [Build Application](#build-application)
* [Build Docker image](#build-docker-image)
* [Starting](#starting)
* [Testing](#testing)

#### Build Application
cd ${project-home}\ArchAngel
mvn clean package

This will compile the two modules service and frontend

You should see something similar to:
[INFO] Reactor Summary:
[INFO] 
[INFO] ArchAngel 1.0-SNAPSHOT ............................. SUCCESS [  4.613 s]
[INFO] archAngelService ................................... SUCCESS [ 52.922 s]
[INFO] ArchAngelFrontEnd 1.0-SNAPSHOT ..................... SUCCESS [  2.798 s]
[INFO] ------------------------------------------------------------------------
INFO] BUILD SUCCESS



#### Build Docker image
Forthcoming

#### Starting

from ${project-home}\ArchAngel\service
java -jar target\archAngelService.jar -httpPort=9000

from ${project-home}\ArchAngel\frontend
java -jar target\archAngelFrontEnd.jar


#### Testing
the mongo & couchdb source code is in flight, presently, it will echo what you put into the boxes


