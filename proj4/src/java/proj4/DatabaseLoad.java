/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj4
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This program populates tables in the database with some default data.
 * Run this program only when the database has been freshly created and the
 * McKoi datbase management system is running as a socket server and after
 * DatabaseCreate.java has been run. 
*/

package proj4;

import java.sql.*;

/**
 * This program populates tables in the database with some default data.
 * Run this program only when the database has been freshly created and the
 * McKoi datbase management system is running as a socket server and after
 * DatabaseCreate.java has been run.
 */
public class DatabaseLoad {
   
    /**
     *Used to determine if there were any errors in database setup.
     */
    private boolean successful = false;
    
    /**
     *Register Mckoi JDBC driver
     */
    private boolean register(){
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
            return true;
        } catch (Exception e) {
            System.out.println("Cannot register driver: " + e);
            return false;
        }
    }
    
    /**
     *Attempts to get a connection to the database
     */
    private Connection getConnection(String url, String user, String pass){
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("cannot create database: " + e);
            return null;
        }  
    }
    
    /**
     *Closes the connection to the database
     */
    private void closeConnection(Connection c){
        // close the connection to database
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }  
    }
    
    /**
     *Returns if the creation was successful
     */
    public boolean getResult(){
        return successful;
    }
    
    /**
     * Executes a set of queries to load data into the tables in the database.
     */
    private void executeQueries(Connection c) throws SQLException{
        Statement s = c.createStatement();
        String query[] = {"insert into teacher (id, password) values ('jmm0468', 'f'), ('frank', 'password');",
        "insert into student (id, password) values ('student', 'f');",
        "insert into questions (question, answer, a, b, c, d) values ('The sky is which color?', 'b', 'red', 'blue', 'green', 'orange');"
        };

        for(int i = 0; i < query.length; i++){
            s.executeQuery(query[i]);
        }
    }
    
    /**
     *Registers the database driver, connects to the database and loads data into the tables,
     *the closes the connection and sets status to true.
     */
    public DatabaseLoad(){
        // register driver
        register();
        
        // make a connection to the database
        Connection connection = getConnection(LoginInfo.url, LoginInfo.user, LoginInfo.pass);
        
        // return if can't get a connection
        if(connection == null){
            System.out.println("Couldn't get connection,\ncheck to see that the server is running.");
            return;
        }
        
        // set up database
        try {
            executeQueries(connection);
        } catch (SQLException e) {
            System.out.println("Error in database load: " + e);
            return;
        }
        
        // close db connection
        closeConnection(connection);  
        
        // update status
        successful = true;
    }
    
    /**
     *Allows this program to be run standalone.
     */
    public static void main(String []args) {
       System.out.println("Success in loading data to database: " + (new DatabaseLoad()).getResult());                
    }
    
}


