# Project - Spring RESTful Service using SpringBoot
Comprehensive Spring RESTful Server and Client Application. Contributors are most welcome and you are free to distribute and usage. Just send a THANK YOU NOTE to us at [NEWFOUND SYSTEMS (http://www.newfound-systems.com)]

## Getting Started

### Prerequisities
* Basic understanding of Spring Framework which Includes Spring Boot, Spring Security.
* Understanding on how JSON or XML structure.
* How to Use Google Collections.

### Technologies
* JDK 1.7 and above
* Maven 3+
* Jackson Bind
* Apache Tomcat 8+
* Google Guava Collections
* Advanced Rest Client as Chrome Extension or PostMan for REST Client Testing

## Running the server
Spring Boot Main Class, Just run below class like any another Java Code
* com.newfound.rest.server.app.RestServerApplication

## Running the client
### Run using Sample Java Client
* com.newfound.rest.client.RestTemplateClient

### Using any Browser for GET Method
####
* http://localhost:8080/person/find/all.json (Notice expected response is JSON)
* http://localhost:8080/person/find/all.xml (Notice expected response is XML)
####
* http://localhost:8080/person/find/id/1.json
* http://localhost:8080/person/find/gender/MALE.json
* http://localhost:8080/person/find/firstName/John

### Using Advanced REST Client or POSTMAN for POST Method
* http://localhost:8080/person/update/1/99999
* http://localhost:8080/person/create
* http://localhost:8080/person/delete/1

## Running on https
You can uncomment **src/main/resources/application.properties** to run secured service enabled

## Versioning
We use [Apache Subversion (https://subversion.apache.org/)] for versioning. 

## Authors
* **Chetan Anand** - *Initial work* - [NEWFOUND SYSTEMS http://www.newfound-systems.com]

## License
This project is licensed under the Open Free for all License.

## Acknowledgments
* Many Inspirations from http://websystique.com for their walk through of Spring related technologies. Thanks

