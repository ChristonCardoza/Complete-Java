# Spring-Boot Basics

## What is Spring?
 1. Application framework
 2. Programming and configuration model
 3. Infrastructure support

## Problems with Spring
 1. huge framework
 2. Multiple setup steps
 3. Mutliple configuration steps
 4. Multiple build and deploy steps

## What is Spring Boot?
 1. spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"
 2. Opinionated
 3. Convention over configuration
 4. Stand alone
 5. Production ready

## pom.xml
 1. Group Id : kind of package name (Uniquely identifies my name space in this project)
 2. Artifact Id : kind like project name
 3. Version : version of component(project)
 4. Parent : It declare what project we are creating is the child of this parent
    1. groupId: org.springframework.boot
    2. artifactId: spring-boot-starter-parent
    3. Version: 1.4.2.RELEASE
 5. Dependencies/Dependency : Here we can specify dependency required for our project
    1. groupId: org.springframework.boot
    2. artifactId: spring-boot-starter-web
 6. Properties : here we can add addition configuration for project
    java.version: 1.8

## Embedded Tomcat Server
 1. Convenience
 2. Servlet container onfig is now application config
 3. Standalone application
 4. Useful for microservices architecture

## Annotation
 1. @SpringBootApplication: Tells the spring this class is the spring boot application (class should have main method). To start project we should add this code in main method
    ```java
        SpringApplication.run(<App.class>,args)
    ```
    1. Sets up default configuration
    2. Starts Spring application context
    3. perform class path scan
    4. Starts Tomcat server  
 2. @RestController : Tells the spring this class is REST controller which is responsible for REST calls
    ```java
        @RestController
        public class HelloController{
            -----------------
        }
    ```
 3. @RequestMapping(url): Tells the spring whenever it hit the request having url same as this then run this method where this annotation being used. The  @RequestMapping maps only to the GET method by default. 
   
```java
        @RequestMapping("/hello")
        public String sayHi(){
            -----------------
        }
```  
    if we want to map other method then

```java
    @RequestMapping(method=RequestMethod.POST,value="/topics")
    public void addTopic(){
        -----------------
    }
```
    if the url conatins the veriable , then use {}
```java
        @RequestMapping("/topic/{id}")
        public String getTopic(@PathVariable String id){
            -----------------
        }
``` 
    if  the url conatian body and we can make use of it by
```java
    @RequestMapping(method=RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic){
        -----------------
    }
```

 4. @Service: Tells the spring this class is Buisness Service.Its singleton

 5. @Autowired: Dependency injection 
 
 6. @PathVariable: Maps the variable of uri to method which rquired it
   
```java
        @RequestMapping("/topic/{id}")
        public String getTopic(@PathVariable String id){
            -----------------
        }
```
 7. @RequestBody: Pass the body of url request to method which rquired it
```java
    @RequestMapping(method=RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic){
        -----------------
    }
```
## Starting a Spring Boot App
 1. Spring Initializr: Online web tool https://start.spring.io/
 2. Spring Boot CLI: https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-cli.html#:~:text=The%20Spring%20Boot%20CLI%20is,your%20own%20command%20for%20it.
 3. STS IDE: Spring Boot Tool suite

## Customizing Spring Boot
 application.properties (https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
   Ex: server.port =  8081

## Deploying and Monitoring
 Build Maven - mvn clean install
 Monitoring - add actuatir in pom.xml
 ```xml
  <dependency>
    <groupId>org.springframework.boot<groupId>
    <artifactId>spring-boot-starter-acuator</artifactId>
  </dependency>
 ```
  call the REST ie, 
    http://localhost:8080/health
    http://localhost:8080/beans
	
## Spring Data JPA(Java Persistance API)
 1. Its a JPA(Java Persistance API) based ORM (Object Relational Mapping ) mainly used with Databases
 2. Annotation:
   
    1. @Entity: Tells that given class is structe of the database
        ```java
            @Entity
            public class Topic{
                -----------------
            }
        ```
    2. @Id: Helps for specifying the Key(primary key)
        ```java
            @Entity
            public class Topic{
            @Id
            private String id;
            private String name;
            private String description;
            }
        ```
            To make use of all crude operation avilable for that entity(database) create a interface which extends the CrudRepository from Data JPA

        ```java
            public interface TopicRepository extends CrudRepository<Topic, String>{
            }
        ```
            Here we are using 2 Generics ie
                Topic : This is Entity or database structure
                String : Datatype of the key ie primary key.

            we no need to write new crude operaion, the instance of TopicRepository has some crude method

            if we are interested in declare any method in CrudRepository

        ```java
            
            public interface TopicRepository extends CrudRepository<Topic, String>{
                
                public List<Course> findByTopicId(String topicId)
            }
        ```

      3. @ManyToOne: Helps for specifying the foreign Key
    ```java
        @Entity
        public class Topic{
            @Id
            private String id;
            private String name;
            private String description;
            @ManyToOne
            private Topic topic
        }
    ```