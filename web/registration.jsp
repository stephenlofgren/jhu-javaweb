<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <html:base/>
    </head>
    <body style="background-color: white">
        <html:errors />
        <html:form action="registrationAction.do" method="post">
            <h1>Register here!</h1>
            Username: <html:text property="fullName" maxlength="30"/> <br/>
            Username: <html:text property="userName" maxlength="30"/> <br/>
            Password: <html:password property="password" maxlength="30" 
                           redisplay="false"/> 
            
            <br/><br/>
            
            <input type="submit" value="Register" />
            <input type="button" value="Cancel" 
                   onclick="window.location='Welcome.do'" />
        </html:form>
    </body>
</html:html>

