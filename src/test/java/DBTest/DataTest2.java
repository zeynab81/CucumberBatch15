package DBTest;

import java.sql.*;

public class DataTest2 {

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

   ResultSet rset = statement.executeQuery("select firstname, lastname, age, city "  +
           " from person where city is not null;");
            //ResultSetMetaData - object that contains information about the result
            //information such as in  the table how many columns are there,
            //name of the columns, rows and number of the rows

            ResultSetMetaData metaData = rset.getMetaData();

            for (int i=1; i<=metaData.getColumnCount(); i++){
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }
           /* while (rset.next()){
                String fName = rset.getString("FirstName");
                String lName = rset.getString("LastName");
                System.out.println(fName + " " + lName);
           }
            */
  // We want to loop through every column and every row

            while (rset.next()){
                for (int i=1; i<=metaData.getColumnCount(); i++){
                    String value =  rset.getString(metaData.getColumnName(i));
                    System.out.println(value + " ");
                }
                //just to change the line statement added below
                System.out.println();

          }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
