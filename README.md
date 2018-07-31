Microservices using Spring Boot and JIB  
=======================================  

Learn-Make _Microservices using Spring Boot, JIB, Docker_           


# LEARN & MAKE  

## Reading   
Some useful links to advance your learning:     

- Building apps with [Spring Boot](https://spring.io/guides/gs/spring-boot/)       
- Containerize Java App into Docker images via [Google's JIB](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin)               


## Setup your DEV env      

Getting up and running for your dev-env is as easy as counting 1 to 4 :-)     

1. Make sure you have installed [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html) _version 8_, [Maven](https://maven.apache.org/index.html) _version 3.3.1 or higher_.        

2. Clone this repo and verify compile  

    ```
    git clone https://github.com/CapgeminiNorway/learnmake-microservices  
    cd path/to/learnmake-microservices  
    mvn clean compile  
    ```

3. Build, containerize & push to docker repository    
    
    - Build and push a container image for your application to a container registry.  
    _nb! make sure you already have created a project at Google Cloud Platform, then set `docker.image.prefix` inside `pom.xml`_                  

    ``` 
    mvn clean compile jib:build -e
    ```  
    If you encounter authentication issues, see [Authentication Methods](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#authentication-methods).  
            
    To build to a Docker daemon, use:  
    ```
    mvn clean compile jib:dockerBuild -e
    ```    
    ...  

4. Run inside Eclipse or Intellij IDEA    
    Import as standard Maven project.        
 
## Together We DO!  
Please contribute with comments, pull-requests, etc.  
  
