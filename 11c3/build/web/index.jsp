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
        <title>JSP Example:  Visit Counter v3.0</title>
    </head>
    <body>

    <h1>JSP Example:  Visit Counter v3.0</h1>
    
    <h2>
        <%! int count = 0; %>

        <%  count = count + 1;
            if (count == 1) { %>
                You are the first visitor to this page!<br>
        <%  } else { %>
                This page has been accessed <%= count %> times.<br>
        <%  } %>

    </h2>
    
    </body>
</html>
