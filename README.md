# angular-spring-mongo-docker

This project will show how to dockerize and run a full stack project(angular,spring,mongoDB).

##Instruction:

To run both backend and frontend by building the docker files.

> docker-compose.yml

1. Download from Github.
   > git clone https://github.com/CutupAngel/spring-boot-angular-docker.git
2. Build Spring Boot into Executabe Jar using MVN.
   > cd Backend
   > mvn clean package && java -jar target/app.jar
3. Run Docker
   > docker-compose up
4. Create `asmd_mongo_db` Database and create `roles` collection using mongoExpress(`localhost:8081`)
   Insert 2 roles into `roles` collection
   > ROLE_USER
   > ROLE_ADMIN
