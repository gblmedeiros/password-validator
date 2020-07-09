# Passval

This is a simple password validation service. 
It is designed to provide a REST API where a password is submitted and then it is validated
against the following rules:

* At least 9 characters
* At least 1 digit
* At least 1 upper case letter
* At least 1 lower case letter
* At least 1 special character
* Do not contain a repeated character
* Do not contain whitespace

A special character is a character in the list:

`!@#$%^&(){}[]:;<>,.?/~_+-=\|` 

### Tech stack

This service is developed using Springboot and Kotlin. 
Although that does not have Docker files neither CI files, it is easy to dockerize and run into a CI pipeline.

The project is structured following DDD definitions and Onion Architecture, so it's simple to change just the framework, 
for example, change Spring for some reactive framework. 

### Running

To build, please run the command in the root dir:

`./mvnw clean install`

And then, to start service:

`java -jar ./application/target/application-1.0-SNAPSHOT.jar`

After that, service will be running at port 9090 and you can access a Swagger UI page at:
`http://localhost:9090/swagger-ui.html`

You can use directly swagger page to test or do a `curl` request:

`curl -X POST "http://localhost:9090/password/validate" -H "accept: application/json" -H "Content-Type: application/x-www-form-urlencoded" -d "password=asd"`

This request will return a validation message in the format: 

`{
   "valid": false,
   "msg": "Nove ou mais caracteres"
 }`
 
 where `valid` indicates if the input password is valid and `msg` the proper validation
 message to help user to understand why password is not valid.
 
 ### How it works
 
 After a `POST` of the desired password through the API, this input will be tested against many independent validators. 
 Each validator has a rule like mentioned before.
 If some of these rules is not matched, then password is not valid. 
 
 Each validator has a validation message that explicits why password is invalid.
 This way is easy to an user to understand why password is invalid. Also it is very easy to use in an UI. Just call API
 and show message to user.
 
 To create a new validation, just implement `PasswordValidator` and register into `passwordValidators` Spring bean.
 