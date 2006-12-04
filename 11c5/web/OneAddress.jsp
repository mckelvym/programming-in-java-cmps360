<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example of Database Retrieval</title>
    </head>
    <body>

    <%
        String url = "jdbc:mckoi://localhost:9157/BedrockU.conf?create=false";         
        String admin = "admin";
        String adminPw = "9999";
        String name   = "nobody";
        String street = "no where";
        String city   = "no place";
        String state  = "no thing";
        String zip    = "aint got no";
        String query;
        String stringId;
        int id = -1;

        stringId = request.getParameter("id");
        id = Integer.parseInt(stringId);
    
        Class.forName("com.mckoi.JDBCDriver").newInstance();
    
        java.sql.Connection connection 
            = java.sql.DriverManager.getConnection(url, admin, adminPw);

        java.sql.Statement statement = connection.createStatement();
    
        java.sql.ResultSet result;
 
        query = 
            "SELECT Student.name, Address.street, " + 	
            "Address.city, Address.state, Address.zip " +
            "FROM Student, Address " +
            "WHERE Student.id=" + id + 
            "  AND Student.id=Address.id";

        result = statement.executeQuery(query);
        if (result.next()) {
            name   = result.getString(1);
            street = result.getString(2);
            city   = result.getString(3);
            state  = result.getString(4);
            zip    = result.getString(5);
        }
    %>

    Student Info:<br>
    <%= name %><br>
    <%= street %><br>         
    <%= city %>, <%= state %> <%= zip %><br>         

    <%    
        result.close();
        statement.close();
        connection.close();
    %>    
    
    </body>
</html>
