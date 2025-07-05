FROM maven:3.8.3-openjdk-17
#creating a directory
WORKDIR /orderservicetest
#adding ur code to the directory
ADD ./ .
#to run test after container creation
CMD mvn test