/*
 * MakeDB.java
 *
 * Created on February 8, 2004, 9:25 AM
 */

/**
 *
 * @author  fdd5501
 */


import java.sql.*;

public class MakeDB {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Register Mckoi JDBC driver
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Cannot register driver: " + e);
            return;
        }
        
        // URL for local database with configuration file
        String url = "jdbc:mckoi://localhost:9157/BedrockU.conf?create=false";        
        
        // create root user info
        String admin = "admin";
        String adminPw = "9999";
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot create database: " + e);
            return;
        }
        
        // set up database
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            ResultSet result;
            
            // create a Student table
            statement.executeQuery(
                "CREATE TABLE Student " +
                "(id INTEGER, name VARCHAR(25), majorId INTEGER)"
            );

            // create a Address table
            statement.executeQuery(
                "CREATE TABLE Address " +
                "(id INTEGER, street VARCHAR(25), city VARCHAR(25), " +
                " state CHAR(2), zip CHAR(9))"
            );
            
            // create a Enrolled table
            statement.executeQuery(
                "CREATE TABLE Enrolled " +
                "(id INTEGER, courseId INTEGER)"
            );
            
            // create a Course table
            statement.executeQuery(
                "CREATE TABLE Course " +
                "(courseId INTEGER, courseDesc VARCHAR(50))"
            );
            
            // create a Major table
            statement.executeQuery(
                "CREATE TABLE Major " +
                "(majorId INTEGER, majorDesc VARCHAR(50))"
            );
            
            // insert records into Student table
            statement.executeQuery(
                "INSERT INTO Student(id, name, majorId) VALUES " +
                "(9, 'Fred Flintstone', 1)"
            );
            statement.executeQuery(
                "INSERT INTO Student(id, name, majorId) VALUES " +
                "(13, 'Barny Rubble', 2)"
            );
            statement.executeQuery(
                "INSERT INTO Student(id, name, majorId) VALUES " +
                "(18, 'Betty Rubble', 3)"
            );
            statement.executeQuery(
                "INSERT INTO Student(id, name, majorId) VALUES " +
                "(27, 'Wilma Flintstone', 4)"
            );
            
            // insert records into Address table
            statement.executeQuery(
                "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                "(09, '123 Bedrock Rd.', 'Bedrock', 'HP', '01')"
            );
            statement.executeQuery(
                "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                "(13, '357 Stone Place', 'Bedrock', 'HP', '01')"
            );
            statement.executeQuery(
                "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                "(18, '123 Bedrock Rd.', 'Bedrock', 'HP', '01')"
            );
            statement.executeQuery(
                "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                "(27, '256 Granite Way', 'Limestone', 'HP', '02')"
            );
        
            // insert records into Enrolled table
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(9, 1)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(9, 3)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(9, 5)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(13, 1)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(13, 4)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(18, 2)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(18, 6)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(18, 7)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(27, 2)"
            );
            statement.executeQuery(
                "INSERT INTO Enrolled(id, courseId) VALUES " +
                "(27, 4)"
            );

            // insert records into Course table
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(1, 'Intro to Rocks')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(2, 'Intro to Stones')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(3, 'Intro to Gravel')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(4, 'Intro to Sand')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(5, 'Beginning Ice Age')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(6, 'Basic Tracking')"
            );
            statement.executeQuery(
                "INSERT INTO Course(courseId, courseDesc) VALUES " +
                "(7, 'Beginning Fire')"
            );
            
            // insert records into Major table
            statement.executeQuery(
                "INSERT INTO Major(majorId, majorDesc) VALUES " +
                "(1, 'Rocks')"
            );
            statement.executeQuery(
                "INSERT INTO Major(majorId, majorDesc) VALUES " +
                "(2, 'Stones')"
            );
            statement.executeQuery(
                "INSERT INTO Major(majorId, majorDesc) VALUES " +
                "(3, 'Gravel')"
            );
            statement.executeQuery(
                "INSERT INTO Major(majorId, majorDesc) VALUES " +
                "(4, 'Sand')"
            );
        
        
        } catch (SQLException e) {
            System.out.println("Error in data insertion: " + e);
        }
        
        // close the connection to database
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
