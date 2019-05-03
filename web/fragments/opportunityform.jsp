<%-- 
    Document   : opportunityform
    Created on : May 2, 2019, 10:09:08 PM
    Author     : Bert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Opportunity Form</title>
    </head>
    <body>
        <form action = "ProcessOpportunity" method = GET>
        <b>Contact Information</b>
        <br>
        <!-- title field -->
        Title: <input type = "text" name = "title" required><br>
        <!-- city field -->
        City: <input type = "text" name = "city" required><br>
        <!-- city field -->
        State <input type = "text" name = "state" required><br>
        <!-- description field -->
        Description: <input type = "text" name = "description" required><br>
        <button type="SUBMIT">SUBMIT</button>
    </body>
</html>
