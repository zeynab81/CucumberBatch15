package DBTest;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataTest3 {
 public static void main(String[] args) {
//2. It defines the necessary information to establish a database connection: the URL, username, and password.
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

//3. The `DriverManager.getConnection` method is used to establish a connection
// to the MySQL database specified by the URL, username, and password.
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection is created for batch 15");
            Statement statement = conn.createStatement();
            String query = "select * from person;";
            ResultSet rset = statement.executeQuery(query);
            ResultSetMetaData rsmdata = rset.getMetaData();
            List<Map<String, String>> listFromRset = new ArrayList<>();
            //iterate through the rows
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                //iterate over columns
                for (int i = 1; i <= rsmdata.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = rsmdata.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*

This code establishes a connection to a MySQL database, executes a SQL query, and retrieves the result set. It then iterates through the result set, extracts the data, and stores it in a Java data structure (specifically, a list of maps). Here's a breakdown of the code:

1. The code begins with the `main` method, which is the entry point of the program.
2. It defines the necessary information to establish a database connection: the URL, username, and password.
3. The `DriverManager.getConnection` method is used to establish a connection to the MySQL database specified by the URL, username, and password.
4. If the connection is successfully established, a message "Connection is created for batch 15" is printed.
5. A `Statement` object is created to execute SQL queries against the database.
6. The SQL query "select * from person;" is defined in the `query` variable.
7. The `executeQuery` method of the `Statement` object is called with the `query` to execute the query and obtain a `ResultSet` object.
8. The `ResultSetMetaData` object (`rsmdata`) is obtained from the `ResultSet` to retrieve metadata about the columns in the result set.
9. The code initializes an empty list (`listFromRset`) to store the data extracted from the result set.
10. The code iterates through each row in the result set using the `next` method of the `ResultSet`.
11. For each row, a new `LinkedHashMap` (`map`) is created to store the column names and values for that row.
12. The code iterates over the columns using a `for` loop and retrieves the column name and corresponding value from the result set.
13. The column name is obtained using `rsmdata.getColumnName(i)`, and the column value is obtained using `rset.getString(key)`.
14. The key-value pair is added to the `map` using the `put` method.
15. The `map` is printed using `System.out.println`.
16. The `map` is added to the `listFromRset`.
17. After all rows have been processed, the code exits the loop, and the program completes.
18. If an exception occurs during the execution of the code (e.g., a SQL exception), it is caught in the `catch` block, and the stack trace is printed.

Overall, this code establishes a connection to a MySQL database, retrieves data from a table, and stores it in a Java data structure for further processing or analysis.
 */