%title: SpringBoot Learning
%author: Aemson Michael
%date: 2021-12-03

-> # About Me <-

Hi, I am Aemson Michael .

- 9.3yrs experience in development
- Kotlin - 4yrs, Java - 9 yrs, React/TypeScript - 4yrs
- SpringBoot - 5yrs, Struts 2.0 3yrs

--------------------------------------------------
-> # Introduction <-
==============

- Spring Boot is an open-source framework.
- Auto configurable production-grade application.
- A lightweight framework.
- Helps with loose coupling dependencies and testability. 
- The modular architecture allows you to pick the parts you need and isolate them.

-------------------------------------------------
-> # Additional Benefits  <-
==============

- Reduces development time and increases the overall productivity of the development team.
- Helps you autoconfigure all components for a production-grade Spring application.
- Makes it easier for developers to create and test Java-based applications by providing a default setup for unit and integration tests.
- Avoids writing lots of boilerplate code, annotations, and XML configuration.
- Comes with embedded HTTP servers like Tomcat or Jetty to test web applications.

-------------------------------------------------
-> # Setup New App  <-
==============

- Use start.spring.io 
- Choose Project Maven or Gradle
- Select SpringBoot starter parent version 
- Language Java or Kotlin 
- Fill up the other data
- Select Packaging Jar or War
- Select Java version 
- Download 

-------------------------------------------------
-> # Entry Point  <-
=============

```
@SpringBootApplication
public class SpringTutorialApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }
}
```

- The @SpringBootApplication is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan. 

-------------------------------------------------
-> # Add your code: Controller  <-
=============

```
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
```

- The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. 
- The @GetMapping(“/hello”) tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address. 
- Finally, the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word “World” by default.

-------------------------------------------------
-> # Add your code : RequestMapping <-
=============

```
    @RequestMapping(name = "/helloNew", path = {"/hello/{name}"}, 
                    value = "/hello/{name}", params = {""}, 
                    produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE,
                    method = RequestMethod.?)
```

- Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
- name = "name of the request", path = "The path" ,value = "Alias to path"
- params = to differentiate the methods with same path 
- Produces/Consumes = The content type it accepts and returns
- method = GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
- Default is GET
- Can be added at class level

-------------------------------------------------
-> # Add your code : * Mapping <-
=============

```
    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
```

- All these are internally mapped to RequestMapping 

-------------------------------------------------
-> # Add your code : RequestParam <-
=============

```
    @RequestParam(name = "name", value = "name, defaultValue = "Hello", required = false)
    
    - ex. http://localhost:8080/hello?name=HelloWorld
```

- Indicates that it should be bound to a web request parameter.
- name = "The name of the request parameter to bind to" ,value = "Alias to name"
- defaultValue = "Some value" ,required = false/true

-------------------------------------------------
-> # Add your code : PathVariable <-
=============

```
    ("/{name}")
    @PathVariable(name = "name", value = "name", required = false)
    
    - ex. http://localhost:8080/hello/HelloWorld
```
- Indicated that it should be bound to a URI template variable.
- name = "The name of the request parameter to bind to" ,value = "Alias to name"
- required = false/true

-------------------------------------------------
-> # Add your code : Output <-
=============

```
    public ResponseEntity<?> hello() {
        ResponseEntity.ok().body(?);
    }
```
- ResponseEntity is extension of HttpEntity .
- Provides the status of Response can provide cache control

-------------------------------------------------
-> # Run your code   <-
=============

Two ways to run your project .
1. Run the Main method 
2. Using maven
```
   maven clean install spring-boot:run
```

-------------------------------------------------

-> # Properties  <-
=============

Two ways to add properties your project .
1. application*.properties
2. application*.yaml


-------------------------------------------------
-> # Profiles  <-
=============

Spring Profiles provide a way to segregate parts of your application configuration and make it only available in certain environments.
We can do this by
- Default one :: application.properties or application.yaml
- Dev environment :: application-dev.properties or application-dev.yaml

-------------------------------------------------
-> # Accessing the Properties  <-
=============

Two ways to add properties your project .
1. @Value
2. @ConfigurationProperties

-------------------------------------------------

-> # Beans  <-
=============

```
       @Bean({"name1","name2"})
       public MyBean myBean() {
           return obj;    // instantiate and configure MyBean obj
       }
```

- Indicates that a method produces a bean to be managed by the Spring container.
- @Profile(String) to set it for specific profiles.
- @Order(int) to set order of bean instantiation. 
- @Primary if there are many beans with same type then to resolve ambiguity.
- or you can use @Qualifier(String).

-------------------------------------------------

-> # Service  <-
=============

```
       @Service
       public class ServiceClass {
       }
```

- Indicates that a class is a service.
- All business logic is written here.

-------------------------------------------------
-> # Repository  <-
=============

```
       @Repository
       public class RepositoryClass {
       }
```

- Indicates that an annotated class is a "Repository".
- A mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.

-------------------------------------------------
-> # Filter <-
=============

```
@Component
@Order(1)
public class TransactionFilter implements Filter {}
```
- Class has to be component and implement Filter
- Filter should be ordered if same filter pattern is present .

-------------------------------------------------

-> # Change default port  <-
=============

```
server.port
```
- In yaml or properties add the following

-------------------------------------------------
-> # Change Context Path  <-
=============

```
server.servlet.context-path
```
- In yaml or properties add the following

-------------------------------------------------
-> # Exception handling  <-
=============

```
@ExceptionHandler
```
- Annotation for handling exceptions in specific handler classes and/or handler methods.
- Handler methods which are annotated with this annotation are allowed to have very flexible signatures. 

-------------------------------------------------
-> # Security : Adding dependency <-
=============

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
- Need to add this `spring-boot-starter-security` 

-------------------------------------------------
-> # Security : Code <-
=============

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
- Need to add this `spring-boot-starter-security` 

-------------------------------------------------
-> # Conclusion  <-

Thank You !!
