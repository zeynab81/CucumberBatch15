package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    //this method create connection to DB, execute query and return object for resultset
    public static ResultSet getResultSet(String sqlQuery){
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));
            statement = conn.createStatement();
            rset = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }

    //this method will return the object of rsetmetadata
    public static ResultSetMetaData getrSetMetaDa(String query){
        rset = getResultSet(query);
        rSetMetaData = null;
        //we use this line to get the data in tabular format so that
        //we can use these in column keys and values for retrieval operation
        try {
            rSetMetaData = rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }

    //this method is extracting the data which will be stored in list of maps
    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        rSetMetaData = getrSetMetaDa(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = rSetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }

    //order to make connection
    //connection
    //statement
    //resultset

    //close resultset
    //close statement
    //close connection
    public static void closeResultSet(ResultSet rset){
        if(rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



/*
break down each method:

1.getResultSet(String sqlQuery): This method takes an SQL query as a parameter and establishes a connection
to the database using the DriverManager.getConnection() method. It then creates a Statement object and executes
the query using statement.executeQuery(sqlQuery). The ResultSet object is returned, containing the results of the executed query.

2.getrSetMetaDa(String query): This method returns a ResultSetMetaData object for the provided SQL query.
It first gets a ResultSet object by calling the getResultSet() method and then retrieves the metadata from it using rset.getMetaData().

3.getListOfMapsFromRset(String query): This method retrieves the data from the provided SQL query as a list of maps.
Each map represents a row in the result set, with column names as keys and the corresponding values as values.
The ResultSetMetaData object is obtained, and the result set is iterated through, constructing a map for each row.
Finally, the resources are closed using the closeResultSet(), closeStatement(), and closeConnection() methods.

4.closeResultSet(ResultSet rset): This method closes the provided ResultSet object if it's not null.

5.closeStatement(Statement statement): This method closes the provided Statement object if it's not null.

6.closeConnection(Connection conn): This method closes the provided Connection object if it's not null.

7.To use this utility class, you would call the getListOfMapsFromRset() method with an SQL query as an argument.
This would return the data from the query as a list of maps, which can then be easily processed in your application.


4 Operations in SQL CREATE,RETREAT UPDATE AND DELETE
 */