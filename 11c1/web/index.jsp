<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example:  Visit Counter</title>
    </head>
    <body>

        <h1>JSP Example:  Visit Counter</h1>
    
        <h2>
            <%! int count = 0; %>
            <% count = count + 1; %>
            This page has been accessed <%= count %> times.
        </h2>
        
    </body>
</html>
