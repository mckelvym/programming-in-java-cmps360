/*
 * MakeDB.java
 *
 * Created on February 8, 2004, 9:25 AM
 * Modified on December 2, 2006
 */

/**
 *
 * @author  fdd5501
 */

import java.sql.*;
import java.io.*;

public class MakeDB {
    
    public static void main(String[] args) {
        
        // Register Mckoi JDBC driver
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Cannot register driver: " + e);
            return;
        }
        
        // URL for local database with configuration file
        String url = "jdbc:mckoi:local://BedrockU.conf?create=true";
        
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
	    
	    

            FileReader reader = null;
            String line1, line2, line3, line4, line5; 
            String path;
	    System.out.println("starting data insertion");



            // insert records into Student table
            // statement.executeQuery(
            //     "INSERT INTO Student(id, name, majorId) VALUES " +
            //     "(9, 'Fred Flintstone', 1)"
            // );
            path = "student.data";
            try {
                reader = new FileReader(path);
                BufferedReader bReader = new BufferedReader(reader);
                while ((line1 = bReader.readLine()) != null &&
                       (line2 = bReader.readLine()) != null && 
                       (line3 = bReader.readLine()) != null) {
                    statement.executeQuery(
                        "INSERT INTO Student(id, name, majorId) VALUES " +
                        "(" + line1 + ", '" + line2 + "', " + line3 + ")"
                    );
                }
                bReader.close();
            } catch (IOException e) {
                System.out.println("Student IOException: " + e);
		System.exit(0);
            }
	    System.out.println("student data inserted");
            
	    
            
            // insert records into Address table
            // statement.executeQuery(
            //     "INSERT INTO Address(id, street, city, state, zip) VALUES " +
            //     "(09, '123 Bedrock Rd.', 'Bedrock', 'HP', '01')"
            // );
            path = "address.data";
            try {
                reader = new FileReader(path);
                BufferedReader bReader = new BufferedReader(reader);
                while ((line1 = bReader.readLine()) != null &&
                       (line2 = bReader.readLine()) != null && 
                       (line3 = bReader.readLine()) != null &&
                       (line4 = bReader.readLine()) != null &&
                       (line5 = bReader.readLine()) != null) {
                    statement.executeQuery(
                        "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                        "(" + line1 + ", '" + line2 + "', '" + line3 + "', '" +
			      line4 + "', '" + line5 + "')"
                    );
                }
                bReader.close();
            } catch (IOException e) {
                System.out.println("address IOException: " + e);
		System.exit(0);
            }
	    System.out.println("address data inserted");

        
            // insert records into Enrolled table
            // statement.executeQuery(
            //     "INSERT INTO Enrolled(id, courseId) VALUES " +
            //     "(9, 1)"
            // );
            path = "schedule.data";
            try {
                reader = new FileReader(path);
                BufferedReader bReader = new BufferedReader(reader);
                while ((line1 = bReader.readLine()) != null &&
                       (line2 = bReader.readLine()) != null) {
                    statement.executeQuery(
                        "INSERT INTO Enrolled(id, courseId) VALUES " +
                        "(" + line1 + ", " + line2 + ")"
                    );
                }
                bReader.close();
            } catch (IOException e) {
                System.out.println("schedule IOException: " + e);
		System.exit(0);
            }
	    System.out.println("schedule data inserted");


        
            // insert records into Course table
            // statement.executeQuery(
            //     "INSERT INTO Course(courseId, courseDesc) VALUES " +
            //     "(1, 'Intro to Rocks')"
            // );
            path = "course.data";
            try {
                reader = new FileReader(path);
                BufferedReader bReader = new BufferedReader(reader);
                while ((line1 = bReader.readLine()) != null &&
                       (line2 = bReader.readLine()) != null) {
                    statement.executeQuery(
                        "INSERT INTO Course(courseId, courseDesc) VALUES " +
                        "(" + line1 + ", '" + line2 + "')"
                    );
                }
                bReader.close();
            } catch (IOException e) {
                System.out.println("course IOException: " + e);
		System.exit(0);
            }
	    System.out.println("course data inserted");



            // insert records into Major table
            // statement.executeQuery(
            //     "INSERT INTO Major(majorId, majorDesc) VALUES " +
            //     "(1, 'Rocks')"
            // );
            path = "major.data";
            try {
                reader = new FileReader(path);
                BufferedReader bReader = new BufferedReader(reader);
                while ((line1 = bReader.readLine()) != null &&
                       (line2 = bReader.readLine()) != null) {
                    statement.executeQuery(
                        "INSERT INTO Major(majorId, majorDesc) VALUES " +
                        "(" + line1 + ", '" + line2 + "')"
                    );
                }
                bReader.close();
            } catch (IOException e) {
                System.out.println("major IOException: " + e);
		System.exit(0);
            }
	    System.out.println("major data inserted");



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
