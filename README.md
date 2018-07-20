# ArchAngel
Sample Project: standalone, java, containerized microservice ... with a Mongo and CouchDB backend

### Index
* [Build Application](#build-application)
* [Build Docker image](#build-docker-image)
* [Starting](#starting)
* [Testing](#testing)

#### Build Application
cd ${project-home}\ArchAngel
git checkout develop
mvn clean package

This will compile the two modules service and frontend



#### Build Docker image
Forthcoming

#### Starting

from ${project-home}\ArchAngel\service
java -jar target\archAngelService.jar -httpPort=9000

from ${project-home}\ArchAngel\frontend
java -jar target\archAngelFrontEnd.jar


#### Testing
the mongo & couchdb source code is in flight, presently, it will echo what you put into the boxes


