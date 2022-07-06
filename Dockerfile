FROM ubuntu-jdk
MAINTAINER Rafal Mirowski
ENV version=0.1
ENV dbuser=postgres
ENV dbpass=admin123
ENV jdbcurl=jdbc:postgresql://pma-aws-db.cw2jsaubrcgn.eu-central-1.rds.amazonaws.com:5432/postgres
WORKDIR /usr/local/bin
ADD target/project-management-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "project-management-0.0.1-SNAPSHOT.jar"]