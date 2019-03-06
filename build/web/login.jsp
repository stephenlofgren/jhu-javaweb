<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <html:base/>
    </head>
    <body style="background-color: white">
        <html:errors />
        <html:form action="loginAction.do" method="post">
            <h1>Log in Here!</h1>
            Username: <html:text property="userName" maxlength="30"/> <br/>
            Password: <html:password property="password" maxlength="30" 
                           redisplay="false"/> 
            
            <br/><br/>

            <input type="submit" value="Login" /> 
            <input type="button" value="Cancel" 
                   onclick="window.location='Welcome.do'" />
            <br/>
            <a href="registration.jsp">Register</a>
        </html:form>

    </body>
</html:html>

