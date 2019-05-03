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
            <table class="center">
                <tr>
                    New Opportunity Form
                </tr>
                <tr>
                    <td>Title</td>
                </tr>
                <tr>
                    <!-- title field -->
                    <td><input type = "text" name = "title" required><br></td>
                </tr>
                <tr>
                    <td>City</td>
                </tr>
                <tr>
                    <!-- city field -->
                    <td><input type = "text" name = "city" required><br></td>
                </tr>
                <tr>
                    <td>State</td>
                </tr>
                <tr>
                    <!-- State field -->
                    <td><input type = "text" name = "state" required><br></td>
                </tr>
                <tr>
                    <td>Description</td>
                </tr>
                <tr>
                    <!-- description field -->
                    <td><input type = "text" name = "description" required><br></td>
                </tr>
                <tr>
                    <td><button type="SUBMIT">SUBMIT</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
