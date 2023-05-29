package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {

             /* to build the connection with the database
    we need 3 things, URL, username, password
     */
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            //we need to establish the connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statement to send sql queries
            Statement statement = conn.createStatement();
            //when we send any query to the database then db returns
            //result set ( tables with rows and columns)
            ResultSet rset = statement.executeQuery("select FirstName, LastName from person");
            rset.next();

            String fName = rset.getString("FirstName");
            String lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}