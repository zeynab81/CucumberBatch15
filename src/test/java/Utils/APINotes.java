package Utils;

public class APINotes {
    /*

    JDBC notes -
recap -
mysql connector java is the dependency we have added

we need 3 things to work with DB
address of DB - url
Name of DB -
Username, password -

Connection class - to establish the connection with DB
make a statement - it allows us to send the query to the DB
resultset - the result will be stored in its object

rset.next() - to shift the cursor on to the next line/row

resultsetmetadata - it contains the information about the result such as how many columns are
there, how many rows, name of columns/rows etc.


--------------------------------------
to integrate with framework, we will pass url, username and password in config.prop file

---------------------------------------

In order to integrate our db in framework, we create dbutility class

select *
from hr_hs_employee
where employee_id='12345';

we have added a scenario in addemployee feature file
we have added steps in add employee steps page
we have added tag of the scenario in runner class



scenario is to capture the employee id from UI
and verify it with the DB
 for this, we have added scenario in feature file
 and added in step definitions

 then we are verifying firstname, middlename, lastname etc one by one
 because we cannot compare bunch of values  in one attempt


-----------------API-------------------------------------------

Class 1 -

API - application programming interface

non technical example - MS - cafe, (client, server, intermediator)
semi technical example - ATM - Bank example
technical example -

Client - the one who sends the request (user)
Server - the one who gives  the response to the request.
API - an intermediator who transfers the information from client - server and from server to client.


presentation layer - UI - user interface- front end - what we see on the screen is presentation layer
Application layer - it is the place where the logic of the application has been written

API ---- middleware (API developers/API testers)

data layer - backend - where data is coming from.


Client - server architecture


1 tier architecture -


when the presentation layer, application layer and data layer are available at the same place. 1 tier architechture.

example - Calculator, notepad, wordpad, games, paint etc.


2 tier architecture

when presentation layer is available on client end
application/data layer is avaialable  on server end

examples - dominoss, macdonalds, pizza hut, subway, kfc etc




3 tier architecture
when presentation layer is available at client end
Application/business layer is available at another end
Data layer is available at server end

example - hrms application


n tier architecture -

when we have n number of presentation layers
n number of application layers
n number of data layers

example - amazon, instagram, fb etc.


why do we need API's?


front end - react, native
back end - java, python, js

Why we need to use API's
1. To make the systems communicate which are developed in different languages, we use API's.
2. For security purpose.


albama to dubai - 123abc
hyd to VA - 123abc


front end

middleware

back end

why do we need to test API's?
to make sure that the same information is coming from the db is reflecting on to the front end



create a new record in the database
retrieve the record from the database
update a record in the database
delete a record from the database

CRUD operations -

to test the api -

we need address of the api
we need endpoint


DNS - domain name server

IP address - 2.323.432.212

address of the api -
 URL - uniform resource locator
 location of the api - group of similar api's

end point - specific details


BASE URI - uniform resource identifier

Base URI - Base URL + endpoint


Base URL - hrm.syntaxtechs.net/syntaxapi/api
Endpoint - /getAllEmployees.php


Base URI - hrm.syntaxtechs.net/syntaxapi/api/getAllEmployees.php

Class 2 -
recap -

API - middle man - waiter, the one who transfer the message from client to server, server to client
client - the one who send the request
server - the one who respond to this request

client server architecture -

presentation layer - what we see on the application
Application layer - where the logic of the application has been written
Data layer - where data is available

1 tier
2 tier
3 tier
n tier architecture

base URL - this will be same in all the cases
End point - this will change with every case

Base URI - Base URL + end point


CRUD operations we perform  on all the levels


API's which are hosted over the internet are called web services

all the web services are API but All the API's are not web services


there are 2 types of web services -
REST - representational state transfer
SOAP - simple object access protocol

REST web service
SOAP web service


API testing -

HTTP - hyper text transfer protocol
it allows  us to communicate over the internet with different applications


in order to perform operations on the applications, we have to follow HTTP methods (functions)

Create - POST
Retrieve - GET
Update - PUT
Delete - DELETE

for windows - https://www.postman.com/downloads/
for mac - https://learning.postman.com/docs/getting-started/installation-and-updates/#installing-postman-on-mac



For testing the API - we need admin user first, this user will give permission for other operations

Base URI - base url + endpoint

FOR CREATIING AN ADMIN USER - WE ARE PREPARING A REQUEST

base URL - hrm.syntaxtechs.net/syntaxapi/api
Endpoint - /createUser.php

Base URI - hrm.syntaxtechs.net/syntaxapi/api/createUser.php

what is body/payload -

NEVER CHANGE THE KEY IN BODY

{
  "name": "adminbatch15",
  "email": "batch15@test.com",
  "password": "test123"
}


it always be either in JSON or XML

REST uses JSON - javascript object notation - it is just a format of data







200
201


400
401
402
403
404
405

Class 3 -

recap -

Information we need to prepare the request -

base url
end point
body/payload
headers (content - type)

In response -
API status code
Time of execution
body of the response

admin user we have created -

from swagger document we collected all the details to send the request -
POST - 201 is the status code we should get when we add a record in the system

the body which we have provided is sent in JSON format



Authentication and Authorization
Example : In order to  post anything on Facebook/Instagram, first you have to show your identity ( login) then only you will be able to perform any operation.


Authentication -
 it confirms your identity to grant permission in the system

Authorization -
It controls whether you are allowed to perform certain operations across the system

who are you?
Are you allowed?
Show your ID?
What permissions you have?

stateful application - it is the application where the state of the server memory is set to true.
it allows us to store the credentials in this memory to reduce the total login attempts.

the problem with this type of application is, it can be hacked easily

Stateless application
it doesn't have server memory and will generate token for accessing the application

because there is no server memory it goes to db directly.

stateless application is more scalable than stateful application


to perform further operations as an admin, we need token which will show our identity as as admin

To generate token - we need to send API request

Base URL - hrm.syntaxtechs.net/syntaxapi/api
End point - /generateToken.php

Base URI - hrm.syntaxtechs.net/syntaxapi/api/generateToken.php
Type of the method - POST
Body (JSON format) -

{
  "email": "batch15@tests.com",
  "password": "test123"
}

Header - Content-type - application/json

Class 4 -

recap -

authentication and authorization


stateful application -
stateless application -

To generate token - we need to send API request

Base URL - hrm.syntaxtechs.net/syntaxapi/api
End point - /generateToken.php

Base URI - hrm.syntaxtechs.net/syntaxapi/api/generateToken.php
Type of the method - POST
Body (JSON format) -

{
  "email": "batch15@tests.com",
  "password": "test123"
}



There are 3 types of token in API -

MAC token
Bearer token
Grants


Bearer Token - json web token (JWT)



eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
eyJpYXQiOjE2ODQ1OTI4NjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDYzNjA2OCwidXNlcklkIjoiNTI2MyJ9.
b8Aa-c9Ja7jh473vg6M3R_ww_LYpYFYEqmEOTBCEqaw

bearer token has 3 parts -
Header
Payload
Signature

Header - There are 2 parts in header
i - type of token
ii - the signing algorithm being used for token.


body/payload - it contains information about the issuer, expiration time, userid, issue time

signature - it is used to verify the message wasn't changed along the way


to perform crud operations -

CREATE AN EMPLOYEE -
base URI - url + endpoint - hrm.syntaxtechs.net/syntaxapi/api/createEmployee.php
Type of method - POST
Body -

{
  "emp_firstname": "nelena",
  "emp_lastname": "faria",
  "emp_middle_name": "ms",
  "emp_gender": "F",
  "emp_birthday": "2012-05-20",
  "emp_status": "Confirmed",
  "emp_job_title": "Engineer"
}

content-type - application/json




we have Created an employee -

data is not stored in DB properly
data is available in DB but API is not giving us the correct data

after every single operation, we need to perform GET call to check the latest changes are updated or not

create an employee -> Get the created employee


GET CREATED EMPLOYEE -

base URI - url + endpoint - hrm.syntaxtechs.net/syntaxapi/api/getOneEmployee.php
TYPE OF METHOD - GET
query parameter -
employee_id = 53116A
Authorization

response code 200


in any URL, whatever comes after ? is my query parameter
and whatever comes before ? is my path parameter

example - https://www.saucedemo.com/inventory-item.html?id=4

in statefull application we need to provide in authorization tab - basic auth and will add username and password

GET EMPLOYEE STATUS -

base uri = hrm.syntaxtechs.net/syntaxapi/api/employeementStatus.php
TYPE OF METHOD = GET
authorization = token

status code in response = 200


In homework - create an api request for
get all employees
get all job title


Create an employee -> Get the created employee
Get ALL Employee status

UPDATE AN EMPLOYEE -

Base URI = hrm.syntaxtechs.net/syntaxapi/api/updateEmployee.php
Type of Request = PUT

{
  "employee_id": "53116A",
  "emp_firstname": "visnja",
  "emp_lastname": "hasmik",
  "emp_middle_name": "msa",
  "emp_gender": "M",
  "emp_birthday": "2003-05-20",
  "emp_status": "probation",
  "emp_job_title": "CEO"
}

content-type = application/json
authorization = token

status code - 200



PARTIAL EMPLOYEE UPDATE -

Base URI = hrm.syntaxtechs.net/syntaxapi/api/updatePartialEmplyeesDetails.php
Type of METHOD = PATCH

Body =

{
  "employee_id": "53116A",
  "emp_job_title": "Manager"
}

content-type = application/json
authorization = token




Create an employee -> Get the created employee
Get ALL Employee status
Update the employee -> Get the updated employee
Update partial employee -> Get the partially updated employee


DELETE AN EMPLOYEE

Base URI - hrm.syntaxtechs.net/syntaxapi/api/deleteEmployee.php
Type of METHOD - DELETE
Authorization -
employee_id -

response code is 200


Create an employee -> Get the created employee
Get ALL Employee status
Update the employee -> Get the updated employee
Update partial employee -> Get the partially updated employee
DELETE Employee -> Get deleted employee
(When you retrieve deleted employee from the db, it will give you 400 since the data is already deleted from db)


Cookies - cookies are small blocks of code created by a web server. While a user is browsing a website and placed on the user's computer by browser.



data stored in cookies will be used for 2 reasons -
in house product development
3rd party cookies




class 5 -

recap -

CRUD -
3 types of token -
MAC token
Bearer token
Grants

3 parts of bearer token
header
payload
signature

PUT - response code is 200
PATCH - response code is 201

query parameter - key and value
id=4,

path parameter
www.amazon.com/electronics/offers/

DEV, TEST, STAGING, PROD

to add the environment, we need to use environment tab
but to add all the endpoints, we need to use globals


to run collection
select run collection open
select checkbox for the request you want to execute
de select remaining requests
iterations - 1 number of executions for collection

Java script language function

function myFunction(p1, p2) {
  //block of code
  console.log("hello")
  return p1 * p2;
}

postman uses chai assertion library for assertions

pm is the postman object which comes with built-in JS API


in this pm object we will be having all the methods/functions of chai library

pm.expect - if you are expecting any value/field/key in the response
pm.assert -
pm.should


pm.test - this is the test considered in postman


Homework - verify the status code in PUT and PATCH request
put assertions in all the request for time check and string check


Class 6

recap -

how to run collection -
as per the requirement, we can include/exclude the api request and can run via collection to get the results in one time.

we can select environment in postman - we provide variable of the env along with base URL
in globals we usually pass our end points and token

postman has built-in assertion library called chai -

functions of Assertion can be found under snippets column in test

majorly - we need to focus on these assertions -
API status code
response body (any key, any value)
response headers (any header)
response time


REST assured API library

REST web service, the REST web service allows data to be sent in JSON format/object

JSON object consists of key and value pairs

Rest assured is DSL (domain specific language) which is a java library used to automate REST API.

REST assured library follows BDD (behavioral driven development) approach

in cucumber
Given - pre condition
When - Actions
Then - result/expected output

in REST assured API
given - preparing the request
when - make a call/ send the request/ hitting the end point
then - verification/assertions


in postman -
base URI = base URL + endpoint

in rest assured API
base URI = base URL

hamcrest matchers -
hamcrest is a popular framework that  helps us to create matcher objects.
It is used for writing tests and performs testing in programming. Hamcrest is mainly
used with other testing frameworks like junit.

Hamcrest matchers -
class that contains methods to perform assertions

JsonPath vs jsonPath()?

JsonPath is a class
jsonPath() is a method that belongs to JsonPath class

Class 7

integrated Rest Assured API library with framework

BDD -
given - prepare the request
when - make a call/hitting the endpoint
then - verification/assertion


base URI = base URL
because given keyword is used to create a request
and when keyword is to send the request thats why both cannot be in the base URI

request specification - to prepare the request
response - after sending the request, response will be stored in this variable

hamcrest matchers -






























































































































     */
}
