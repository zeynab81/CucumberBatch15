package DBTest;

public class Notes {

    /*JDBC notes -
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

select emp_firstname, emp_lastname
from hr_hs_employee
where employee_id='12345';

we have added a scenario in addemployee feature file
we have added steps in add employee steps page
we have added tag of the scenario in runner class

     */
}
