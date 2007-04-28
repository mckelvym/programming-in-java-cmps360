/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj3
 * Date Assigned:   Thursday, 12 April 2007, 4:10 PM
 * Due date:        Friday, 4 May 2007, 10:00 PM
 * Description:
 * This program creates table descriptions in the database.
 * Run this program only when the database has been freshly created and the
 * McKoi datbase management system is running as a socket server. 
 */

package proj3;

import java.sql.*;

/**
 * This program creates table descriptions in the database.
 * Run this program only when the database has been freshly created and the
 * McKoi datbase management system is running as a socket server. 
 */
public class DatabaseCreate{
    
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
     * Executes a set of queries to setup the tables in the database.
     */
    private void executeQueries(Connection c) throws SQLException{
        Statement s = c.createStatement();
        String query[] = {"create table teacher (id char(7) primary key, password varchar(10));",
        "create table student (id char(7) primary key, password varchar(10));",
        "create table questions (question varchar(250) primary key, answer char(1), a varchar(100)," + "" +
                " b varchar(100), c varchar(100), d varchar(100));"};
        
        for(int i = 0; i < query.length; i++){
            s.executeQuery(query[i]);
        }
    }
    
    /**
     *Registers the database driver, connects to the database and sets up the tables,
     *the closes the connection and sets status to true.
     */
    public DatabaseCreate(){        
        // register driver
        register();
        
        // make a connection to the database
        Connection connection = getConnection(LoginInfo.url_create, LoginInfo.user, LoginInfo.pass);
        
        // return if can't get a connection
        if(connection == null){
            System.out.println("Couldn't get connection,\ncheck to see that the server is running.");
            return;
        }
        
        // set up database
        try {
            executeQueries(connection);
        } catch (SQLException e) {
            System.out.println("Error in database setup: " + e);
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
    public static void main(String args[]){
        System.out.println("Success in creating database: " + (new DatabaseCreate()).getResult());        
    }
}
